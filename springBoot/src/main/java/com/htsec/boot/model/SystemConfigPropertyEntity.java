package com.htsec.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


/**
 * 系統參數配置
 * 
 * @author Si.Dai
 * 
 */
@Entity
@Table(name = "KENEL_SYSTEM_CONFIG_PROPERTY")
@Setter
@Getter
@RequiredArgsConstructor
public class SystemConfigPropertyEntity extends BaseEntity {

	private static final long serialVersionUID = 2772064011620726531L;

	/**
	 * @Fields name : 参数名
	 */
	@Column(name = "NAME", length = 250, nullable = false)
	private String name;
	/**
	 * @Fields name : 参数编码
	 */
	@Column(name = "CODE", length = 250, nullable = false, unique = true)
	private String code;
	/**
	 * @Fields module :所属业务模块代码
	 */
	@Column(name = "MODULE", length = 50, nullable = false)
	private String module;
	/**
	 * @Fields type : 参数值类型单选、多选、文本 01、02、03
	 */
	@Column(name = "TYPE", length = 50, nullable = false)
	private String type;
	/**
	 * @Fields value : 参数值
	 */
	@Column(name = "VALUE", length = 2000)
	private String value;
	/**
	 * @Fields defaultValue :缺省参数值
	 */
	@Column(name = "DEFAULT_VALUE", length = 500, nullable = false)
	private String defaultValue;
	/**
	 * @Fields rangValues :参数取值范围，只用，分隔
	 */
	@Column(name = "RANG_VALUES", length = 500, nullable = false)
	private String valuesRang;

	/**
	 * @Fields parameterType :参数类型，0为系统参数，1为业务参数
	 */
	@Column(name = "PARAMETERTYPE", length = 50)
	private String parameterType;

	@Column(name = "DESC", length = 500)
	private String desc;

	/**
	 * @Fields selectAllFlag : 全选标志：是否需要全选操作
	 */
	@Column(name = "SELECT_ALL_FLAG", length = 2)
	private String selectAllFlag;

	/**
	 * 类型分类, 一级分类
	 */
	@Column(name = "TYPE1", length = 50)
	private String type1;

	/**
	 * 业务分类, 二级分类
	 */
	@Column(name = "TYPE2", length = 50)
	private String type2;

	/**
	 * 备用 ,三级分类
	 */
	@Column(name = "TYPE3", length = 50)
	private String type3;

	/**
	 * 备用 , 四级分类
	 */
	@Column(name = "TYPE4", length = 50)
	private String type4;
	 
}
