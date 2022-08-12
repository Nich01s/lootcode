package com.leetcode.daily.n0803;

/**
 * @Author: Nic1
 * @Date: 2022/8/3 12:35
 * @Theme: 有序队列【最小表示法】
 */

import java.util.Arrays;

/**
 * 最小表示法将「方案比较」与「构造更优方案」进行结合：假设我们当前有两字符串 a 和 b 需要进行比较，其均为原串 s 的循环同构具体方案。假设 a 和 b 分别对应了原串下标为 i 和 j 的具体方案，且假设两字符串前 kk 个字符均相同。
 * <p>
 * 当两字符串第一个不同的字符大小关系为 cs[i + k] > cs[j + k]cs[i+k]>cs[j+k] 时，可以发现在下标范围 idx \in [i, i + k]idx∈[i,i+k] 作为起点的新方案 a' 必然不会是最优方案，即必然存在下标范围 idx - i + jidx−i+j 作为起点的新方案 b' 比其更优，因此我们可以直接从 i + k + 1i+k+1 位置构造新的更优方案，并与 b 再次比较。而 cs[i + k] < cs[j + k]cs[i+k]<cs[j+k] 的分析同理。
 * <p>
 * 更为直白的表述为：分别从 i 和 j 作为起点的字符串 a 和 b，其前 kk 个字符相同，而当 cs[i + k] > cs[j + k]cs[i+k]>cs[j+k] 时，我们可以明确「以 i + pi+p 为起点的字符串」必不可能比「以 j + pj+p 为起点的字符串」更优，其中 p \in [0, k]p∈[0,k]。
 */
public class Solution {
    public String orderlyQueue(String s, int k) {
        char[] chars = s.toCharArray();
        int n = s.length();
        //当k>1时，直接对字符串进行排序即可，因为当k>1时，字符串总能被升序排序
        if (k > 1) {
            Arrays.sort(chars);
            return new String(chars);
        }
        //当k=1时，使用最小表示法
        else {
            int i = 0;
            int j = 1;
            int _k = 0;
            int min = -1;
            while (i < n && j < n && _k < n) {
                char a = chars[(i + _k) % n];//获取i+_k位置上的字符
                char b = chars[(j + _k) % n];//获取j+_k位置上的字符
                if (a == b) _k++;
                else {
                    if (a > b) i += (_k + 1);//如果不相等，直接跳过[i,i+_k]位置上的所有字符，直接跳到i=(_k+1)位置上
                    else j += (k + 1);
                    if (i == j) i++;//当i==j时，重新置为初始状态，否则所有比较都相等
                    k = 0;
                }
            }
            //当i/j不满足<n跳出循环时，意味着当前，返回i,j中的较小的那个
            min = Math.min(i, j);
            return s.substring(min) + s.substring(0, i);
        }
    }
}
