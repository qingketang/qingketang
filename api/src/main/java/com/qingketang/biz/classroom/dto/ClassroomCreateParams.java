package com.qingketang.biz.classroom.dto;
import org.hibernate.validator.constraints.Length;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ClassroomCreateParams {
    @NotEmpty
    @Length(min = 2, max = 256)
    private String name;
}
