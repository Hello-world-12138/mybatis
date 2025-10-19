package com.amk.pojo;

import lombok.Data;

/**
 * @author 阿明楷
 * @Date 2025/10/19:14:57
 * @See:
 */
@Data
public class Order {
    private Integer orderId;
    private String orderName;
    private Integer customerId;

    private Customer customer;

}
