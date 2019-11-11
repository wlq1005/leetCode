package com.wlq.algorithm.array;

/**
 * 旋转图像
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/31/
 * <p>
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * <p>
 * 示例 2:
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 *
 * @author wlq
 * @since 2018/5/17 19:40
 */
public class Lesson31 {

    public static void main(String[] args) {
        Lesson31 lesson31 = new Lesson31();
        int[][] matrix1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        lesson31.rotate(matrix1);
        int[][] matrix2 = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        lesson31.rotate(matrix2);
    }

    /**
     *
     * 每次交换四个
     *
     * 1  2  3          7  2  1          7  4  1
     *
     * 4  5  6    -->   4  5  6　　-->   8  5  2　　
     *
     * 7  8  9          9  8  3　　 　　 9  6  3
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < length - 1 -i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] =  matrix[length - j - 1][length - j - 1];
                matrix[length - j - 1][length - j - 1] = matrix[i][length - j - 1];
                matrix[i][length - j - 1] = temp;
            }
        }
    }
}
