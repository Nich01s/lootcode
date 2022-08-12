package com.leetcode.msjd6.n1615;

import java.util.*;

/**
 * @Author: Nic1
 * @Date: 2022/3/13 12:46
 * @Theme: 珠玑妙算
 */
class Solution {
    public static void main(String[] args) {
        int[] ints = new Solution().masterMind("RRGY", "RRYG");
        System.out.println(Arrays.toString(ints));
    }

    public int[] masterMind(String solution, String guess) {
        int l = 0;
        int r = 0;
        int prodS = 1;
        int prodG = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            char s = solution.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                l++;
                set.add(i);
            } else {
                if (s == 'R') {
                    prodS *= 2;
                }
                if (s == 'G') {
                    prodS *= 3;
                }
                if (s == 'B') {
                    prodS *= 5;
                }
                if (s == 'Y') {
                    prodS *= 7;
                }
                if (g == 'R') {
                    prodG *= 2;
                }
                if (g == 'G') {
                    prodG *= 3;
                }
                if (g == 'B') {
                    prodG *= 5;
                }
                if (g == 'Y') {
                    prodG *= 7;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            if (!set.contains(i)) {
                if (prodS % 2 == 0 && prodG % 2 == 0) {
                    prodS /= 2;
                    prodG /= 2;
                    r++;
                } else if (prodS % 3 == 0 && prodG % 3 == 0) {
                    prodS /= 3;
                    prodG /= 3;
                    r++;
                } else if (prodS % 5 == 0 && prodG % 5 == 0) {
                    prodS /= 5;
                    prodG /= 5;
                    r++;
                } else if (prodS % 7 == 0 && prodG % 7 == 0) {
                    prodS /= 7;
                    prodG /= 7;
                    r++;
                }
            }
        }

        return new int[]{l, r};
    }
}
