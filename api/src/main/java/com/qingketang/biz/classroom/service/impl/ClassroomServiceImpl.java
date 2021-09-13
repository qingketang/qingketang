package com.qingketang.biz.classroom.service.impl;

import cn.hutool.core.util.StrUtil;
import com.qingketang.biz.classroom.dto.ClassroomCreateParams;
import com.qingketang.biz.classroom.dto.ClassroomDTO;
import com.qingketang.biz.classroom.dto.ClassroomSearchParams;
import com.qingketang.biz.classroom.entity.Classroom;
import com.qingketang.biz.classroom.entity.QClassroom;
import com.qingketang.biz.classroom.mapper.ClassroomMapper;
import com.qingketang.biz.classroom.repository.ClassroomRepository;
import com.qingketang.biz.classroom.service.ClassroomService;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<ClassroomDTO> search(ClassroomSearchParams params, Pageable pageable) {
        var q = QClassroom.classroom;
        var builder = new BooleanBuilder();

        if (StrUtil.isNotEmpty(params.getNo())) {
            builder.and(q.no.eq(params.getNo()));
        }

        if (StrUtil.isNotEmpty(params.getName())) {
            builder.and(q.no.like(params.getName() + "%"));
        }

        return repo.findAll(builder, pageable).map(mapper::toDto);
    }
}
