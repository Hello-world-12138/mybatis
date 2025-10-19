package com.amk.test;

import com.amk.mapper.CustomerMapper;
import com.amk.mapper.OrderMapper;
import com.amk.pojo.Customer;
import com.amk.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author 阿明楷
 * @Date 2025/10/19:15:22
 * @See:
 */
public class MybatisTest {
    private SqlSession session;
    // junit会在每一个@Test方法前执行@BeforeEach方法

    @BeforeEach
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder()
                .build(
                        Resources.getResourceAsStream("mybatis-config.xml"))
                .openSession();
    }

    @Test
    public void testToOne(){
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        Order oder=mapper.queryOrderById(1);
        System.out.println(oder);
        System.out.println(oder.getCustomer());
    }

    @Test
    public void testToMany(){
        CustomerMapper mapper = session.getMapper(CustomerMapper.class);
        List<Customer> customers =mapper.queryList();
        System.out.println("customers="+ customers);
        for (Customer customer : customers) {
            List<Order> orderList = customer.getOrderList();
            System.out.println("orderList="+ orderList);
        }
    }



    @AfterEach
    public void clean(){
        session.close();
    }
}
