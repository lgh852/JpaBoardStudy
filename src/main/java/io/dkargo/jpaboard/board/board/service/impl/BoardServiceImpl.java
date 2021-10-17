package io.dkargo.jpaboard.board.board.service.impl;

import io.dkargo.jpaboard.board.board.dto.request.ReqDeleteBoardDto;
import io.dkargo.jpaboard.board.board.repository.BoardCategoryRepository;
import io.dkargo.jpaboard.board.board.repository.BoardRepository;
import io.dkargo.jpaboard.board.board.service.BoardService;
import io.dkargo.jpaboard.board.board.dto.request.ReqCreateBoardDto;
import io.dkargo.jpaboard.board.board.dto.request.ReqUpdateBoardDto;
import io.dkargo.jpaboard.board.board.dto.response.ResCreateBoardDto;
import io.dkargo.jpaboard.board.board.dto.response.ResGetBoardDto;
import io.dkargo.jpaboard.board.board.dto.response.ResGetBoardListDto;
import io.dkargo.jpaboard.board.category.repository.CategoryRepository;
import io.dkargo.jpaboard.board.entity.*;
import io.dkargo.jpaboard.board.error.DkargoException;
import io.dkargo.jpaboard.board.error.ErrorCode;
import io.dkargo.jpaboard.board.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final BoardCategoryRepository boardCategoryRepository;

    public ResCreateBoardDto createBoard(ReqCreateBoardDto dto) {
        User user = findUserById(dto.getUserId());
        List<Category> categoryList = categoryRepository.findByIdIn(dto.getCategoryList());
        Board board = new Board(dto, user, categoryList);
        boardRepository.save(board);

        return new ResCreateBoardDto(board.getId());
    }

    public ResGetBoardListDto getBoardList(int page, int size) {
        PageRequest pr = new PageRequest(page, size, Sort.Direction.DESC);
        List<Board> boardList = boardRepository.findAll(pr.of()).getContent();

        long count = boardRepository.count();
        int totalPage = (int) ((count + size - 1) / size);

        return new ResGetBoardListDto(boardList, page, size, totalPage);
    }

    public ResGetBoardDto getBoardDetail(long boardId) {
        Board board = findBoardById(boardId);
        return new ResGetBoardDto(board);
    }

    public Boolean updateBoard(ReqUpdateBoardDto dto) {
        User user = findUserById(dto.getUserId());
        Board board = findBoardById(dto.getBoardId());
        List<Category> categoryList = categoryRepository.findByIdIn(dto.getCategoryList());
        orderIdMatch(user.getId(), board.getUser().getId());

        boardCategoryRepository.deleteAll(board.getBoardCategory());
        board.changeBoard(dto, categoryList);
        boardCategoryRepository.saveAll(board.getBoardCategory());

        return true;
    }

    @Override
    public Boolean deleteBoard(ReqDeleteBoardDto dto) {
        User user = findUserById(dto.getUserId());
        Board board = findBoardById(dto.getBoardId());

        orderIdMatch(user.getId(), board.getUser().getId());
        boardRepository.delete(board);

        return true;
    }

    public void orderIdMatch(Long reqOrderId, Long orderId) {
        if (orderId.equals(orderId) == false) {
            throw new DkargoException(ErrorCode.BOARD_MISS_MATCH_USER);
        }
    }

    public User findUserById(Long userId) {
        return userRepository.findById(userId).
                orElseThrow(() -> new DkargoException(ErrorCode.USER_NOT_FOUND));
    }

    public Board findBoardById(Long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new DkargoException(ErrorCode.BOARD_NOT_FOUND));
    }
}