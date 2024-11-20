package com.example.basic.comment;

import com.example.basic.user.SiteUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/question/{questionId}")
    public String addCommentToQuestion(
            @PathVariable Long questionId,
            @RequestParam String content,
            Principal principal
    ) {
        commentService.createForQuestion(questionId, content, getCurrentUser(principal));
        return "redirect:/question/detail/" + questionId;
    }

    @PostMapping("/answer/{answerId}")
    public String addCommentToAnswer(
            @PathVariable Long answerId,
            @RequestParam String content,
            Principal principal
    ) {
        commentService.createForAnswer(answerId, content, getCurrentUser(principal));
        return "redirect:/question/detail/" + answerId; // 적절한 URL로 수정
    }

    private SiteUser getCurrentUser(Principal principal) {
        // 현재 로그인한 사용자 가져오는 로직 (ex: Security Context)
        return new SiteUser(principal.getName()); // 적절히 구현
    }
}