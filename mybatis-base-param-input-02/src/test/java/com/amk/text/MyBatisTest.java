package com.amk.text;

import com.amk.mapper.EmployeeMapper;
import com.amk.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 阿明楷
 * @Date 2025/10/16:15:32
 * @See:
 */
public class MyBatisTest {


    @Test
    public void test_01() throws IOException {

        // 1.读取外部配置文件
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");



        // ③基于读取Mybatis配置文件的输入流创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        // 2.使用SqlSessionFactory对象开启一个会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.根据EmployeeMapper接口的Class对象获取Mapper接口类型的对象(动态代理技术)
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // 4. 调用代理类方法既可以触发对应的SQL语句
        Employee employee = mapper.queryById(1);

        System.out.println("employee = " + employee);

        // 4.关闭SqlSession

        sqlSession.close(); //关闭会话

    }
}
