package cn.lingshi.tree.bean;

import java.util.List;

/**
 * @ClassName: CommonNode
 * @Create By: chenxihua
 * @Author:
 * @Date: 2019/11/15 11:32
 **/
public abstract class AbstractNode<E> {

    protected E data;

    public AbstractNode(E data){
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }


    // ---------------      重写所有操作， 子类没有引用的时候，父类会抛出异常      ---------------


    public void addNode(AbstractNode node){
        throw new UnsupportedOperationException();
    }

    public void addNodes(List<AbstractNode> nodes){
        throw new UnsupportedOperationException();
    }

    public void remove(AbstractNode node){
        throw new UnsupportedOperationException();
    }

    /**
     * 获取本节点的直接子节点
     * @param i
     * @return
     */
    public AbstractNode getDirectNode(int i){
        throw new UnsupportedOperationException();
    }

    /**
     * 获取本节点的所有子节点
     * @return
     */
    public List<AbstractNode> listDirectNodes(){
        throw new UnsupportedOperationException();
    }

    /**
     * 判断本节点是否有子节点
     * @return
     */
    public boolean hasDirectNode(){
        throw new UnsupportedOperationException();
    }



}
