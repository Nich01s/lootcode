package com.leetcode.msjd6.n1711;

/**
 * @Author: Nic1
 * @Date: 2022/3/9 20:51
 * @Theme: 单词距离
 */
//方法：双指针(快慢指针)：只要快指针指向单词=慢指针指向单词，就将慢指针=快指针
//                      只要快指针指向单词word1或word2时，快指针指向单词！=慢指针指向单词，就计算一次距离，然后将慢指针=快指针
class Solution {
    public static void main(String[] args) {
        String[] words = new String[]{"a", "b", "c", "d", "e", "f", "g", "a", "b", "c", "d", "e", "f", "g"};
        String word1 = "a";
        String word2 = "f";
        int closest = new Solution().findClosest(words, word1, word2);
        System.out.println(closest);
    }

    public int findClosest(String[] words, String word1, String word2) {
        int minDis = Integer.MAX_VALUE;
        int slow = 0;
        int fast = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                slow = i;
                fast = slow;
                break;
            }
        }
        while (fast < words.length) {
            if ((words[fast].equals(word1) || words[fast].equals(word2)) && (!words[fast].equals(words[slow]))) {
                minDis = Math.min(minDis, fast - slow);
                slow = fast;
            } else if ((words[fast].equals(word1) || words[fast].equals(word2)) && (words[fast].equals(words[slow]))) {
                slow = fast;
            }
            fast++;
        }
        return minDis;
    }
}
