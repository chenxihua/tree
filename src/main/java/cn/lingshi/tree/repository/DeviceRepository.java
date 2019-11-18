package cn.lingshi.tree.repository;

import cn.lingshi.tree.entity.VmDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName: DeviceRepository
 * @Create By: chenxihua
 * @Author: Administrator
 * @Date: 2019/11/17 12:30
 **/
public interface DeviceRepository extends JpaRepository<VmDevice, Integer>, JpaSpecificationExecutor<VmDevice> {
}
