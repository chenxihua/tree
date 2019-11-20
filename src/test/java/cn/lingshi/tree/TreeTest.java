package cn.lingshi.tree;

import cn.lingshi.tree.tree.BinarySortTree;
import org.junit.jupiter.api.Test;

/**
 * @ClassName: TreeTest
 * @Create By: chenxihua
 * @Author: Administrator
 * @Date: 2019/11/20 11:38
 *
 * 主要是测试【排序二叉树】树结构
 *
 **/
public class TreeTest {


    @Test
    public void test(){
        BinarySortTree tree = new BinarySortTree();
        tree.add(60);
        tree.add(30);
        tree.add(75);
        tree.add(15);
        tree.add(50);
        tree.add(80);
        tree.add(10);
        tree.add(25);
        tree.add(40);
        tree.add(55);
        tree.add(19);
        tree.add(35);

        System.out.print("层次遍历(删除前)：");
        tree.levelIter();
        System.out.println();

        //删除
        tree.remove(30);

        System.out.print("层次遍历(删除后)：");
        tree.levelIter();
        System.out.println();

        System.out.print("是否已存在：");
        System.out.print(tree.contains(80));
    }



    @Test
    public void testThree(){
        BinarySortTree tree = new BinarySortTree();
        tree.add(60);
        tree.add(30);
        tree.add(75);
        tree.add(15);
        tree.add(50);
        tree.add(80);
        tree.add(10);
        tree.add(25);
        tree.add(40);
        tree.add(55);
        tree.add(19);
        tree.add(35);

        tree.preOrderTraverse(tree.getRoot());
        System.out.println("");
        System.out.println("================");

        tree.inOrderTraverse(tree.getRoot());
        System.out.println("");
        System.out.println("================");

        tree.postOrderTraverse(tree.getRoot());
        System.out.println("");
        System.out.println("================");
    }

}
