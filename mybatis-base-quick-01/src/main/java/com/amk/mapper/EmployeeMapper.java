package com.amk.mapper;

import com.amk.pojo.Employee;

/**
 * @author 阿明楷
 * @Date 2025/10/13:09:22
 * @See:
 */
public interface EmployeeMapper {
    //根据id查询员工信息
    Employee queryById(Integer id);

    int deleteById(Integer id);

}
