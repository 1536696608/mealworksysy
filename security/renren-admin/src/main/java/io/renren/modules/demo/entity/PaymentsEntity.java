package io.renren.modules.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-06-01
 */
@Data
@TableName("tb_payments")
public class PaymentsEntity {

    /**
     * 订单编号
     */
    @Value("payment_id")
	private Long id;
    /**
     * 订单号
     */
	private String userOrder;
    /**
     * 订单日期
     */
	private Date paymentDate;
    /**
     * 总支付
     */
	private BigDecimal amount;
    /**
     * 用户ID
     */
	private Long userId;
    /**
     * 是否出餐
     */
	private Integer complete;
}