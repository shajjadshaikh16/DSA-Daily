// 796. Rotate String
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

// A shift on s consists of moving the leftmost character of s to the rightmost position.

// For example, if s = "abcde", then it will be "bcdea" after one shift.
 

// Example 1:

// Input: s = "abcde", goal = "cdeab"
// Output: true
// Example 2:

// Input: s = "abcde", goal = "abced"
// Output: false
class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        String doubled = s+s;
        return doubled.contains(goal);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.rotateString("abcde", "cdeab")); // true
        System.out.println(sol.rotateString("abcde", "cdeab")); // false
    }
}