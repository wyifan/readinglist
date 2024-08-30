package com.yifan.readinglist.repository;

import com.yifan.readinglist.entity.ReadingUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * package_name: com.yifan.readinglist.repository
 * author: wyifa
 * date: 2024/8/30
 * description:
 */
public interface ReadingUserRepository extends JpaRepository<ReadingUser, Long> {
    Optional<ReadingUser> findByUsername(String username);
}
