package cn.lingshi.tree.service;

import cn.lingshi.tree.repository.DeviceRepository;
import cn.lingshi.tree.repository.DomainRepository;
import cn.lingshi.tree.respon.DevTreeNode;
import cn.lingshi.tree.respon.Result;
import cn.lingshi.tree.respon.ResultUtil;
import cn.lingshi.tree.util.BuildTreeUtil2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DomainService
 * @Create By: chenxihua
 * @Author: Administrator
 * @Date: 2019/11/15 15:06
 **/

@Service
public class DomainService {

    private static final Logger logger = LoggerFactory.getLogger(DomainService.class);

    @Autowired
    DomainRepository domainRepository;
    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    BuildTreeUtil2 buildTreeUtil2;


//    public Result getDomainTree(){
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//
//        List<DevTreeNode> devTreeNodes = new ArrayList<>();
//        // 先查询出所有域, 和所有设备
//        List<VmDomain> domains = domainRepository.findAll();
//        List<VmDevice> devices = deviceRepository.findAll();
//
//
//        // 然后, 将设备节点和域节点， 放进构建域树
//        BuildTreeUtil treeUtil = new BuildTreeUtil(domains, devices, devTreeNodes);
//        treeUtil.buildTreeGrid();
//
//        // 获取域树所有节点
//        List<DevTreeNode> allDevTreeNodes = treeUtil.getAllDevTreeNodes();
//        stopWatch.stop();
//
//        logger.warn("==>所花时间：{}, 最终结果： {}", stopWatch.getTotalTimeMillis() ,allDevTreeNodes.toString());
//
//        return ResultUtil.success(allDevTreeNodes);
//    }


    public Result getDomainTree(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        List<DevTreeNode> devTreeNodes = new ArrayList<>();

        // 这一步，主要还是穿创建所有前提条件
        buildTreeUtil2.getInstance(devTreeNodes);

        // 构建域树
        buildTreeUtil2.buildTreeGrid();

        // 获取域树所有节点
        List<DevTreeNode> allDevTreeNodes = buildTreeUtil2.getAllDevTreeNodes();
        stopWatch.stop();

        logger.warn("==>所花时间：{}, 最终结果： {}", stopWatch.getTotalTimeMillis() ,allDevTreeNodes.toString());

        return ResultUtil.success(allDevTreeNodes);
    }


}
