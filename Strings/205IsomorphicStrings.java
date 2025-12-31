// https://leetcode.com/problems/isomorphic-strings/
class Solution {
    public static void main(String[] args) {
        // quick tests
        System.out.println(isIsomorphic("egg", "add")); // true
        System.out.println(isIsomorphic("foo", "bar")); // false
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] mapA = new int[256];
        int[] mapB = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (mapA[a] == 0 && mapB[b] == 0) {
                mapA[a] = b;
                mapB[b] = a;
            } else {
                if (mapA[a] != b || mapB[b] != a) {
                    return false;
                }
            }
        }
        return true;
    }
}
