package com.leetcode.test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author: Nic1
 * @Date: 2022/3/2 20:17
 * @Theme:
 */
public class Test01 {
    public static void main(String[] args) {

        //List
        ArrayList<Integer> list = new ArrayList<Integer>();//数组
        List<Integer> vector = new Vector<>();//线程安全数组
        List<Integer> linkedList = new LinkedList<>();//链表
        //Set
        Set<Integer> hashSet = new HashSet<>();//HashSet
        Set<Integer> linkedHashSet = new LinkedHashSet<>();//维护插入顺序HashSet
        Set<Integer> treeSet = new TreeSet<>();//排序HashSet
        //Map
        Map<Integer, Integer> hashMap = new HashMap<>();//HashMap
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();//全局线程安全HashMap
        Map<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();//分段线程安全HashMap
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();//维护插入顺序HashMap
        Map<Integer, Integer> treeMap = new TreeMap<>();//排序HashMap

        //AQS抽象队列同步器
        //AbstractQueuedSynchronizer

    }
}
