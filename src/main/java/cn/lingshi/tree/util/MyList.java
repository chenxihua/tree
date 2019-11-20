package cn.lingshi.tree.util;

import cn.lingshi.tree.bean.vo.Node;
import cn.lingshi.tree.bean.vo.NodeList;
/**
 * @ClassName: MyList
 * @Create By: chenxihua
 * @Author: Administrator
 * @Date: 2019/11/19 15:26
 **/
public class MyList implements NodeList {

    Node head;
    Node tail;
    int size;

    public MyList(){
        head = new Node();
        tail = head;
        size = 0;
    }

    @Override
    public void add(Integer data) {
        Node node = new Node(data);
        tail.next = node;
        tail = node;
        size++;
    }

    /**
     * 形参 index 表示节点所处位置的下标
     * @param data
     * @param index
     */
    @Override
    public void insert(Integer data, int index) {
        checkIndex(index);
        Node node = head.next;
        // 找到下标 index
        for (int i = 0; i <index ; i++) {
            node = node.next;
        }
        Node parent = head.next;
        // 找到下标 index-1
        for (int i = 0; i <index-1 ; i++) {
            parent = parent.next;
        }
        // 创建一个新的节点， 为插入节点
        Node newNode = new Node(data);
        // 如果插入的为第一个节点
        if (size==0){
            head.next = null;
            head.next = newNode;
        }else {
            parent.next = null;
            parent.next = newNode;
        }
        newNode.next = node;
        size++;
    }

    @Override
    public void delete(int index) {
        checkIndex(index);
        Node node = head.next;
        // 找到下标 index
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        Node parent = head.next;
        // 找到下标 index-1
        for (int i = 0; i < index - 1; i++) {
            parent = node.next;
        }
        // 假设 index 不是0
        if (index!=0){
            if (index==size-1){
                // 假设是最后一个
                parent.next = null;
            }else {
                parent.next = null;
                parent.next = node.next;
            }
            node.next = null;
            node.data = 0;
        }else {
            head.next = null;
            head.next = node.next;  // 指向第一个节点的下一个节点

            node.next = null;
            node.data = 0;
        }
        size--;

    }

    /**
     * 返回指定位置的数据
     * @param index
     * @return
     */
    @Override
    public int get(int index) {
        checkIndex(index);
        Node node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    @Override
    public void modify(Integer data, int index) {
        checkIndex(index);
        Node node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.data = data;
    }

    @Override
    public int getSize() {
        return size;
    }

    /**
     * 根据数据，查找其在链表的下标
     * @param data
     * @return
     */
    @Override
    public int getIndex(Integer data) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            node = node.next;
            if (data.equals(node.data)){
                return i;
            }
        }
        return -1;
    }


    /**
     * 检查下标是否符合，有没有越界
     * @param index
     */
    private void checkIndex(int index){
        if (index<0 || index>size){
            throw new IndexOutOfBoundsException("参数超出界限");
        }
    }




}
