package com.example.demo.volidateTest;

import com.example.demo.ListenerApplicationTests;
import com.example.demo.entity.UserTest;
import com.example.demo.utils.InsertGroup;
import org.junit.jupiter.api.Test;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import java.util.Set;

/**
 * validate校验测试
 *
 * @author
 * @date
 */
public class VolidateTest extends ListenerApplicationTests {


    @Test
    public void volidate1() {
        UserTest userTest = new UserTest();
        //userTest.setId(0L);
        userTest.setName("");
        userTest.setAge(2);
        userTest.setEmail("123");
        try {
            System.out.println(this);
            this.test1(userTest, InsertGroup.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void test(@Validated UserTest userTest) {
        System.out.println("校验通过");
    }

    private void test1(UserTest userTest, Class... group) throws Exception {
        System.out.println("手动触发校验开始");
        Set<ConstraintViolation<@Valid UserTest>> validate = Validation.buildDefaultValidatorFactory().getValidator().validate(userTest, group);
        //validate.forEach(userTestConstraintViolation -> {
        //    System.out.println(userTestConstraintViolation.getMessage());
        //    @Valid UserTest rootBean = userTestConstraintViolation.getRootBean();
        //    Class<? extends @Valid UserTest> aClass = rootBean.getClass();
        //    try {
        //        Field field = aClass.getField(userTestConstraintViolation.getPropertyPath().toString());
        //        field.set(rootBean, "2");
        //    } catch (NoSuchFieldException e) {
        //        e.printStackTrace();
        //    } catch (IllegalAccessException e) {
        //        e.printStackTrace();
        //    }
        //    String name = aClass.getName();
        //});
        System.out.println(validate);
        System.out.println(userTest + "时间");
        System.out.println("校验通过");
    }
}
