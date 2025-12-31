/**
 * 151. Reverse Words in a String — LeetCode (Medium)
 *
 * Given a string s, reverse the order of characters in each word within a sentence
 * while still preserving whitespace and initial word order.
 *
 * Examples:
 *  "the sky is blue"      → "blue is sky the"
 *  "  hello world  "      → "world hello"
 *  "a good   example"     → "example good a"
 *
 * Constraints:
 *  - 1 <= s.length <= 10^4
 *  - s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 *  - There is at least one word in s.
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 * tc: O(n)
 * sc: O(n)
 */
class Solution {
    public String reverseWords(String s) {
        s =s.trim();
        String[] words = s.split("\\s+");
   StringBuilder rev = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            rev.append(words[i]);
            if(i>0) rev.append(" ");
        }

        return rev.toString();
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverseWords("the sky is blue"));      // "blue is sky the"
        System.out.println(sol.reverseWords("  hello world  "));      // "world hello"
        System.out.println(sol.reverseWords("a good   example"));     // "example good a"
    }
}