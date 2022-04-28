package iducs.springboot.boot.service;

import iducs.springboot.boot.domain.Member;
import iducs.springboot.boot.domain.Memo;
import iducs.springboot.boot.entity.MemberEntity;
import iducs.springboot.boot.entity.MemoEntity;
import iducs.springboot.boot.repository.MemoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemoServiceImpl implements MemoService {
    final MemoRepository memoRepository;

    // Injection using Constructor vs. @Autowired
    public MemoServiceImpl(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    private MemoEntity dtoToEntity(Memo memo) {
        return MemoEntity.builder()
                .mno(memo.getMno())
                .memoText(memo.getMemoText())
                .build();
    }

    private Memo entityToDto(MemoEntity entity) {
        return Memo.builder()
                .mno(entity.getMno())
                .memoText(entity.getMemoText())
                .build();
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
        Memo memo = null;
        Optional<MemoEntity> result = memoRepository.findById(mno);
        if (result.isPresent()) {
            memo = Memo.builder()
                    .mno(result.get().getMno())
                    .memoText(result.get().getMemoText())
                    .build();
        }
        return memo;
    }

    @Override
    public List<Memo> readAll() {
        List<Memo> memos = new ArrayList<>();
        List<MemoEntity> entities = memoRepository.findAll();
        for (MemoEntity entity : entities) {
            memos.add(entityToDto(entity));
        }
        return memos;
    }

    @Override
    public void update(Memo memo) {
        MemoEntity entity = MemoEntity.builder()
                .mno(memo.getMno())
                .memoText(memo.getMemoText())
                .build();
        memoRepository.save(entity);
    }

    @Override
    public void delete(Memo memo) {
        memoRepository.deleteById(dtoToEntity(memo).getMno());
    }
}
