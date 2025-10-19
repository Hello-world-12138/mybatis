package com.amk.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author 阿明楷
 * @Date 2025/10/19:14:55
 * @See:
 */
@Data
public class Customer {

    private Integer customerId;
    private String customerName;

    private List<Order> orderList;
}
