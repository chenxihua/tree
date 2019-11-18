package cn.lingshi.tree.bean;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: DomainNode
 * @Create By: chenxihua
 * @Author:
 * @Date: 2019/11/15 11:34
 **/
public class DomainNode<E> extends AbstractNode<E> {

    // 主要是遍历，插入，删除
    public List<AbstractNode> nodes = new LinkedList<>();

    public DomainNode(E data){
        super(data);
    }

    @Override
    public void addNode(AbstractNode node) {
        this.nodes.add(node);
    }

    @Override
    public void addNodes(List<AbstractNode> nodes) {
        this.nodes.addAll(nodes);
    }

    @Override
    public void remove(AbstractNode node) {
        this.nodes.remove(node);
    }

    @Override
    public AbstractNode getDirectNode(int i) {
        return this.nodes.get(i);
    }

    @Override
    public List<AbstractNode> listDirectNodes() {
        return this.nodes;
    }

    @Override
    public boolean hasDirectNode() {
        return !(this.nodes.isEmpty());
    }
}
