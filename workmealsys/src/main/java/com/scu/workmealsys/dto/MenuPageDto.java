package com.scu.workmealsys.dto;

import com.scu.workmealsys.entity.Menus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuPageDto {
    private Menus menus;
    private Integer page;
    private Integer size;
}
