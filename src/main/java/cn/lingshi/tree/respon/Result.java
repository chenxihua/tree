package cn.lingshi.tree.respon;

import lombok.Data;

/**
 * @ClassName: Result
 * @Create By: chenxihua
 * @Date: 2019/11/15 11:43
 **/
@Data
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

}
