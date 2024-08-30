package com.yifan.readinglist.services;

import com.yifan.readinglist.entity.ReadingUser;
import com.yifan.readinglist.repository.ReadingUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * package_name: com.yifan.readinglist.services
 * author: wyifa
 * date: 2024/8/30
 * description:
 */
@Service("myUserService")
public class ReadingUserDetailService implements UserDetailsService {

    private final ReadingUserRepository readingUserRepository;

    @Autowired
    public ReadingUserDetailService(ReadingUserRepository readingUserRepository) {
        this.readingUserRepository = readingUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ReadingUser> readingUser = readingUserRepository.findByUsername(username);
        if (readingUser.isPresent()) {
            var user = readingUser.get();
            return User.builder().username(user.getUsername()).password(user.getPassword()).roles(getRoles(user.getRoles())).build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }

    private String[] getRoles(String roles) {
        if (!StringUtils.hasLength(roles)) {
            return new String[]{"USER"};
        }
        return roles.split(",");
    }
}
