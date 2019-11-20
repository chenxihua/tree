package cn.lingshi.tree.tree;

/**
 * @ClassName: Node
 * @Create By: chenxihua
 * @Author: Administrator
 * @Date: 2019/11/20 9:54
 *
 * 这个节点，是给【二叉排序树】使用的
 *
 **/
public class Node {

    public int data;

    public Node left;

    public Node right;

    public Node(){

    }

    public Node(int data) {
        this.data = data;
    }
}

