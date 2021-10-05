package io.dkargo.jpaboard.board.board.service.impl;

import io.dkargo.jpaboard.board.board.repository.BoardRepository;
import io.dkargo.jpaboard.board.board.service.BoardService;
import io.dkargo.jpaboard.board.board.dto.request.ReqCreateBoardDto;
import io.dkargo.jpaboard.board.board.dto.request.ReqUpdateBoardDto;
import io.dkargo.jpaboard.board.board.dto.response.ResCreateBoardDto;
import io.dkargo.jpaboard.board.board.dto.response.ResGetBoardDetailDto;
import io.dkargo.jpaboard.board.board.dto.response.ResGetBoardListDto;
import io.dkargo.jpaboard.board.entity.Board;
import io.dkargo.jpaboard.board.entity.PageRequest;
import io.dkargo.jpaboard.board.entity.User;
import io.dkargo.jpaboard.board.error.DkargoException;
import io.dkargo.jpaboard.board.error.ErrorCode;
import io.dkargo.jpaboard.board.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public ResCreateBoardDto createBoard(ReqCreateBoardDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new DkargoException(ErrorCode.USER_NOT_FOUND));

        Board board = new Board(dto, user);
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

    public ResGetBoardDetailDto getBoardDetail(long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new DkargoException(ErrorCode.BOARD_NOT_FOUND));

        return new ResGetBoardDetailDto(board);

    }

    public Boolean updateBoard(ReqUpdateBoardDto dto) {
        Board board = boardRepository.findById(dto.getBoardId())
                .orElseThrow(() -> new DkargoException(ErrorCode.BOARD_NOT_FOUND));

        board.changeTitle(dto.getTitle());
        board.changeContent(dto.getContent());

        return true;
    }
}