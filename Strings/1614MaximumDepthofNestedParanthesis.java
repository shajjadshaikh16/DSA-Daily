/**
 * 1614. Maximum Nesting Depth of the Parentheses — LeetCode (Easy)
 *
 * Given a valid parentheses string s, return the maximum nesting depth.
 * Depth increases when '(' is seen and decreases when ')' is seen.
 *
 * Examples:
 *  "(1+(2*3)+((8)/4))+1"      → 3
 *  "(1)+((2))+(((3)))"        → 3
 *  "()(())((()()))"           → 3
 *
 * Constraints:
 *  - 1 <= s.length <= 100
 *  - s contains digits, operators, and parentheses
 * https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/
 * tc: O(n)
 * sc: O(1)
 */
class Solution {
    public int maxDepth(String s) {
        int ans=0;
        int cnt =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                cnt++;
                ans= Math.max(cnt,ans);
            }else if(s.charAt(i) == ')'){
                cnt--;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxDepth("(1+(2*3)+((8)/4))+1")); // 3
        System.out.println(sol.maxDepth("(1)+((2))+((3))"));   // 3
        System.out.println(sol.maxDepth("()(())((()()))"));      // 3
    }
}
