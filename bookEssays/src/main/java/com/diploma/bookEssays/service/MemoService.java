package com.diploma.bookEssays.service;

import com.diploma.bookEssays.entity.memo.Memo;

import java.util.List;

public interface MemoService {

    Memo createMemo(Memo memo, Long userId);

    List<Memo> getAllByUserId(Long id);

    Memo getById(Long id);

    Memo updateMemo(Memo memo);

    void deleteMemo(Long id);
}
