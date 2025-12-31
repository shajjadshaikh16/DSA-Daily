/**
 * 13. Roman to Integer — LeetCode (Easy)
 *
 * Convert a valid Roman numeral string to an integer.
 * Roman symbols add their value unless a smaller value comes before a larger one,
 * in which case we subtract (e.g., IV=4, IX=9, XL=40, XC=90, CD=400, CM=900).
 *
 * Examples:
 *  "III"      → 3
 *  "LVIII"    → 58     (L=50, V=5, III=3)
 *  "MCMXCIV"  → 1994   (M=1000, CM=900, XC=90, IV=4)
 *
 * Constraints:
 *  - 1 <= s.length <= 15
 *  - s contains: I, V, X, L, C, D, M
 * https://leetcode.com/problems/roman-to-integer/description/
 * tc: O(n)
 * sc: O(1)
 */
class Solution {
    public int romanToInt(String s) {
        int[] val = new int[26];
        val['I' - 'A'] = 1;
        val['V' - 'A'] = 5;
        val['X' - 'A'] = 10;
        val['L' - 'A'] = 50;
        val['C' - 'A'] = 100;
        val['D' - 'A'] = 500;
        val['M' - 'A'] = 1000;

        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int curr = val[s.charAt(i) - 'A'];
            // if next symbol is larger, subtract current; else add
            if (i + 1 < n) {
                int next = val[s.charAt(i + 1) - 'A'];
                if (curr < next) {
                    ans -= curr;
                    continue;
                }
            }
            ans += curr;
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.romanToInt("III"));      // 3
        System.out.println(sol.romanToInt("LVIII"));    // 58
        System.out.println(sol.romanToInt("MCMXCIV"));  // 1994
    }
}
