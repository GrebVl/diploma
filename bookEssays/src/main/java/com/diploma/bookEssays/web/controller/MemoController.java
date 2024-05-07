package com.diploma.bookEssays.web.controller;

import com.diploma.bookEssays.entity.memo.Memo;
import com.diploma.bookEssays.service.MemoService;
import com.diploma.bookEssays.web.dto.MemoDto;
import com.diploma.bookEssays.web.mapper.MemoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/memos")
@RequiredArgsConstructor
@Validated
public class MemoController {

    private final MemoService memoService;
    private final MemoMapper memoMapper;

    @PutMapping
    @PreAuthorize("canAccessMemo(#dto.id)")
    public MemoDto update(@RequestBody MemoDto dto) {
        Memo memo = memoMapper.toEntity(dto);
        Memo updatedMemo = memoService.updateMemo(memo);
        return memoMapper.toDto(updatedMemo);
    }

    @GetMapping("/{id}")
    @PreAuthorize("canAccessMemo(#id)")
    public MemoDto getById(@PathVariable final Long id) {
        Memo task = memoService.getById(id);
        return memoMapper.toDto(task);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("canAccessMemo(#id)")
    public void deleteById(@PathVariable final Long id) {
        memoService.deleteMemo(id);
    }
}
