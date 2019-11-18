package cn.lingshi.tree.util;

import cn.lingshi.tree.bean.AbstractNode;
import cn.lingshi.tree.bean.DeviceNode;
import cn.lingshi.tree.bean.DomainNode;
import cn.lingshi.tree.entity.VmDevice;
import cn.lingshi.tree.entity.VmDomain;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: transformToNode
 * @Create By: chenxihua
 * @Author: Administrator
 * @Date: 2019/11/15 15:02
 **/
public class TransformToNode {


    /**
     * 将域列表，转化成域节点列表
     * @param domainList
     * @return
     */
    public static <T> List<DomainNode> changeDomainToNode(List<T> domainList){
        List<DomainNode> nodeList = new ArrayList<>();
        DomainNode<T> domainNode = null;
        for (T vmDomain : domainList) {
            domainNode = new DomainNode<>(vmDomain);
            nodeList.add(domainNode);
        }
        return nodeList;
    }

    /**
     * 将设备列表，转成设备节点
     * @param deviceList
     * @param <T>
     * @return
     */
    public static <T> List<AbstractNode> changeDeviceToNode(List<T> deviceList){
        List<AbstractNode> nodeList = new ArrayList<>();
        DeviceNode<T> deviceNode = null;
        for (T vmDevice : deviceList) {
            deviceNode = new DeviceNode<>(vmDevice);
            nodeList.add(deviceNode);
        }
        return nodeList;
    }



    /**
     * 将域节点，转成域列表
     * @param datas
     * @return
     */
    public static List<VmDomain> changeNodeToDomain(List<DomainNode> datas){
        List<VmDomain> vmDomainList = new ArrayList<>();
        for (DomainNode node : datas) {
            vmDomainList.add((VmDomain) node.getData());
        }
        return vmDomainList;
    }

    /**
     * 将设备节点，转成设备列表
     * @param datas
     * @return
     */
    public static List<VmDevice> changeNodeToDevice(List<DeviceNode> datas){
        List<VmDevice> vmDeviceList = new ArrayList<>();
        for (DeviceNode node : datas) {
            vmDeviceList.add((VmDevice) node.getData());
        }
        return vmDeviceList;
    }


}
