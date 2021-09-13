package com.qingketang.biz.classroom.service;

import com.qingketang.biz.classroom.dto.ClassroomCreateParams;
import com.qingketang.biz.classroom.dto.ClassroomDTO;
import com.qingketang.biz.classroom.dto.ClassroomSearchParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ClassroomService {

    Optional<ClassroomDTO> get(Long id);

    ClassroomDTO create(ClassroomCreateParams params);

    void delete(Long id);

    Page<ClassroomDTO> search(ClassroomSearchParams params, Pageable pageable);
}
