package com.scu.workmealsys.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterReqDto {
    private Integer userId;
    private String password;
    private Integer workId;
    private String email;
}
