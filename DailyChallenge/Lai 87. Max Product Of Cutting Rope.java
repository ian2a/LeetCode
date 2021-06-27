public class Solution {
  public int maxProduct(int length) {
    int[] product = new int[length + 1];
    product[0] = 0;
    product[1] = 0;

    for (int i = 2; i <= length; i++) {
      for (int j = 1; j <= i / 2; j++) {
        int maxProduct = Math.max(product[i - j], i - j) * j;
        product[i] = Math.max(product[i], maxProduct);
      }
    }
    return product[length];
  }
}
