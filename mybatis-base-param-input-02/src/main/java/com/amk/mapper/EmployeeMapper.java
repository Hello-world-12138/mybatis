package com.amk.mapper;

import com.amk.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 阿明楷
 * @Date 2025/10/16:15:13
 * @See:
 */
public interface EmployeeMapper {


    Employee queryById(Integer id);

    int deleteById(Integer id);

    List<Employee> queryBySalary(Double salary);

    int insertEmp(Employee employee);

    List<Employee> queryByNameAndSalary(@Param("a")String name, @Param("b")Double salary);

    int insertEmpMap(Map data);



}
