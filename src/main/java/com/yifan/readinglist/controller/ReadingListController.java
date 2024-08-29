package com.yifan.readinglist.controller;

import com.yifan.readinglist.entity.Book;
import com.yifan.readinglist.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * package_name: com.yifan.readinglist.controller
 * author: wyifa
 * date: 2024/8/29
 * description:
 */
@Controller
@RequestMapping("/user")
public class ReadingListController {

    private ReadingListRepository readingListRepository;

    /* use constructor injection*/
    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    @GetMapping(value = "/{reader}")
    String readersBooks(@PathVariable("reader") String reader,
                        Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (!readingList.isEmpty()) {
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    @PostMapping(value = "/{reader}")
    String addToReadingList(@PathVariable("reader")String reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }
}
