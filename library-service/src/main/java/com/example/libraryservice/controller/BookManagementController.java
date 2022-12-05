package com.example.libraryservice.controller;

import com.example.libraryservice.model.Book;
import com.example.libraryservice.service.JunkService;
import com.example.libraryservice.service.LibraryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/lib")
public class BookManagementController {

    private final LibraryServiceImpl libraryService;
    private final JunkService junkService;

    @Autowired
    public BookManagementController(LibraryServiceImpl libraryService, JunkService junkService) {
        this.libraryService = libraryService;
        this.junkService = junkService;
    }

    @GetMapping("")
    @ResponseBody
    public String sayHello() {
        return "Welcome to module working with MongoDB";
    }

    @GetMapping("/all-books")
    public ModelAndView getAllBooks() {
        ModelAndView mv = new ModelAndView("show_library_books");
        List<Book> books = libraryService.getAllBooks();
        mv.addObject("books", books);
        System.out.println("reloaded");
        return mv;
    }

    @GetMapping("/home")
    public String getHomePage() {
        return "home";
    }

    @GetMapping("/lib/home")
    public String getHomePageRep() {
        return "home";
    }

    @DeleteMapping("/delete")
    public String deleteSomething(InputStream stream) {
        System.out.println("Zo");
        String result = convertStreamToString(stream);
        System.out.println("Response: " + result);
        String [] getTitleAndAction = junkService.convertJsonToString(result);
        System.out.println(Arrays.toString(getTitleAndAction));

        if (getTitleAndAction[1].equals("borrow")) {
            Book book = libraryService.findBookByTitle(getTitleAndAction[0]);
            System.out.println(book);
            if (book.getCount() == 0) {
                libraryService.removeBookByTitle(getTitleAndAction[0]);
            } else {
                libraryService.reduceBookByOne(getTitleAndAction[0], book.getCount());
            }
        } else if (getTitleAndAction[1].equals("delet")) {
            System.out.println("Clicked delete");
            Book book = libraryService.findBookByTitle(getTitleAndAction[0]);
            System.out.println(book);
            libraryService.removeBookByTitle(getTitleAndAction[0]);
        }

        return "show_library_books";        // Just for fun!
    }

    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
