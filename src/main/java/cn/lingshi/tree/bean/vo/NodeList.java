package cn.lingshi.tree.bean.vo;

/**
 * @ClassName: NodeList
 * @Create By: chenxihua
 * @Author: Administrator
 * @Date: 2019/11/19 15:21
 **/
public interface NodeList {

    /**
     * 新增
     * @param data
     */
    public void add(Integer data);

    /**
     * 插入
     * @param data
     */
    public void insert(Integer data, int index);

    /**
     * 删除
     * @param index
     */
    public void delete(int index);

    /**
     * 获取
     * @param index
     * @return
     */
    public int get(int index);

    /**
     * 更新节点数据
     * @param data,index
     */
    public void modify(Integer data, int index);

    /**
     * 获取链表长度
     * @return
     */
    public int getSize();

    /**
     * 获取下标位置
     * @param data
     * @return
     */
    public int getIndex(Integer data);


}
