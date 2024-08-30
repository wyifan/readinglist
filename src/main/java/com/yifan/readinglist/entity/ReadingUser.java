package com.yifan.readinglist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


/**
 * package_name: com.yifan.readinglist.entity
 * author: wyifa
 * date: 2024/8/30
 * description:
 */
@Entity
@Data
public class ReadingUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String roles;
}
