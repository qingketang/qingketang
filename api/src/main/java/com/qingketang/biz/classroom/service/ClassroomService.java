package com.qingketang.biz.classroom.service;

import com.qingketang.biz.classroom.dto.ClassroomCreateParams;
import com.qingketang.biz.classroom.dto.ClassroomDTO;

import java.util.Optional;

public interface ClassroomService {

    Optional<ClassroomDTO> get(Long id);

    ClassroomDTO create(ClassroomCreateParams params);

    void delete(Long id);
}
