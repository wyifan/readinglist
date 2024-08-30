package com.yifan.readinglist.global;

/**
 * package_name: com.yifan.readinglist.global
 * author: wyifa
 * date: 2024/8/30 20:51
 * description:
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        mav.addObject("error", "Internal Server Error");
        mav.addObject("message", ex.getMessage());
        mav.setViewName("error");
        return mav;
    }

    @RequestMapping("/403")
    public String accessDenied() {
        return "403";
    }
}

