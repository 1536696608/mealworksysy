package com.scu.workmealsys.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentsReqDto {
    private Integer userId;
    private Integer size;
    private Integer current;
}
