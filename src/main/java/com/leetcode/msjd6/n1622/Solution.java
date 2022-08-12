package com.leetcode.msjd6.n1622;

import java.util.*;

/**
 * @Author: Nic1
 * @Date: 2022/2/14 21:21
 * @Theme: 兰顿蚂蚁
 */
class Solution {
    public static void main(String[] args) {
        List<String> list = new Solution().printKMoves(15);
        System.out.println(list);
    }

    //为了不使用坐标系表示网格（因为网格可能超出边界0），使用坐标对象来表示
    private class Position {
        int x, y;//横纵坐标

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Position)) {
                return false;
            }
            Position o = (Position) obj;
            return x == o.x && y == o.y;
        }

        @Override
        public int hashCode() { //hashCode将被HashSet集合调用
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public List<String> printKMoves(int K) {
        char[] direction = {'L', 'U', 'R', 'D'};//左上右下
        //旋转方向表示
        int[][] offset = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};//左上右下（坐标系正方向x轴朝右，y轴朝下）
        //方向序号选择
        int andDir = 2;
        //蚂蚁位置
        Position antPos = new Position(0, 0);
        //使用HashSet集合记录所有黑块位置，并且路径做标集合可以使用黑块+蚂蚁位置来表示
        Set<Position> blackSet = new HashSet<>();
        while (K > 0) {
            //尝试将新的坐标对象放入集合
            Position t = new Position(antPos.x, antPos.y);
            //如果当前脚下的块能放入集合，意味着当前块为白块，使方向序号自增1（方向向右旋转）
            if (blackSet.add(t)) {
                andDir = (andDir + 1) % 4;//之前是向右旋，现在向下旋转
            } else { //否则说明脚下的块已经在集合中，也就意味着当前块是黑色，方向序号循环自增3（方向向左旋转）
                andDir = (andDir + 3) % 4;//之前是向右旋转，现在向上旋转
                blackSet.remove(t);//将黑块变白
            }
            //移动蚂蚁位置
            antPos.x += offset[andDir][0];//x+方向向量的第0个元素
            antPos.y += offset[andDir][1];//y+方向向量的第1个元素
            K--;
        }

        //计算边界用于打印输出网格
        int left = antPos.x, top = antPos.y, right = antPos.x, bottom = antPos.y;
        //遍历HashSet，通过所有黑块获取边界
        for (Position pos : blackSet) {
            left = Math.min(pos.x, left);
            top = Math.min(pos.y, top);
            right = Math.max(pos.x, right);
            bottom = Math.max(pos.y, bottom);
        }
        char[][] grid = new char[bottom - top + 1][right - left + 1];
        //全部先初始化为白块
        for (char[] row : grid) {
            Arrays.fill(row, '_');
        }
        //替换黑块
        for (Position pos : blackSet) {
            grid[pos.y - top][pos.x - left] = 'X';
        }
        //替换蚂蚁
        grid[antPos.y - top][antPos.x - left] = direction[andDir];//antPos为当前蚂蚁所在位置
        //利用网络个生成字符串列表
        List<String> res = new ArrayList<>();
        for (char[] row : grid) {
            res.add(String.valueOf(row));
        }
        return res;
    }
}
