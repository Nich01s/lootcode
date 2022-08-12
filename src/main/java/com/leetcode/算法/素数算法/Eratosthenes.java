package com.leetcode.算法.素数算法;

import java.util.Arrays;

/**
 * @Author: Nic1
 * @Date: 2022/7/30 20:03
 * @Theme: 埃氏筛法（Olognlogn）
 */
public class Eratosthenes {

    public int[] largestComponentSize(int n) {

        int[] isPrime = new int[n];//记录是否为素数，1素数，2合数
        int[] primes = new int[n];//记录检测到的素数
        int k = 0;
        Arrays.fill(isPrime, 1);

        //埃氏筛法，筛选出100000内的所有素数
        for (int i = 2; i * i <= 100000; i++) {
            //如果某个数为素数
            if (isPrime[i] == 1) {
                //筛掉该素数的所有倍数
                primes[k++] = i;
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = 0;
                }
            }
        }
        return primes;
    }
}