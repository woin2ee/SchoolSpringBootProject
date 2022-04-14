package iducs.springboot.boot.service;

import iducs.springboot.boot.domain.Memo;

import java.util.List;

public interface MemoService {
    void create(Memo memo);
    Memo readById(Long mno);
    List<Memo> readAll();
    void update(Memo memo);
    void delete(Memo memo);
}
