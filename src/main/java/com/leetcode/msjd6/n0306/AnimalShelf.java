package com.leetcode.msjd6.n0306;

/**
 * @Author: Nic1
 * @Date: 2022/7/29 23:50
 * @Theme: 动物收容所
 */

import java.util.LinkedList;

/**
 * 严格遵守“先进先出”
 * 收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）
 * dequeue方法返回:[动物编号, 动物种类],animal[0]代表动物编号，animal[1]代表动物种类，其中0代表猫，1代表狗。
 * 若没有可以收养的动物，则返回[-1,-1],
 * （可以使用LinkedList数据结构）
 */
public class AnimalShelf {

    public static void main(String[] args) {
        AnimalShelf animalShelf = new AnimalShelf();
        animalShelf.enqueue(new int[]{0, 0});
        animalShelf.enqueue(new int[]{1, 0});
        animalShelf.enqueue(new int[]{2, 1});
        int[] ints0 = animalShelf.dequeueDog();
        int[] ints1 = animalShelf.dequeueCat();
        int[] ints2 = animalShelf.dequeueAny();

    }

    //猫/狗队列存储的是编号
    LinkedList<Integer> catQueue;//猫队列
    LinkedList<Integer> dogQueue;//狗队列

    public AnimalShelf() {
        catQueue = new LinkedList<>();
        dogQueue = new LinkedList<>();
    }

    //入队
    public void enqueue(int[] animal) {
        //如果是狗，进入狗队列
        if (animal[1] == 0) {
            catQueue.addLast(animal[0]);
        } else {
            dogQueue.addLast(animal[0]);
        }
    }

    //出队
    public int[] dequeueAny() {
        //如果两个队列都为空
        if (catQueue.isEmpty() && dogQueue.isEmpty()) {
            return new int[]{-1, -1};
        }
        //如果都不为空
        else if (!catQueue.isEmpty() && !dogQueue.isEmpty()) {
            int[] res = new int[2];
            if (catQueue.getFirst() > dogQueue.getFirst()) {
                return new int[]{dogQueue.removeFirst(),1};
            }else {
                return new int[]{catQueue.removeFirst(),0};
            }
        }
        //狗队列不为空，猫队列为空
        else if (!dogQueue.isEmpty()) {
            return new int[]{dogQueue.removeFirst(), 1};
        }
        //如果猫队列不为空，狗队列为空
        else {
            return new int[]{catQueue.removeFirst(), 0};
        }
    }

    //狗出队
    public int[] dequeueDog() {
        if (dogQueue.isEmpty()) {
            return new int[]{-1, -1};
        }
        return new int[]{dogQueue.removeFirst(), 1};
    }

    //猫出队
    public int[] dequeueCat() {
        if (catQueue.isEmpty()) {
            return new int[]{-1, -1};
        }
        return new int[]{catQueue.removeFirst(), 0};
    }
}
