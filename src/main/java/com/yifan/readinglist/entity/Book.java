package com.yifan.readinglist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * package_name: com.yifan.readinglist.entity
 * author: wyifa
 * date: 2024/8/29
 * description:
 *      @Entity 注解：
 * 属于 Java Persistence API（JPA），是一个规范，而 Hibernate 是该规范的一个实现。
 * @Entity 注解标识一个类是一个实体类，并且与数据库中的表相对应。
 * 使用 @Entity 注解的类通常具有以下特点：
 * 映射到数据库表的字段
 * 可能使用 JPA 的其他注解（如 @Id、@Column、@OneToMany 等）来设置主键、列名或表间关系
 * 简而言之，@Entity 注解用于定义实体类与数据库表的映射关系，用于持久化操作。
 */
@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reader;
    private String title;
    private String author;
    private String isbn;
    private String description;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getReader() {
//        return reader;
//    }
//
//    public void setReader(String reader) {
//        this.reader = reader;
//    }
//
//    public String getIsbn() {
//        return isbn;
//    }
//
//    public void setIsbn(String isbn) {
//        this.isbn = isbn;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }

}

