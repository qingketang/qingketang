package com.qingketang.biz.classroom.service.impl;

import com.qingketang.biz.classroom.dto.ClassroomCreateParams;
import com.qingketang.biz.classroom.dto.ClassroomDTO;
import com.qingketang.biz.classroom.entity.Classroom;
import com.qingketang.biz.classroom.mapper.ClassroomMapper;
import com.qingketang.biz.classroom.repository.ClassroomRepository;
import com.qingketang.biz.classroom.service.ClassroomService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository repo;

    private final ClassroomMapper mapper;

    public ClassroomServiceImpl(ClassroomRepository repo, ClassroomMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public Optional<ClassroomDTO> get(Long id) {
        return repo.findById(id).map(mapper::toDto);
    }

    @Override
    public ClassroomDTO create(ClassroomCreateParams params) {
        var cr = new Classroom();
        cr.setName(params.getName());
        cr.setNo(params.getNo());
        cr.setUserNum(0L);
        repo.save(cr);

        return mapper.toDto(cr);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
