package cn.lingshi.tree.bean.vo;

/**
 * @ClassName: Node
 * @Create By: chenxihua
 * @Author: Administrator
 * @Date: 2019/11/19 15:17
 *
 * 实现一个单链表
 *
 **/
public class Node {

    /**
     * 数据
     */
    public Integer data;

    /**
     * 指针，或者说是下一个节点
     */
    public Node next;

    /**
     * 创建一个无参构造器
     */
    public Node(){
    }

    /**
     * 构造一个有参构造器，便于给节点保存数据
     * @param data
     */
    public Node(Integer data){
        this.data = data;
    }

}
