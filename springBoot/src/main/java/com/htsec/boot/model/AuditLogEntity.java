package com.htsec.boot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.Getter;

/**
 * 
 * @Title: AuditLog.java
 * @Package com.kingstar.securities.bs.scos.model.entity
 * @Description: 审核信息实体
 * @author chenck
 * @date 2014年10月13日 下午2:48:01
 * @version V1.0
 */
@Entity
@Table(name = "SCOS_AUDIT_LOG")
@Data
public class AuditLogEntity extends BaseEntity {

	/**
	 * @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = 7056829565551544199L;

	/**
	 * 审核信息
	 */
	@Column(name = "AUDIT_LOG", length = 1000)
	private String auditLog;

	/**
	 * @Fields auditEmp : 审核人员代码
	 */
	@Column(name = "AUDIT_EMP", length = 20)
	private String auditEmp;

	/**
	 * @Fields auditEmpName : 审核人员名称
	 */
	@Column(name = "AUDIT_EMP_NAME", length = 50)
	private String auditEmpName;

	/**
	 * @Fields optBranchCode : 审核营业部代码
	 */
	@Column(name = "AUDIT_BRANCH_CODE", length = 10)
	private String auditBranchCode;

	/**
	 * 审核时间
	 */
	@Column(name = "AUDIT_TIME", length = 20)
	@Temporal(TemporalType.TIMESTAMP)
	private Date auditTime;

	/**
	 * 审核结果 通过 拒绝
	 */
	@Column(name = "AUDIT_RESULT", length = 20)
	private String auditResult;

	/**
	 * 关联的审核任务外键
	 */
	@Column(name = "AUDIT_TASK_ID", length = 50)
	private String auditTaskId;

	/**
	 * 关联的审核任务的节点
	 */
	@Column(name = "AUDIT_STATE_ID", length = 50)
	private String auditStateId;

	/**
	 * @Fields sysCode : 系统代码
	 */
	@Column(name = "SYS_CODE", length = 50)
	private String sysCode;

	/**
	 * 受理流水号，记录businessaccept表中的唯一业务流水号
	 */
	@Column(name = "ACCEPT_SERIAL_NO", length = 32)
	private String acceptSerialNo;

	/**
	 * @Fields auditSerialNo : 审核任务的流水号
	 */
	@Column(name = "AUDIT_SERIAL_NO", length = 32)
	private String auditSerialNo;

	/**
	 * 审核任务类型： 1为影像补录
	 */
	@Column(name = "AUDIT_TYPE", length = 10)
	private String auditType;

	/**
	 * @Fields empMac : 创建审核实体职工的mac地址
	 */
	@Column(name = "EMP_MAC", length = 30)
	private String empMac;
	/**
	 * 审核职工的岗位集合
	 */
	@Column(name = "AUDIT_EMP_POSTION", length = 150)
	private String auditEmpPostion;

	 

 
	

}
