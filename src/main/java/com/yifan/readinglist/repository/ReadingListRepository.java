package com.yifan.readinglist.repository;

import com.yifan.readinglist.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * package_name: com.yifan.readinglist.repository
 * author: wyifa
 * date: 2024/8/29
 * description:
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(String reader);
}

