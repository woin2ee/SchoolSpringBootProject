package iducs.springboot.boot.service;

import iducs.springboot.boot.domain.Board;
import iducs.springboot.boot.domain.PageRequestDTO;
import iducs.springboot.boot.domain.PageResultDTO;
import iducs.springboot.boot.entity.BoardEntity;
import iducs.springboot.boot.entity.MemberEntity;

public interface BoardService {
    Long register(Board dto);
    PageResultDTO<Board, Object[]> getList(PageRequestDTO pageRequestDTO);

    default BoardEntity dtoToEntity(Board dto) {
        MemberEntity member = MemberEntity.builder()
                .seq(dto.getWriterSeq())
                .build();
        BoardEntity board = BoardEntity.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();
        return board;
    }

    default Board entityToDto(BoardEntity entity, MemberEntity member, Long replyCount) {
        Board dto = Board.builder()
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
        return dto;
    }
}
