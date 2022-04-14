package iducs.springboot.boot.service;

import iducs.springboot.boot.domain.Memo;
import iducs.springboot.boot.entity.MemoEntity;
import iducs.springboot.boot.repository.MemoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoServiceImpl implements MemoService {
    final MemoRepository memoRepository;
    // Injection using Constructor
    public MemoServiceImpl(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    @Override
    public void create(Memo memo) {
        // DTO(Controller -> Service) -> Entity (Service -> Repository 에서 동작)
        MemoEntity entity = MemoEntity.builder()
                .mno(memo.getMno())
                .memoText(memo.getMemoText())
                .build();
        // new MemoEntity(mno, memoText);
        memoRepository.save(entity);
    }

    @Override
    public Memo readById(Long mno) {
        return null;
    }

    @Override
    public List<Memo> readAll() {
        return null;
    }

    @Override
    public void update(Memo memo) {

    }

    @Override
    public void delete(Memo memo) {

    }
}
