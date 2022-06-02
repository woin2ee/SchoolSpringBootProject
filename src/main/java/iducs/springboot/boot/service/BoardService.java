package iducs.springboot.boot.service;

import iducs.springboot.boot.domain.Board;
import iducs.springboot.boot.domain.PageRequestDTO;
import iducs.springboot.boot.domain.PageResultDTO;
import iducs.springboot.boot.entity.BoardEntity;
import iducs.springboot.boot.entity.MemberEntity;

public interface BoardService {
    Long register(Board board);
    PageResultDTO<Board, Object[]> getList(PageRequestDTO pageRequestDTO);

    Board getById(Long bno);
    Long modify(Board board);
    void deleteWithRepliesById(Long bno);

    default BoardEntity dtoToEntity(Board board) {
        MemberEntity memberEntity = MemberEntity.builder()
                .seq(board.getWriterSeq())
                .build();
        BoardEntity boardEntity = BoardEntity.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(memberEntity)
                .build();
        return boardEntity;
    }

    default Board entityToDto(BoardEntity entity, MemberEntity member, Long replyCount) {
        Board board = Board.builder()
                .bno(entity.getBno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writerSeq(member.getSeq())
                .writerId(member.getId())
                .writerName(member.getName())
                .writerEmail(member.getEmail())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .replyCount(replyCount.intValue())
                .build();
        return board;
    }
}
