package com.qingketang.biz.classroom.repository;

import com.qingketang.biz.classroom.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ClassroomRepository extends JpaRepository<Classroom, Long>, QuerydslPredicateExecutor<Classroom> {
}
