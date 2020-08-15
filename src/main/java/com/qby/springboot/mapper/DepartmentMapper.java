package com.qby.springboot.mapper;


import com.qby.springboot.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DepartmentMapper {

    @Select("SELECT * FROM department WHERE id = #{id}")
    Department getDeptById(Integer id);
}
