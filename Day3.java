// 1035. Uncrossed Lines

// You are given two integer arrays nums1 and nums2. We write the integers of nums1 and nums2 (in the order they are given) on two separate horizontal lines.

// We may draw connecting lines: a straight line connecting two numbers nums1[i] and nums2[j] such that:

// nums1[i] == nums2[j], and
// the line we draw does not intersect any other connecting (non-horizontal) line.
// Note that a connecting line cannot intersect even at the endpoints (i.e., each number can only belong to one connecting line).

// Return the maximum number of connecting lines we can draw in this way.

// Ex1:
// Input: nums1 = [1,4,2], nums2 = [1,2,4]
// Output: 2
// Explanation: We can draw 2 uncrossed lines as in the diagram.
// We cannot draw 3 uncrossed lines, because the line from nums1[1] = 4 to nums2[2] = 4 will intersect the line from nums1[2]=2 to nums2[1]=2.




class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
    int n = nums1.length, m = nums2.length;
    if (n < m) return maxUncrossedLines(nums2, nums1);
    int[] dp = new int[m + 1];
    for (int i = 1; i <= n; i++) {
    int prev = 0;
    for (int j = 1; j <= m; j++) {
    int curr = dp[j];
    if (nums1[i-1] == nums2[j-1]) {
    dp[j] = prev + 1;
    } else {
    dp[j] = Math.max(dp[j-1], curr);
    }
    prev = curr;
    }
    }
    return dp[m];
    }
    }