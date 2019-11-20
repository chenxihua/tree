package cn.lingshi.tree.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName: BinarySortTree
 * @Create By: chenxihua
 * @Author: Administrator
 * @Date: 2019/11/20 9:32
 *BinarySortTree
 * 这是一个【二叉排序树】， 对于二叉排序树的原理，查看自己的笔记
 *
 **/
public class BinarySortTree {

    /**
     * 记录根节点
     */
    Node root;

    Stack stack = new Stack();

    public BinarySortTree(){
    }

    /**
     * 新增
     * @param data
     * @return
     */
    public boolean add(int data){
        if (root==null){
            root = new Node(data);
            return true;
        }
        // 记录 current 的父节点
        Node parent = null;
        Node current = root;
        while (current!=null){
            if (data > current.data){
                parent = current;
                current = current.right;
            }else if (data < current.data){
                parent = current;
                current = current.left;
            }else {
                return false;
            }
        }
        if (data > parent.data){
            parent.right = new Node(data);
        } else {
            parent.left = new Node(data);
        }
        return true;
    }


    /**
     * 查询
     * @param data
     * @return
     */
    public boolean contains(int data){
        if (root==null){
            return false;
        }
        Node current = root;
        while (current!=null){
            if (data == current.data){
                return true;
            }else if (data > current.data){
                current = current.right;
            }else if (data < current.data){
                current = current.left;
            }
        }
        return false;
    }


    /**
     * 删除节点
     * @param data
     * @return
     */
    public boolean remove(int data){
        Node parent = null;
        Node current = root;
        if (current==null){
            return false;
        }
        while (current!=null){
            if (data==current.data){
                return removeNode(parent, current, data);
            }else if (data > current.data){
                parent = current;
                current = current.right;
            }else {
                parent = current;
                current = current.left;
            }
        }
        return false;
    }

    public Node getRoot(){
        if (root!=null){
            return root;
        }
        return null;
    }

    /**
     * 递归移除节点
     * @param parent
     * @param current
     * @param data
     * @return
     */
    protected boolean removeNode(Node parent, Node current, int data){
        // 若左子树为空，右儿子继承
        if (current.left==null){
            if (current.data > parent.data){
                parent.right = current.right;
            }else {
                parent.left = current.right;
            }
            // 方便垃圾回收器回收
            current = null;
        } else if (current.right == null){
            // 这种情况是右子树为空，则左子树继承
            if (current.data > parent.data){
                parent.right = current.left;
            }else {
                parent.left = current.left;
            }
            current = null;
        } else {
            // 多子多孙情况
            // 创建用于记录 heir 的父节点
            Node heirFather = null;
            /**
             * heir = current.left; 即口诀一中的左转
             */
            Node heir = current.left;
            while (heir.right!=null){
                heirFather = heir;
                heir = heir.right;
            }
            // 继承人的值，赋给要被删除的节点
            current.data = heir.data;
            if (heir.data > heirFather.data){
                heirFather.right = heir.left;
            }else {
                heirFather.left = heir.left;
            }
            heir = null;
        }
        return true;
    }


    /**
     * 层次遍历, 这个层次遍历，也就是所谓的【广度优先算法】
     */
    public void levelIter(){
        if (root == null){
            return;
        }
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.addFirst(root);

        Node current;
        while (!nodes.isEmpty()){
            current = nodes.removeLast();
            System.out.print("--> "+current.data);
            if (current.left!=null){
                nodes.addFirst(current.left);
            }
            if (current.right!=null){
                nodes.addFirst(current.right);
            }
        }
    }


    /**
     * 先序遍历
     * @param current
     */
    public void preOrderTraverse(Node current){
        if (current==null) {
            return;
        }
        System.out.print(current.data + " ");
        preOrderTraverse(current.left);
        preOrderTraverse(current.right);
    }

    /**
     * 中序遍历
     * @param current
     */
    public void inOrderTraverse(Node current){
        if (current==null){
            return;
        }
        inOrderTraverse(current.left);
        System.out.print(current.data + " ");
        inOrderTraverse(current.right);
    }

    /**
     * 后序遍历
     * @param current
     */
    public void postOrderTraverse(Node current){
        if (current == null){
            return;
        }
        postOrderTraverse(current.left);
        postOrderTraverse(current.right);
        System.out.print(current.data + " ");
    }



}
