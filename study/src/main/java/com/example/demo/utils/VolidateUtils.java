package com.example.demo.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.Set;

/**
 * @author
 * @date
 */
public class VolidateUtils {
    private <T> void validate(T test, Class... group) throws Exception {
        System.out.println("手动触发校验开始");
        Set<ConstraintViolation<T>> validate = Validation.buildDefaultValidatorFactory().getValidator().validate(test, group);
        System.out.println(validate);
        System.out.println("校验通过");
    }
}
