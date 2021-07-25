package com.qing.core.aspect;

import cn.hutool.json.JSONUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
@Order(1)
public class WebLogAspect {
    @Pointcut("execution(public * com.qing.api.teacher.*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore() {
    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Object result = joinPoint.proceed();

        WebLog webLog = new WebLog(
                request.getRemoteUser(),
                request.getRemoteAddr(),
                request.getMethod(),
                request.getRequestURL().toString(),
                Arrays.toString(joinPoint.getArgs()),
                geDescription(joinPoint.getSignature()),
                System.currentTimeMillis()
        );

        log.info("{}", JSONUtil.parse(webLog));
        return result;
    }

    @AfterReturning(value = "webLog()", returning = "ret")
    public void doAfterReturning(Object ret) throws Throwable {
    }

    private String geDescription(Signature signature) {
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method.isAnnotationPresent(ApiOperation.class)) {
            return method.getAnnotation(ApiOperation.class).value();
        }

        return "";
    }
}
