package iducs.springboot.boot.service;

import iducs.springboot.boot.domain.Board;
import iducs.springboot.boot.domain.PageRequestDTO;
import iducs.springboot.boot.domain.PageResultDTO;
import iducs.springboot.boot.entity.BoardEntity;
import iducs.springboot.boot.entity.MemberEntity;
import iducs.springboot.boot.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@Log4j2
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Long register(Board dto) {
        log.info("board register : " + dto);
        BoardEntity boardEntity = dtoToEntity(dto);
        boardRepository.save(boardEntity);
        return boardEntity.getBno();
    }

    @Override
    public PageResultDTO<Board, Object[]> getList(PageRequestDTO pageRequestDTO) {
        log.info(">>>>>" + pageRequestDTO);
        Function<Object[], Board> fn =
                (entities -> entityToDto((BoardEntity) entities[0], (MemberEntity) entities[1], (Long) entities[2]));
        Page<Object[]> result =
                boardRepository.getBoardWithReplyCount(pageRequestDTO.getPageable(Sort.by("bno").descending()));
        return new PageResultDTO<>(result, fn);
    }
}
