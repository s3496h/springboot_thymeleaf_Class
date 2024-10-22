package com.example.basic;

import com.example.basic.answer.Answer;
import com.example.basic.answer.AnswerRepository;
import com.example.basic.qusetion.Question;
import com.example.basic.qusetion.QuestionRepository;
import com.example.basic.qusetion.QuestionService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SpringBasicApplicationTests {

    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestionService questionService;

    @Test
    void testJpa() {
        for (int i = 1; i <= 300; i++) {
            String subject = String.format("테스트 데이터 입니다[%03d]", i);
            String content = "내용무";
            this.questionService.create(subject,content);
        }
    }
}

