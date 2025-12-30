/**
 * 242. Valid Anagram — LeetCode
 *
 * Given two strings `s` and `t`, return true if `t` is an anagram of `s`, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of another,
 * typically using all original letters exactly once.
 *
 * Example 1:
 * Input:  s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input:  s = "rat", t = "car"
 * Output: false
 *
 * Constraints:
 * - 1 <= s.length, t.length <= 5 * 10^4
 * - s and t consist of lowercase English letters
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] freq = new int[26];
        for(int i = 0;i<s.length();i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for(int x:freq){
            if(x != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isAnagram("anagram", "nagaram")); // true
        System.out.println(sol.isAnagram("rat", "ar")); // false
    }
}