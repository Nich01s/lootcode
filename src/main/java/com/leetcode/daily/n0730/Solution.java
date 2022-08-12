package com.leetcode.daily.n0730;

import java.util.Arrays;

/**
 * @Author: Nic1
 * @Date: 2022/7/30 14:55
 * @Theme: 按公因数计算最大组件大小（埃氏筛法/欧拉筛法 +并查集）
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {83, 99, 39, 11, 19, 30, 31};

        int i = solution.largestComponentSize(nums);
        System.out.println(i);
    }

    public int largestComponentSize(int[] nums) {
        int k = 0;
        int n = 100000;
        int[] isPrime = new int[n];//记录是否为素数，1素数，2合数
        int[] primes = new int[n];//记录检测到的素数
        Arrays.fill(isPrime, 1);
        UnionFind uf = new UnionFind(n + 1);

        //埃氏筛法，筛选出100000内的所有素数
        for (int i = 2; i * i <= 100000; i++) {
            //如果某个数为素数
            if (isPrime[i] == 1) {
                primes[k++] = i;//统计素数数目，记录当前素数
                //筛掉该素数的所有倍数
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = 0;
                }
            }
        }

        //遍历nums数组，将每个num与其质因数连接
        for (int num : nums) {
            //根据埃氏筛法结果，计算num的所有质因数，加入并查集
            int quotient = num;
            for (int j = 0; j < k && primes[j] * primes[j] <= quotient; j++) {
                if (quotient % primes[j] == 0) {
                    //primes[i]是他的质因数
                    uf.union(num, primes[j]);
                    //去除重复的质因数
                    while (quotient % primes[j] == 0) {
                        quotient /= primes[j];
                    }
                }
            }
            //假如剩下了一个质因数，也和num连接，使得不同的质因数可以联合到一起
            //这种情况是因为 num是一个合数 由不同的质因数相乘组成 把他的质因数 连接起来
            if (quotient > 1) {
                uf.union(quotient, num);
            }
        }
        //数组，记录当前下标数字拥有的质因数个数
        int[] cnt = new int[n + 1];
        int ans = 0;
        //遍历nums，检查num是否与某个素数相连
        for (int num : nums) {
            int root = uf.find(num);
            cnt[root]++;
            ans = Math.max(ans, cnt[root]);
        }

        return ans;
    }

    //定义并查集
    class UnionFind {
        int[] root;
        int[] rank;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        //find方法
        public int find(int x) {
            while (x != root[x]) {
                x = root[x];
            }
            return x;
        }

        //union方法(按秩合并)
        public void union(int x, int y) {
            int root_x = find(x);
            int root_y = find(y);
            if (root_x != root_y) {
                if (rank[root_x] > rank[root_y]) {
                    root[root_y] = root_x;
                } else if (rank[root_x] < rank[root_y]) {
                    root[root_x] = root_y;
                } else {
                    root[root_y] = root_x;
                    rank[root_x]++;
                }
            }
        }
    }
}
