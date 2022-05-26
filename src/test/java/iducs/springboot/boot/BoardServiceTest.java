package iducs.springboot.boot;

import iducs.springboot.boot.domain.Board;
import iducs.springboot.boot.domain.PageRequestDTO;
import iducs.springboot.boot.domain.PageResultDTO;
import iducs.springboot.boot.entity.BoardEntity;
import iducs.springboot.boot.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;
import java.util.stream.IntStream;

@SpringBootTest
public class BoardServiceTest {
    @Autowired
    BoardService boardService;

//    @Test
    public void testRegister() {
        IntStream.rangeClosed(1, 47).forEach(i -> {
            Board dto = Board.builder()
                    .title("title" + i)
                    .content("Content...")
                    .writerSeq(Long.valueOf("" + i))
                    .build();
            Long bno = boardService.register(dto);
        });
    }

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        pageRequestDTO.setPage(2);
        PageResultDTO<Board, Object[]> result = boardService.getList(pageRequestDTO);
        for(Board dto : result.getDtoList())
            System.out.println(dto.getBno() + " : " + dto.getTitle());
    }
}
