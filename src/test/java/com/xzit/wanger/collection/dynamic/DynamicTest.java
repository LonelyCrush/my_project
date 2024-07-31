package com.xzit.wanger.collection.dynamic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class DynamicTest {

    /**
     * Fibonacci数列
     * = 1 （n = 0, 1）
     * = F(n-1) + F(n-2) （n > 1）
     */
    @Test
    public void main1() {
        long flag1 = System.currentTimeMillis();
        System.out.println(recursiveImpl(10));
        System.out.println(arrayRecursiveImpl(10));
        long flag2 = System.currentTimeMillis();
        System.out.println("spendTime: " + (flag2 - flag1) + " ms");
    }

    /**
     * 其中F（3）被计算了两次
     * F（4）=F（3）+F（2）
     * F（3）=F（2）+F（1）；
     * @param n 长度
     * @return 和
     */
    private int recursiveImpl(int n) {
        return n == 0 || n == 1 ? 1 : recursiveImpl(n - 1) + recursiveImpl(n - 2);
    }

    private int arrayRecursiveImpl (int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    /**
     * 动态规划
     */
    @Test
    public void main2() {
        // 定义一个二维数组
        int[][] num = new int[5][5];
        // 填充
        num[0][0] = 9;
        num[1][0] = 12; num[1][1] = 15;
        num[2][0] = 10; num[2][1] = 6;  num[2][2] = 8;
        num[3][0] = 2;  num[3][1] = 18; num[3][2] = 9;  num[3][3] = 5;
        num[4][0] = 19; num[4][1] = 7;  num[4][2] = 10; num[4][3] = 4; num[4][4]=16;
        // 多维数组数据展示
        System.out.println(Arrays.deepToString(num));
        // 二维数组高度
        System.out.println(num.length);
        // 二维数组宽度
        System.out.println(num[0].length);
        // 计算
        System.out.println(dynamicProgrammingCalculate(num, num.length, num[0].length));
    }

    private int dynamicProgrammingCalculate(int[][] num, int height, int width) {
        for (int i = height - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                num[i][j] += Math.max(num[i + 1][j], num[i + 1][j + 1]);
            }
        }
        return num[0][0];
    }
}
