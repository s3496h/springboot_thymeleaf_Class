package com.example.basic.comment;

import com.example.basic.answer.Answer;
import com.example.basic.qusetion.Question;
import com.example.basic.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentService {
    private CommnetRepository commnetRepository;

    public Comment getComment(Comment comment , String content, SiteUser author, Question question, Answer answer){
        Comment coment = new Comment();
        coment.setCreateDate(LocalDateTime.now());
        coment.setUpdateDate(LocalDateTime.now());
        coment.setContent(content);
        coment.setQuestion(question);
        coment.setAnswer(answer);
        coment.setAuthor(author);
        this.commnetRepository.save(comment);
        return coment;
    }

    }