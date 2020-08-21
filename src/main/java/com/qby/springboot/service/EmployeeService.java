package com.qby.springboot.service;

import com.qby.springboot.bean.Employee;
import com.qby.springboot.mapper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author qby
 * @date 2020/8/15 17:48
 */
@Service
@Slf4j
@CacheConfig(cacheNames = "emp")
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 将方法的运行结果进行缓存，以后再要相同的数据，
     * 直接从缓存中获取，不用调用方法
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames = {"emp"})
    public Employee getEmp(Integer id) {
        log.info("查询:{}号员工", id);
        return employeeMapper.getEmpById(id);
    }

    @CachePut(/*cacheNames = "emp",*/ key = "#result.id")
    public Employee updateEmp(Employee employee) {
        System.out.println(" updateEmp " + employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @CacheEvict(/*value = "emp",*/ /*key = "#id",*/ allEntries = true)
    public void deleteEmp(Integer id) {
        System.out.println("删除emp " + id);
    }

    @Caching(cacheable = {@Cacheable(/*value = "emp",*/ key = "#lastName")}
            , put = {@CachePut(/*value = "emp",*/ key = "#result.id"), @CachePut(value = "emp", key = "#result.email")})
    public Employee getEmpByLastName(String lastName) {
        return employeeMapper.getEmpByLastName(lastName);
    }

}
