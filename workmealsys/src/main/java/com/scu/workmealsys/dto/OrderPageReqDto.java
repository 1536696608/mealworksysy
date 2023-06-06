package com.scu.workmealsys.dto;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPageReqDto {
    private Integer userId;
    private String payId;
    private Integer size;
    private Integer current;
}
