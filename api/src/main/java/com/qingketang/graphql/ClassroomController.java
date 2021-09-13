package com.qingketang.graphql;

import com.qingketang.biz.classroom.dto.ClassroomCreateParams;
import com.qingketang.biz.classroom.dto.ClassroomDTO;
import com.qingketang.biz.classroom.service.ClassroomService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class ClassroomController {

    private final ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @QueryMapping
    public Optional<ClassroomDTO> classroom(@Argument Long id) {
        return classroomService.get(id);
    }

    @MutationMapping
    public ClassroomDTO createClassroom(@Argument ClassroomCreateParams params) {
        return classroomService.create(params);
    }

    @MutationMapping
    public Boolean deleteClassroom(@Argument Long id) {
        classroomService.delete(id);
        return true;
    }
}
