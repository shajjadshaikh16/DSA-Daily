/**
 * 451. Sort Characters By Frequency — LeetCode (Medium)
 *
 * Given a string s, sort characters in decreasing order of frequency.
 * Characters that appear more frequently should come first. 
 * If multiple characters have the same frequency, their order doesn't matter,
 * but identical characters must stay grouped together.
 *
 * Examples:
 *  Input: "tree"     → Output: "eert" or "eetr"
 *  Input: "cccaaa"   → Output: "cccaaa" or "aaaccc"   (not "cacaca")
 *  Input: "Aabb"     → Output: "bbAa" or "bbaA"       ('A' and 'a' are different)
 *
 * Constraints:
 *  - 1 <= s.length <= 5 * 10^5
 *  - s may contain uppercase, lowercase letters, and digits
 */
import java.util.*;

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char c:s.toCharArray()){
            freq.put(c, freq.getOrDefault(c,0)+1);
        }

        List<Character> chars = new ArrayList<>(freq.keySet());
        Collections.sort(chars, (a,b)->freq.get(b)-freq.get(a));

        StringBuilder sb = new StringBuilder();
        for(char c:chars){
              int count = freq.get(c);
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.frequencySort("tree"));    // "eert" or "eetr"
        System.out.println(sol.frequencySort("cccaaa"));  // "cccaaa" or "aaaccc"
        System.out.println(sol.frequencySort("Aabb"));    // "bbAa" or "bbaA"
    }
}
