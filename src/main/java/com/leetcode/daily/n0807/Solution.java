package com.leetcode.daily.n0807;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: Nic1
 * @Date: 2022/8/7 18:47
 * @Theme: 函数的独占时间
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");
        int[] ints = s.exclusiveTime(2, logs);
        System.out.println(ints);
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] res = new int[n];//记录结果
        for (String log : logs) {
            int idx = Integer.parseInt(log.substring(0, log.indexOf(':')));
            String type = log.substring(log.indexOf(':') + 1, log.lastIndexOf(':'));
            int timestamp = Integer.parseInt(log.substring(log.lastIndexOf(':') + 1));
            if ("start".equals(type)) {
                if (!stack.isEmpty()) {
                    res[stack.peek()[0]] += timestamp - stack.peek()[1];
                    stack.peek()[1] = timestamp;
                }
                stack.push(new int[]{idx, timestamp});
            } else {
                //"end"
                int[] t = stack.pop();
                res[t[0]] += timestamp - t[1] + 1;
                if (!stack.isEmpty()) {
                    stack.peek()[1] = timestamp + 1;
                }
            }
        }
        return res;
    }
}
