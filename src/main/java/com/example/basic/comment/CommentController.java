package com.example.basic.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    public String CreateComment(Model model, @PathVariable("id") Integer id, Principal principal) {


        return "";
    }

}
