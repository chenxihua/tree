package cn.lingshi.tree.util;

import cn.lingshi.tree.entity.VmDevice;
import cn.lingshi.tree.entity.VmDomain;
import cn.lingshi.tree.respon.DevTreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: BuildTreeUtil
 * @Create By: chenxihua
 * @Author: Administrator
 * @Date: 2019/11/15 14:24
 **/
public class BuildTreeUtil {

    private static final Logger logger = LoggerFactory.getLogger(BuildTreeUtil.class);

    private List<VmDomain> domainNodes;
    private List<VmDevice> deviceNodes;
    private List<DevTreeNode> allDevTreeNodes;

    public List<DevTreeNode> getAllDevTreeNodes() {
        return allDevTreeNodes;
    }


    /**
     * 将所有节点都初始化进来
     * @param vmDomainNodes
     * @param vmDevNodes
     */
    public BuildTreeUtil(List<VmDomain> vmDomainNodes, List<VmDevice> vmDevNodes, List<DevTreeNode> allDevTreeNodes){
        this.domainNodes = vmDomainNodes;
        this.deviceNodes = vmDevNodes;
        this.allDevTreeNodes = allDevTreeNodes;
    }


    /**
     * 创建树，（先创建根节点）
     * @return
     */
    public void buildTreeGrid(){
        List<VmDomain> vmDomains = new ArrayList<>();

        for (VmDomain vmDomain : domainNodes) {
            if (vmDomain.getParentId().equals(0)){
                vmDomains.add(vmDomain);

                allDevTreeNodes.add(saveDevTreeNode(0, vmDomain.getDomainName(), vmDomain));

                buildTreeGridChilds(vmDomains, allDevTreeNodes);
            }
        }
    }

    /**
     * 创建树下的节点
     * @param domains
     * @param allDevTreeNodes
     */
    public void buildTreeGridChilds(List<VmDomain> domains, List<DevTreeNode> allDevTreeNodes) {

        List<DevTreeNode> childDevTree = new ArrayList<>();
        List<DevTreeNode> childs = null;
        List<VmDomain> childVmDomains = new ArrayList<>();

        if (domains.size() > 0) {
            // 这里查出域的所有子域 ( 并将子域加入链表里面 )
            childs = getChilds(domains);
            allDevTreeNodes.addAll(childs);

            if (childs.size() > 0) {
                for (DevTreeNode child : childs) {
                    if (child.getTypeId() == 0) {
                        childVmDomains.add((VmDomain) child.getData());
                    }
                }
            }
            // 之前每一个域的的所有子设备
            for (VmDomain domain : domains) {
                List<DevTreeNode> devList = getChildsDevList(domain);
                childDevTree.addAll(devList);
            }
            allDevTreeNodes.addAll(childDevTree);
            // 再递归
            buildTreeGridChilds(childVmDomains, allDevTreeNodes);
        }
    }



    /**
     * 获取子域节点
     * @param parentDomainNode
     * @return
     */
    public List<DevTreeNode> getChilds(List<VmDomain> parentDomainNode){
        List<VmDomain> removeDomains = new ArrayList<>();
        // 设置返回值
        List<DevTreeNode> againResult = new ArrayList<>();
        if (parentDomainNode.size()>0){
            for (VmDomain pareDomain : parentDomainNode) {
                for (VmDomain domainNode : domainNodes) {
                    if (domainNode.getParentId().equals(pareDomain.getDomainId())){
                        againResult.add(saveDevTreeNode(0, domainNode.getDomainName(), domainNode));
                        // 删除已经用过和查询匹配过了的子域
                        removeDomains.add(domainNode);
                    }
                }
            }
            // 在遍历之外进行删除
            domainNodes.removeAll(removeDomains);
        }
        return againResult;
    }


    /**
     * 得到一个域下的所有设备
     * @param vmDomain
     * @return
     */
    public List<DevTreeNode> getChildsDevList(VmDomain vmDomain){
        List<VmDevice> removeDevs = new ArrayList<>();
        List<DevTreeNode> againResult = new ArrayList<>();
        for (VmDevice vmDevice : deviceNodes) {
            if (vmDevice.getDomainId().equals(vmDomain.getDomainId())){
                againResult.add(saveDevTreeNode(1, vmDevice.getDevName(), vmDevice));
                // 删除已经用过和查询匹配过了的子设备
                removeDevs.add(vmDevice);
            }
        }
        // 在遍历之外删除
        deviceNodes.removeAll(removeDevs);
        return againResult;
    }

    /**
     * 保存为一个节点信息
     * @param code
     * @param name
     * @param data
     * @return
     */
    private DevTreeNode saveDevTreeNode(Integer code, String name, Object data){
        DevTreeNode devTreeNode = new DevTreeNode();
        devTreeNode.setTypeId(code);
        devTreeNode.setName(name);
        devTreeNode.setData(data);
        return devTreeNode;
    }


}
