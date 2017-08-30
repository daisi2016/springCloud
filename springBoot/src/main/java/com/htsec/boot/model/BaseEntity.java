package com.htsec.boot.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -9023527148766036246L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "ENABLE_FLAG", length = 2)
	public String enableFlag ; // 删除标志

	@Column(name = "CREATE_EMP", length = 20)
	private String createEmp; // 创建人

	@Column(name = "CREATE_DATE", length = 20)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate = new Date();; // 创建日期

	@Column(name = "CHANGE_EMP", length = 20)
	private String changeEmp; // 修改人

	@Column(name = "CHANGE_DATE", length = 20)
	@Temporal(TemporalType.TIMESTAMP)
	private Date changeDate; // 修改日期

	 

}
