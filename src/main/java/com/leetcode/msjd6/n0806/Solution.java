package com.leetcode.msjd6.n0806;

import java.util.*;

/**
 * @Author: Nic1
 * @Date: 2022/8/1 11:39
 * @Theme: 汉诺塔问题（递归）
 */

/**
 * 递归思想：
 *    Ⅰ、子方法递归的结果可以被父递归方法直接利用！
 *    Ⅱ、递归方法需要有退出条件（本题中的退出条件即num==1时退出递归）
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> A = new ArrayList<>(Arrays.asList(6, 5, 4, 3, 2, 1, 0));
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        System.out.println(A.toString());
        System.out.println(B.toString());
        System.out.println(C.toString());
        s.hanota(A, B, C);
        System.out.println(A.toString());
        System.out.println(B.toString());
        System.out.println(C.toString());
    }

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        moveDishes(A.size(), A, B, C);
    }

    //递归实现盘子移动，每一次执行递归方法的结果都可被下一次递归利用
    public void moveDishes(int num, List<Integer> start, List<Integer> temp, List<Integer> end) {
        //如果某个柱子上只有一个盘子了
        if (num == 1) {
            end.add(start.remove(start.size() - 1));
        } else {
            //将start上面的n-1个通过end移动到temp上
            moveDishes(num - 1, start, end, temp);//子递归方法的递归后的结果被当前方法调用
            //将start上面的最后一个移动到end上
            end.add(start.remove(start.size() - 1));
            //将temp上的n-1个通过start移动到end上
            moveDishes(num - 1, temp, start, end);//子递归方法的递归后的结果被当前方法调用
        }
    }
}
