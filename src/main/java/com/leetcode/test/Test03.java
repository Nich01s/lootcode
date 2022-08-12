package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: Nic1
 * @Date: 2022/3/3 15:26
 * @Theme:
 */
public class Test03 {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (true) {
            list.add(new User(i++, UUID.randomUUID().toString()));//
            new User(j--, UUID.randomUUID().toString());//游离的无根对象
        }
    }

}
class User{
    int number;
    String name;

    public User(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("执行了finalize()方法...");
    }
}
