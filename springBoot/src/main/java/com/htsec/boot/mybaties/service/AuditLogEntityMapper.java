package com.htsec.boot.mybaties.service;
import java.util.List;
import javax.transaction.Transactional;
import org.apache.ibatis.annotations.Mapper;
import com.htsec.boot.model.AuditLogEntity;
@Mapper
@Transactional
public interface AuditLogEntityMapper {
	
	public int getCount();
	public  AuditLogEntity findById(Long id);
	public List<AuditLogEntity> getPageData(PagingBo bo);
}
