package com.diploma.bookEssays.repository;

import com.diploma.bookEssays.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    @Query(value = """
            SELECT exists(
                          SELECT 1
                          FROM users_tasks
                          WHERE user_id = :userId AND memo_id = :memoId)
            """, nativeQuery = true)
    boolean isMemoOwner(Long userId, Long memoId);
}
