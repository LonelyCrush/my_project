package com.xzit.demo.joinpoint.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.lang3.ObjectUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author leizefeng
 */
@Aspect
@Component
@Slf4j
public class PointAspect {

    private static final String POINT_CUT = "PointService()";

    @Pointcut("execution(* com.xzit.demo.joinpoint.service..*(..))")
    public void PointService() {
    }

    @Before(POINT_CUT)
    public void beforePointService(JoinPoint joinPoint) throws JsonProcessingException {
        System.out.println("------------Before PointService() begin------------");

        Signature signature = joinPoint.getSignature();
        if (signature instanceof MethodSignature) {
            MethodSignature methodSignature = (MethodSignature) signature;
            System.out.println("Target: " + joinPoint.getTarget().getClass().getName());
            System.out.println("Method: " + methodSignature.getName());
            System.out.println("Parameters: " + Arrays.toString(methodSignature.getParameterNames()));
            System.out.println("Args: " + Arrays.toString(joinPoint.getArgs()));
            for (int i = 0; i < methodSignature.getParameterNames().length; i++) {
                HashMap<String, Object> map = new HashMap<>();
                BeanMap beanMap = new BeanMap(joinPoint.getArgs()[i]);
                if (!CollectionUtils.isEmpty(beanMap)) {
                    for (Object key : beanMap.keySet()) {
                        map.put(key + "", beanMap.get(key));
                    }
//                    map.remove("class");
                    String json = new ObjectMapper().writeValueAsString(map);
                    log.info("{} : {}", methodSignature.getParameterNames()[i], json);
                }
            }
        }

        System.out.println("------------Before PointService() end------------");

    }
}
