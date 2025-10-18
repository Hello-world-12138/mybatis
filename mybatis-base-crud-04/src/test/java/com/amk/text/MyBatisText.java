package com.amk.text;

import com.amk.mapper.UserMapper;
import com.amk.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 阿明楷
 * @Date 2025/10/18:16:25
 * @See:
 */
public class MyBatisText {

    private SqlSession sqlSession;
    @BeforeEach
    public void before() throws IOException {
        InputStream resourseAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourseAsStream);
        sqlSession = sqlSessionFactory.openSession(true); // ✅ 不要加类型声明
    }


    @AfterEach//每次走测试方法之后调用的方法
    public void clean()  {
        sqlSession.close();
    }


    @Test
    public void testInsert(){
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    User user = new User();
    user.setPassword("123456");
    user.setUsername("root");
    int insert = mapper.insert(user);
    System.out.println("insert ="+ insert);

    }

@Test
    public void testUpdate(){
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    User user = new User();
    user.setId(1);
    user.setPassword("123456");
    user.setUsername("root");
    int insert = mapper.update(user);
    System.out.println("insert ="+ insert);
    }

    @Test
    public void testDelete(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int delete = mapper.delete(1);
        System.out.println("delete ="+ delete);
    }

    @Test
    public void testSelectById(){

    }

    @Test
    public void testSelectAll(){

    }

}
