package cn.lingshi.tree;

import cn.lingshi.tree.util.MyList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: GreedyPackage
 * @Create By: chenxihua
 * @Author: Administrator
 * @Date: 2019/11/18 16:05
 **/
public class GreedyPackage {


    private int MAX_WEIGHT = 150;
    private int[] weights = new int[]{35,30,60,50,40,10,25};
    private int[] values = new int[]{10,40,30,50,35,40,30};

    private void packageGreedy(int capacity,int[] weights,int[] values){
        int n = weights.length;
        double[] r = new double[n]; //性价比数组
        int[] index = new int[n];   //按性价比排序物品的下标
        for(int i = 0;i < n;i++){
            r[i] = (double) values[i] / weights[i];
            index[i] = i; //默认排序
        }

        double temp = 0;    //对性价比进行排序
        for(int i = 0;i < n - 1;i++){
            for(int j = i + 1;j < n;j++){
                if(r[i] < r[j]){
                    temp = r[i];
                    r[i] = r[j];
                    r[j] = temp;

                    int x = index[i];
                    index[i] = index[j];
                    index[j] = x;
                }
            }
        }
        // 排序后的性价比数组  r[];
        // 4.0;  1.3333333333333333;  1.2;  1.0;  0.875;  0.5;  0.2857142857142857;
        System.out.println("   ");
        // index[]排序后：  5;  1;  6;  3;  4;  2;  0;


        //将排序好的重量和价值分别存到数组中
        int[] w1 = new int[n];
        int[] value1 = new int[n];

        for(int i = 0;i < n;i++){
            w1[i] = weights[index[i]];
            value1[i] = values[index[i]];
        }
        // 输出
        for (int i = 0; i <n ; i++) {
            System.out.print(w1[i]+";  ");
        }
        System.out.println(" ");
        for (int i = 0; i < n; i++) {
            System.out.print(value1[i]+";  ");
        }
        System.out.println(" ");


        int[] x = new int[n];
        int maxValue = 0;
        for(int i = 0;i < n;i++){
            if(w1[i] <= capacity){   // 表明还可以装得下
                x[i] = 1;   // 表示该物品被装了
                capacity = capacity - w1[i];
                maxValue += value1[i];
            }
        }
        System.out.println("总共放下的物品数量:" + Arrays.toString(x));
        System.out.println("最大价值为:" + maxValue);
    }


    @Test
    public void testMain(){
        GreedyPackage g = new GreedyPackage();
        g.packageGreedy(g.MAX_WEIGHT,g.weights,g.values);
    }


    @Test
    public void testHashMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("1", "chenxihua");
        map.put("", "zhongchuying");
        int size = map.size();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println(size);
    }


    @Test
    public void testTime(){
        String timeStr = "2018-01-01T12:00:00";
        int hashCode = timeStr.hashCode();
        int intVal = getIntVal(hashCode);
        String replace = timeStr.replace("T", "-").replace(":", "-");
        System.out.println("==> :"+replace+"; "+hashCode+"; "+getIntVal(hashCode)+"; "+indexForVal(intVal, 16));
    }

    public int getIntVal(int h){
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    public int indexForVal(int h, int length) {
        return h & (length-1);
    }

    @Test
    public void testMax(){
        int max = Math.max(14, 16);
        System.out.println(max);

    }


    @Test
    public void testMyList(){
        MyList myList = new MyList();
        myList.add(11);
        myList.add(22);
        myList.add(33);
        myList.add(44);
        myList.add(55);
        myList.add(66);
        myList.add(77);

        myList.insert(999, 1);
        myList.modify(9999, 5);
        myList.add(123456);

        int i = myList.get(3);
        int myListIndex = myList.getIndex(66);

        for (int j = 0; j < myList.getSize(); j++) {
            System.out.println(myList.get(j));
        }
        System.out.println("i: "+i);
        System.out.println("index: "+myListIndex);
    }

}
