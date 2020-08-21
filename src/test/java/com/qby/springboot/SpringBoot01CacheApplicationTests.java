package com.qby.springboot;

import com.qby.springboot.bean.Employee;
import com.qby.springboot.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBoot01CacheApplicationTests {
    @Autowired
    private EmployeeMapper employeeMapper;

    // kv都是对象object
    @Autowired
    private RedisTemplate redisTemplate;

    // 操作字符串
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<Object, Employee> redisTemplateEmployee;

    @Test
    void contextLoads() {

        Employee empById = employeeMapper.getEmpById(1);
        System.out.println(empById);
    }

    /**
     * stringRedisTemplate.opsForValue() 字符串
     * stringRedisTemplate.opsForList() 列表
     * stringRedisTemplate.opsForSet() set 集合
     * stringRedisTemplate.opsForHash() hash
     * stringRedisTemplate.opsForZSet() zset
     *
     */
    @Test
    public void test01() {
        stringRedisTemplate.opsForValue().append("msg", "hello");


        stringRedisTemplate.opsForList().leftPush("mylist", "1");
        stringRedisTemplate.opsForList().leftPush("mylist", "2");
    }

    @Test
    public void test02() {
        Employee empById = employeeMapper.getEmpById(1);
        redisTemplateEmployee.opsForValue().set("emp-01", empById);
    }

}
