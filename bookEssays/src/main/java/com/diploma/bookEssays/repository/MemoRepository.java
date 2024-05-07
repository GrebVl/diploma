package com.diploma.bookEssays.repository;

import com.diploma.bookEssays.entity.memo.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemoRepository  extends JpaRepository<Memo, Long> {

    @Query(value = """
            SELECT * FROM memos m
            JOIN users_memos ut ON ut.memo_id = m.id
            WHERE ut.user_id = :userId
            """, nativeQuery = true)
    List<Memo> findAllByUserId(Long userId);

    @Modifying
    @Query(value = """
            INSERT INTO users_memos (user_id, memo_id)
                        VALUES (:userId, :memoId)
            """, nativeQuery = true)
    void assignMemo(Long userId, Long memoId);
}
