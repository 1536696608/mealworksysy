package com.scu.workmealsys.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderReqDto {
    private Integer userId;
    private Integer menuId;
    private Integer restaurantId;
    private Integer quantity;
    private String user_order;

    private Double price;
}
