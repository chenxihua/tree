package cn.lingshi.tree.repository;

import cn.lingshi.tree.entity.VmDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName: DomainRespository
 * @Create By: chenxihua
 * @Author: Administrator
 * @Date: 2019/11/15 15:07
 **/

public interface DomainRepository extends JpaRepository<VmDomain, Integer>, JpaSpecificationExecutor<VmDomain> {
}
