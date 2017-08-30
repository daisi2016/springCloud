package com.htsec.boot.mybaties.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.htsec.boot.model.SystemConfigPropertyEntity;

@Mapper
@Transactional
public interface SystemConfigMapper {
	@Select("select * from KENEL_SYSTEM_CONFIG_PROPERTY where id=#{id}")
	@Transactional(value=TxType.SUPPORTS)
	public SystemConfigPropertyEntity findById(@Param("id")Long id);

	
	@Insert("insert into KENEL_SYSTEM_CONFIG_PROPERTY(id,name,code,value) values(#{id},#{name},#{code},#{value})")
	@Transactional(value=TxType.REQUIRED)
	public void addConfig(SystemConfigPropertyEntity entity);
}
