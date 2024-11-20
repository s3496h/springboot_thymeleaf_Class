package com.example.basic.comment;

import com.example.basic.answer.Answer;
import com.example.basic.qusetion.Question;
import com.example.basic.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private  CommentRepository commentRepository;

    public Comment createForQuestion(Integer questionId, String content, SiteUser author) {

        Comment comment = new Comment();
        comment.setQuestion(questionId); // Question 엔티티 참조
        comment.setContent(content);
        comment.setAuthor(author);
        comment.setCreateDate(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    public Comment createForAnswer(Answer answer, String content, SiteUser author) {
        Comment comment = new Comment();
        comment.setAnswer(answer); // Answer 엔티티 참조
        comment.setContent(content);
        comment.setAuthor(author);
        comment.setCreateDate(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsForQuestion(Integer questionId) {
        return commentRepository.findByQuestionId(questionId);
    }

    public List<Comment> getCommentsForAnswer(Integer answerId) {
        return commentRepository.findByAnswerId(answerId);
    }
}
