package io.renren.modules.demo.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-06-01
 */
@Data
public class PaymentsExcel {
    @Excel(name = "订单编号")
    private Long id;
    @Excel(name = "订单号")
    private String userOrder;
    @Excel(name = "订单日期")
    private Date paymentDate;
    @Excel(name = "总支付")
    private BigDecimal amount;
    @Excel(name = "用户ID")
    private Long userId;
    @Excel(name = "是否出餐")
    private Integer complete;

}