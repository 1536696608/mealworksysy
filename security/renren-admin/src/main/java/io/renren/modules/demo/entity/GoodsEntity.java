package io.renren.modules.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 商品管理
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-05-31
 */
@Data
@TableName("tb_goods")
public class GoodsEntity {

    /**
     * 商品ID
     */
	private Long id;
    /**
     * 商品名
     */
	private String name;
    /**
     * 介绍
     */
	private String intro;
    /**
     * 价格
     */
	private Integer price;
    /**
     * 数量
     */
	private Integer num;
    /**
     * 创建者
     */
	private Long creator;
    /**
     * 创建时间
     */
	private Date createDate;
}