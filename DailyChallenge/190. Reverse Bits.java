public class Solution {
  public long reverseBits(long n) {
		// 0 1 0 0 1 1 ... 0
    // j               i
    // left          right

    int left = 31;
    int right = 0;
    while (left > right){
      if (((n >> left) & 1) != ((n >> right) & 1)) {
        n ^= ((1L << left) | (1L << right));
      }
      left--;
      right++;
    }
    return n;
  }
}
