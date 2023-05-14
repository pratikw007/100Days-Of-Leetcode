// 1799. Maximize Score After N Operations
// Hard
// 1.1K
// 84
// Companies
// You are given nums, an array of positive integers of size 2 * n. You must perform n operations on this array.

// In the ith operation (1-indexed), you will:

// Choose two elements, x and y.
// Receive a score of i * gcd(x, y).
// Remove x and y from nums.
// Return the maximum score you can receive after performing n operations.

// The function gcd(x, y) is the greatest common divisor of x and y.

 

// Example 1:

// Input: nums = [1,2]
// Output: 1
// Explanation: The optimal choice of operations is:
// (1 * gcd(1, 2)) = 1
// Example 2:

// Input: nums = [3,4,6,8]
// Output: 11
// Explanation: The optimal choice of operations is:
// (1 * gcd(3, 6)) + (2 * gcd(4, 8)) = 3 + 8 = 11


class Solution {
    public int func(int[] nums, int op, int mask, int[] dp, int[][] gcd) {
    int m = nums.length, n = nums.length/2;
    if(op > n) return 0;
    if(dp[mask] != -1) return dp[mask];
    for(int i=0; i<m; i++) {
    if( (mask & (1<<i)) != 0 ) continue;
    for(int j=i+1; j<m; j++) {
    if( (mask & (1<<j)) != 0 ) continue;
    int newMask = (1<<i) | (1<<j) | mask;
    int score = op * gcd[i][j] + func(nums, op+1, newMask, dp, gcd);
    dp[mask] = Math.max(dp[mask], score);
    }
    }
    return dp[mask];
    }
    public int maxScore(int[] nums) {
    int[] dp = new int[1<<14];
    Arrays.fill(dp, -1);
    int m = nums.length, n = nums.length/2;
    int[][] gcd = new int[m][m];
    for(int i=0; i<m; i++) {
    for(int j=0; j<m; j++) {
    gcd[i][j] = gcd(nums[i], nums[j]);
    }
    }
    return func(nums, 1, 0, dp, gcd);
    }
    private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
    }
    }