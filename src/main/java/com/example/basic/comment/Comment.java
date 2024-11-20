package com.example.basic.comment;

import com.example.basic.answer.Answer;
import com.example.basic.qusetion.Question;
import com.example.basic.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Question question; // 댓글이 속한 질문

    @ManyToOne
    private Answer answer; // 댓글이 속한 답변

    @ManyToOne
    private SiteUser author; // 댓글 작성자

    @Column(columnDefinition = "TEXT")
    private String content; // 댓글 내용

    private LocalDateTime createDate; // 작성일
    private LocalDateTime modifyDate; // 수정일

}
