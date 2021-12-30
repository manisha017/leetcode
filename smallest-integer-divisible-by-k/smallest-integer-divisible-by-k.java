class Solution {
    public int smallestRepunitDivByK(int K) {
     if (K % 2 == 0 || K % 5 == 0) return -1;
    int mod = 0;
    for (int i = 1; i <= K; ++i) {
        mod = (10 * mod + 1) % K;
        if (mod == 0) {
            return i;
        }
    }
    return -1;
    
}
     
    
}