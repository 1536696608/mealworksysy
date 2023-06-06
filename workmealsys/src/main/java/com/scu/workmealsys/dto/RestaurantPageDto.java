package com.scu.workmealsys.dto;

import com.scu.workmealsys.entity.Restaurants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantPageDto {
    private Restaurants restaurants;
    private Integer page;
    private Integer size;
}
