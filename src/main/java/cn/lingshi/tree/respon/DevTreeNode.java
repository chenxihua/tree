package cn.lingshi.tree.respon;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName: DevTreeNode
 * @Create By: chenxihua
 * @Author: Administrator
 * @Date: 2019/11/17 13:35
 **/
@Data
@ToString
public class DevTreeNode {

    /**
     * 0: 域， 1：设备
     */
    private Integer typeId;

    /**
     * 域名称，或者设备名称
     */
    private String name;

    private Object data;

}
