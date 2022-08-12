package com.leetcode.msjd6.n1726;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @Author: Nic1
 * @Date: 2022/2/14 12:21
 * @Theme: 稀疏相似度
 */
//方法：倒排索引原理
class Solution {
    public static void main(String[] args) {
        //int[][] docs = new int[][]{{14, 15, 100, 9, 3}, {32, 1, 9, 3, 5}, {15, 29, 2, 6, 8, 7}, {7, 10}};
        //List<String> list = computeSimilarities(docs);
        //System.out.println(list);

        List<String> s1 = new ArrayList<>(Arrays.asList("0,63: 0.0147","2,13: 0.0192","2,49: 0.0133","2,56: 0.0164","2,79: 0.0156","3,56: 0.0133","3,68: 0.0112","3,73: 0.0250","4,44: 0.0208","4,58: 0.0185","4,59: 0.0227","4,79: 0.0159","4,87: 0.0208","5,48: 0.0476","5,55: 0.0333","5,72: 0.0345","6,8: 0.0278","6,56: 0.0217","7,9: 0.0175","7,75: 0.0164","7,84: 0.0179","8,46: 0.0244","9,37: 0.0189","10,91: 0.0159","10,99: 0.0147","12,14: 0.0182","12,76: 0.0172","12,82: 0.0164","12,92: 0.0400","13,20: 0.0286","13,21: 0.0145","13,37: 0.0204","13,56: 0.0161","13,88: 0.0139","14,34: 0.0185","14,99: 0.0238","16,17: 0.0556","16,65: 0.0270","16,85: 0.0182","16,92: 0.0357","18,28: 0.0244","18,31: 0.0182","18,43: 0.0169","19,21: 0.0179","19,47: 0.0244","19,71: 0.0278","19,94: 0.0175","20,29: 0.0323","20,38: 0.0185","20,72: 0.0435","20,84: 0.0263","20,88: 0.0185","21,36: 0.0109","21,50: 0.0120","21,75: 0.0130","21,79: 0.0123","21,88: 0.0114","22,90: 0.0244","23,58: 0.0127","23,59: 0.0145","23,95: 0.0123","23,98: 0.0102","24,72: 0.0233","25,66: 0.0244","25,72: 0.0208","27,67: 0.0385","27,76: 0.0149","27,93: 0.0135","28,75: 0.0208","30,56: 0.0233","30,93: 0.0189","31,56: 0.0159","32,95: 0.0294","33,74: 0.0244","35,59: 0.0161","36,87: 0.0137","37,42: 0.0278","38,67: 0.0143","38,97: 0.0161","39,71: 0.0303","39,77: 0.0435","39,90: 0.0435","40,59: 0.0294","40,66: 0.0455","40,90: 0.0370","41,50: 0.0189","41,78: 0.0179","42,76: 0.0192","43,44: 0.0182","43,70: 0.0182","44,45: 0.0149","44,78: 0.0149","44,90: 0.0278","45,75: 0.0128","45,83: 0.0161","46,62: 0.0400","47,81: 0.0167","47,85: 0.0167","48,51: 0.1250","48,86: 0.0714","50,52: 0.0179","50,87: 0.0156","51,69: 0.0238","53,64: 0.0182","53,86: 0.0238","54,75: 0.0123","54,96: 0.0172","55,95: 0.0213","56,67: 0.0167","57,66: 0.0208","57,93: 0.0116","58,69: 0.0143","58,87: 0.0189","60,64: 0.0250","62,90: 0.0455","63,93: 0.0112","65,94: 0.0172","69,80: 0.0130","70,80: 0.0167","71,87: 0.0217","72,77: 0.0370","74,75: 0.0185","74,90: 0.0312","75,78: 0.0128","75,89: 0.0244","78,85: 0.0132","81,99: 0.0122","82,89: 0.0208","87,90: 0.0278","88,91: 0.0111","91,98: 0.0108","92,98: 0.0185"));
        List<String> s2 = new ArrayList<>(Arrays.asList("60,64: 0.0250","18,43: 0.0169","27,67: 0.0385","2,56: 0.0164","35,59: 0.0161","27,76: 0.0149","19,71: 0.0278","36,87: 0.0137","69,80: 0.0130","44,90: 0.0278","2,49: 0.0133","19,94: 0.0175","3,73: 0.0250","27,93: 0.0135","43,44: 0.0182","3,68: 0.0112","44,78: 0.0149","45,83: 0.0161","20,72: 0.0435","12,82: 0.0164","78,85: 0.0132","12,92: 0.0400","70,80: 0.0167","4,87: 0.0208","53,64: 0.0182","28,75: 0.0208","18,31: 0.0182","9,37: 0.0189","18,28: 0.0244","4,79: 0.0159","2,13: 0.0192","20,88: 0.0185","12,76: 0.0172","45,75: 0.0128","20,84: 0.0263","50,52: 0.0179","53,86: 0.0238","0,63: 0.0147","58,69: 0.0143","25,66: 0.0244","92,98: 0.0185","4,58: 0.0185","4,59: 0.0227","20,38: 0.0185","75,89: 0.0244","25,72: 0.0208","4,44: 0.0208","37,42: 0.0278","58,87: 0.0189","10,99: 0.0147","19,21: 0.0179","50,87: 0.0156","42,76: 0.0192","75,78: 0.0128","19,47: 0.0244","3,56: 0.0133","91,98: 0.0108","51,69: 0.0238","10,91: 0.0159","2,79: 0.0156","20,29: 0.0323","43,70: 0.0182","44,45: 0.0149","12,14: 0.0182","65,94: 0.0172","6,56: 0.0217","40,90: 0.0370","48,86: 0.0714","13,21: 0.0145","13,20: 0.0286","56,67: 0.0167","7,84: 0.0179","14,34: 0.0185","7,75: 0.0164","23,95: 0.0123","30,56: 0.0233","40,66: 0.0455","24,72: 0.0233","16,85: 0.0182","57,66: 0.0208","5,48: 0.0476","13,56: 0.0161","23,98: 0.0102","74,90: 0.0313","46,62: 0.0400","16,92: 0.0357","5,55: 0.0333","81,99: 0.0122","21,36: 0.0109","16,65: 0.0270","6,8: 0.0278","33,74: 0.0244","13,37: 0.0204","82,89: 0.0208","21,50: 0.0120","41,78: 0.0179","57,93: 0.0116","74,75: 0.0185","32,95: 0.0294","21,75: 0.0130","54,75: 0.0123","21,79: 0.0123","41,50: 0.0189","13,88: 0.0139","71,87: 0.0217","7,9: 0.0175","14,99: 0.0238","87,90: 0.0278","5,72: 0.0345","21,88: 0.0114","8,46: 0.0244","62,90: 0.0455","38,67: 0.0143","47,81: 0.0167","16,17: 0.0556","40,59: 0.0294","39,90: 0.0435","48,51: 0.1250","47,85: 0.0167","54,96: 0.0172","22,90: 0.0244","23,59: 0.0145","88,91: 0.0111","23,58: 0.0127","39,77: 0.0435","72,77: 0.0370","55,95: 0.0213","31,56: 0.0159","38,97: 0.0161","63,93: 0.0112","39,71: 0.0303","30,93: 0.0189"));

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.size(); i++) {
            map.put(s1.get(i),1);
        }
        int flag = 0;
        for (int i = 0; i < s2.size(); i++) {
            if (!map.containsKey(s2.get(i))){
                flag = i;
                break;
            }
        }
        flag = flag;
    }

    public static List<String> computeSimilarities(int[][] docs) {

        List<String> res = new ArrayList<>();//记录结果
        Map<Integer, List<Integer>> map = new HashMap<>();//key:当前元素，value:所在行索引
        for (int i = 0; i < docs.length; i++) {
            for (int j = 0; j < docs[i].length; j++) {
                if (!map.containsKey(docs[i][j])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(docs[i][j], list);
                } else {
                    map.get(docs[i][j]).add(i);
                }
            }
        }
        int[][] nums = new int[docs.length][docs.length];//记录两两索引的相同数字个数
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) { //遍历hashmap
            List<Integer> list = entry.getValue();
            if (list.size() > 1) {
                for (int i = 0; i < list.size() - 1; i++) {
                    for (int j = i + 1; j < list.size(); j++) {
                        nums[list.get(i)][list.get(j)]++;
                    }
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums[i].length; j++) {
                if (nums[i][j] != 0) {
                    //计算相似度（相似度=交集数/并集数=交集数/(len1+len2-交集数)）
                    res.add(i + "," + j + ": " + String.format("%.4f",(double) nums[i][j] / (docs[i].length + docs[j].length - nums[i][j])));//保留4位小数
                }
            }
        }
        return res;
    }
}

