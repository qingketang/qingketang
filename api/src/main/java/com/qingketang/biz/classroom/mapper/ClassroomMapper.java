package com.qingketang.biz.classroom.mapper;

import com.qingketang.biz.classroom.dto.ClassroomDTO;
import com.qingketang.biz.classroom.entity.Classroom;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClassroomMapper {
    ClassroomDTO toDto(Classroom classroom);
}
