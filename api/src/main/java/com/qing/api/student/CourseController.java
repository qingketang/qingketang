package com.qing.api.student;

import com.qing.api.BaseController;
import com.qing.core.api.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student/course")
public class CourseController extends BaseController {
    @GetMapping("/test")
    public CommonResponse test() {
        return CommonResponse.success();
    }
}
