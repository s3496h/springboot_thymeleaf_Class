package com.example.basic;

import com.example.basic.qusetion.Question;
import com.example.basic.qusetion.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SpringBasicApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void testJpa() {
    Optional<Question> oq = this.questionRepository.findById(1);
	assertTrue(oq.isPresent());
	Question q = oq.get();
	q.setSubject("수정된 제목");
	this.questionRepository.save(q);
	}
}
