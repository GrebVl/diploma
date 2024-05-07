package com.diploma.bookEssays.web.controller;

import com.diploma.bookEssays.entity.memo.Memo;
import com.diploma.bookEssays.entity.user.User;
import com.diploma.bookEssays.service.MemoService;
import com.diploma.bookEssays.service.UserService;
import com.diploma.bookEssays.web.dto.MemoDto;
import com.diploma.bookEssays.web.dto.UserDto;
import com.diploma.bookEssays.web.mapper.MemoMapper;
import com.diploma.bookEssays.web.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    private final MemoService memoService;
    private final MemoMapper memoMapper;


    @PutMapping
    @PreAuthorize("@customSecurityExpression.canAccessUser(#dto.id)")
    public UserDto updated(@RequestBody final UserDto dto) {
        User user = userMapper.toEntity(dto);
        User updated = userService.updateUser(user);
        return userMapper.toDto(updated);
    }

    @GetMapping("/{id}")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    public UserDto getById(@PathVariable final Long id) {
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    public void deleteById(@PathVariable final Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}/memos")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    public List<MemoDto> getMemoByUserId(@PathVariable final Long id) {
        List<Memo> memos = memoService.getAllByUserId(id);
        return memoMapper.toDto(memos);
    }

    @PostMapping("/{id}/memos")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    public MemoDto createMemo(@PathVariable final Long id,
                              @RequestBody final MemoDto dto) {
        Memo memo = memoMapper.toEntity(dto);
        Memo createdMemo = memoService.createMemo(memo, id);
        return memoMapper.toDto(createdMemo);
    }
}
