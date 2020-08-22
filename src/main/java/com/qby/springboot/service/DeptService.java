package com.qby.springboot.service;

import com.qby.springboot.bean.Department;
import com.qby.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author qby
 * @date 2020/8/22 17:03
 */
@Service
public class DeptService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Cacheable(cacheNames = "dept")
    public Department getDeptById(Integer id) {
        System.out.println("查询部门：" + id);
        return departmentMapper.getDeptById(id);
    }
}
