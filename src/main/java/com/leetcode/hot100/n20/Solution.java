package com.leetcode.hot100.n20;

import java.util.Stack;

/**
 * @Author: Nic1
 * @Date: 2022/2/9 19:24
 * @Theme: 有效的括号
 */
class Solution {
    public boolean isValid(String s) {
        if (s==null){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='{'||s.charAt(i)=='('||s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else {
                if (stack.empty()){
                    return false;
                }
                if (s.charAt(i)=='}'&&stack.peek()!='{'){
                    return false;
                }
                if (s.charAt(i)=='}'&&stack.peek()=='{'){
                    stack.pop();
                }
                if (s.charAt(i)==')'&&stack.peek()!='('){
                    return false;
                }
                if (s.charAt(i)==')'&&stack.peek()=='('){
                    stack.pop();
                }
                if (s.charAt(i)==']'&&stack.peek()!='['){
                    return false;
                }
                if (s.charAt(i)==']'&&stack.peek()=='['){
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }
}
