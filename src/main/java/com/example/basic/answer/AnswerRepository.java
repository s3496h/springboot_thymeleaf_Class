package com.example.basic.answer;

import com.example.basic.qusetion.Question;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    @Query("select distinct a "
            + "from Answer a "
            + "left join a.author u1 "
            + "left join a.question q "
            + "left join q.author u2 "
            + "where "
            + "q.subject like %:kw% "
            + "or q.content like %:kw% "
            + "or u1.username like %:kw% "
            + "or a.content like %:kw% "
            + "or u2.username like %:kw%")
    Page<Answer> findAllByKeyword(@Param("kw") String kw, Pageable pageable);

}
