package com.diploma.bookEssays.service.impl;

import com.diploma.bookEssays.entity.exception.ResourceNotFoundException;
import com.diploma.bookEssays.entity.memo.Memo;
import com.diploma.bookEssays.repository.MemoRepository;
import com.diploma.bookEssays.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Реализация сервиса конспектов
 */

@Service
@RequiredArgsConstructor
public class MemoServiceImpl implements MemoService {
    public static final String NOT_FOUND_MESSAGE = "Memo not found.";

    /**
     * Репозиторий конспектов
     */
    private final MemoRepository memoRepository;

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "MemoService::getById", key = "#id")
    public Memo getById(final Long id) {
        return memoRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_MESSAGE));
    }


    @Override
    @Transactional(readOnly = true)
    public List<Memo> getAllByUserId(Long id) {
        return memoRepository.findAllByUserId(id);
    }

    @Override
    @Transactional
    @CachePut(value = "MemoService::getById", key = "#memo.id")
    public Memo updateMemo(final Memo memo) {
        memoRepository.save(memo);
        return memo;
    }

    @Override
    @Transactional
    @Cacheable(
            value = "MemoService::getById",
            condition = "#memo.id!=null",
            key = "#memo.id"
    )
    public Memo createMemo(final Memo memo, final Long userId) {
        memoRepository.save(memo);
        memoRepository.assignMemo(userId, memo.getId());
        return memo;
    }

    @Override
    @Transactional
    @Cacheable(value = "MemoService::getById", key = "#id")
    public void deleteMemo(final Long id) {
        memoRepository.deleteById(id);
    }
}
