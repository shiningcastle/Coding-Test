class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.replace("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder(s);
        int len = sb.length();
        for (int i = len-k; i > 0; i -= k) {
            sb.insert(i, '-');
        }
        return sb.toString();
    }
}