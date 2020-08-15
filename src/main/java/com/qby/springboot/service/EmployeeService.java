package com.qby.springboot.service;

import com.qby.springboot.bean.Employee;
import com.qby.springboot.mapper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qby
 * @date 2020/8/15 17:48
 */
@Service
@Slf4j
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public Employee getEmp(Integer id) {
        log.info("查询:{}号员工", id);
        return employeeMapper.getEmpById(id);
    }
}
