class Solution {
    public long solution(long n) {
        double dn = Math.sqrt(n);
        if (dn == (long) dn)
            return (long) Math.pow(dn+1, 2);
        else
            return -1;
    }
}