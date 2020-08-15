package com.qby.springboot;

import com.qby.springboot.bean.Employee;
import com.qby.springboot.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBoot01CacheApplicationTests {
    @Autowired
    private EmployeeMapper employeeMapper;


    @Test
    void contextLoads() {

        Employee empById = employeeMapper.getEmpById(1);
        System.out.println(empById);
    }

}
