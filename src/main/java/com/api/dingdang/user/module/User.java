package com.api.dingdang.user.module;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

/**
 *
 * 
 *
 */
@Data
@TableName(value = "zk_user_t")
public class User implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(value = "id",type = IdType.AUTO)
	private Integer id;

	/**
	 * 用户名
	 */
	private String userName;


	/**
	 * 密码
	 */
	private String password;


	/**
	 * 手机号码
	 */
	private String mobile;

	/**
	 * 创建人
	 */
	@TableField(value = "create_by")
	private String createBy;

	/**
	 * 创建时间
	 */
	@TableField(value = "create_date")
	private Date createDate;

	/**
	 *最后更新人
	 */
	@TableField(value = "last_update_by")
	private String lastUpdateBy;

	/**
	 * 最后更新时间
	 */
	@TableField(value = "last_update")
	private String lastUpdate ;


}
