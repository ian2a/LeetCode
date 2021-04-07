public class Solution {
  public void sort(LinkedList<Integer> s1) {
    if (s1 == null || s1.size() <= 1) {
      return;
    }
    LinkedList<Integer> s2 = new LinkedList<Integer>();
    // Write your solution here.
    while (!s1.isEmpty()) {
      int min = Integer.MAX_VALUE;
      int count = 0;
      // Move all elements of s1 to s2
      while (!s1.isEmpty()) {
        int val = s1.pollFirst();
        if (val == min) {
          count++;
        } else if (val < min) {
          min = val;
          count = 1;
        }
        s2.offerFirst(val);
      }

      while (!s2.isEmpty() && s2.peekFirst() >= min) {
        int val = s2.pollFirst();
        if (val != min) {
          s1.offerFirst(val);
        }
      }
      while (count-- > 0) {
        s2.offerFirst(min);
      }
    }
    while (!s2.isEmpty()) {
      s1.offerFirst(s2.pollFirst());
    }
  }
}
