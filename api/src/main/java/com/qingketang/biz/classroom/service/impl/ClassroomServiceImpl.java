package com.qingketang.biz.classroom.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.qingketang.biz.classroom.dto.ClassroomCreateParams;
import com.qingketang.biz.classroom.dto.ClassroomDTO;
import com.qingketang.biz.classroom.dto.ClassroomSearchParams;
import com.qingketang.biz.classroom.entity.Classroom;
import com.qingketang.biz.classroom.entity.QClassroom;
import com.qingketang.biz.classroom.mapper.ClassroomMapper;
import com.qingketang.biz.classroom.repository.ClassroomRepository;
import com.qingketang.biz.classroom.service.ClassroomService;
import com.qingketang.common.AppException;
import com.qingketang.common.ErrorCode;
import com.qingketang.common.HumanBase32;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.Optional;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository repo;

    private final ClassroomMapper mapper;

    final Validator validator;

    public ClassroomServiceImpl(ClassroomRepository repo, ClassroomMapper mapper, Validator validator) {
        this.repo = repo;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public Optional<ClassroomDTO> get(Long id) {
        return repo.findById(id).map(mapper::toDto);
    }

    @Override
    public ClassroomDTO create(ClassroomCreateParams params) {
        var violations = validator.validate(params);
        if (!violations.isEmpty()) {
            throw new AppException(ErrorCode.INVALID_ARGUMENT, violations);
        }

        var cr = new Classroom();
        cr.setName(params.getName());
        // 先填充一个UUID占位，以符合数据库对No字段的唯一性约束
        cr.setNo(IdUtil.fastSimpleUUID());
        cr.setUserNum(0L);
        repo.save(cr);

        // 简化No，使用32进制，便于人类识别
        // @see https://www.crockford.com/base32.html
        cr.setNo(HumanBase32.encode(cr.getId(), false, 4, 0));
        repo.save(cr);

        return mapper.toDto(cr);
    }

    @Override
    public void changeName(Long id, String name) {
        var violations = validator.validateValue(ClassroomCreateParams.class, "name", name);
        if (!violations.isEmpty()) {
            throw new AppException(ErrorCode.INVALID_ARGUMENT, violations);
        }

        var classroom = repo.findById(id).orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND, "课堂不存在"));
        classroom.setName(name);

        repo.save(classroom);
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
