package cn.lingshi.tree.respon;

/**
 * @ClassName: ResultUtil
 * @Create By: chenxihua
 * @Date: 2019/11/15 11:43
 **/
public class ResultUtil {


    public static Result success(){
        Result result = new Result();
        result.setCode(0);
        result.setMessage("操作成功");
        return result;
    }

    public static Result success(Object data){
        Result result = new Result();
        result.setCode(0);
        result.setMessage("操作成功");
        result.setData(data);
        return result;
    }

    public static Result error(){
        Result result = new Result();
        result.setCode(-1);
        result.setMessage("操作失败");
        return result;
    }

    public static Result error(Object data){
        Result result = new Result();
        result.setCode(-1);
        result.setMessage("操作失败");
        result.setData(data);
        return result;
    }

}
