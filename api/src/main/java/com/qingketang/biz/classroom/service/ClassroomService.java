package com.qingketang.biz.classroom.service;

import com.qingketang.biz.classroom.dto.ClassroomDTO;

import java.util.Optional;

public interface ClassroomService {

    Optional<ClassroomDTO> get(Long id);
}
