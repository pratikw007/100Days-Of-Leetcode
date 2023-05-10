// 59. Spiral Matrix II
// Day 2 ;- 10/05/2023
// Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

// Example 1:
// Input: n = 3
// Output: [[1,2,3],[8,9,4],[7,6,5]]

// Example 2:
// Input: n = 1
// Output: [[1]]


class Solution {
    public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    int up = 0, down = n - 1, left = 0, right = n - 1, ct = 1;
    while (ct <= n * n) {
    for (int j = left; j <= right && ct <= n * n; j++)
    matrix[up][j] = ct++;
    for (int i = up + 1; i <= down - 1 && ct <= n * n; i++)
    matrix[i][right] = ct++;
    for (int j = right; j >= left && ct <= n * n; j--)
    matrix[down][j] = ct++;
    for (int i = down - 1; i >= up + 1 && ct <= n * n; i--)
    matrix[i][left] = ct++;
    left++; right--; up++; down--;
    }
    return matrix;
    }
    }