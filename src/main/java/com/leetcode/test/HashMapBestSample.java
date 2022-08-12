package com.leetcode.test;

import java.util.HashMap;

/**
 * @Author: Nic1
 * @Date: 2022/3/5 21:30
 * @Theme:
 */
class HS{
    @Override
    public int hashCode() {
        return 1;//所HS对象的hashCode都为1
    }
}
public class HashMapBestSample {
    public static void main(String[] args) {

        HashMap<HS, String> map = new HashMap<>();

        //存入hashCode相同的对象
        map.put(new HS(),"1");
        map.put(new HS(),"2");//在同一个下标处形成链表

        //存入重写了equals的HS对象
        map.put(new HS(){
            @Override
            public boolean equals(Object obj) {
                return true;
            }
        },"3");//在同一个下标处覆盖掉链表上第一个节点（头插法）


        //存入重写了equals和hashCode的HS对象
        map.put(new HS(){
            @Override
            public int hashCode() {
                return 2;//与前面的hashCode值不同
            }
            @Override
            public boolean equals(Object obj) {
                return true;
            }
        },"3");
    }
}
