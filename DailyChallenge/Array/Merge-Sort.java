public class Solution {

  public int[] sortArray(int[] array) {
    // Write your solution here
    // Corner cases
    if (array == null || array.length == 0) {
      return array;
    }
    sortArray(array, new int[array.length], 0, array.length - 1);
    return array;
  }

  private void sortArray(int[] array, int[] temp, int start, int end) {
    // Base case: when the array cannot be divided in half any more
    if (start >= end) {
      return;
    }
    // Divide the array into two halves each time
    // And sort the two parts respectively
    int mid = start + (end - start) / 2;
    sortArray(array, temp, start, mid);
    sortArray(array, temp, mid + 1, end);
    // Merge the two sorted halves into one big sorted array
    mergeArray(array, temp, start, mid, end);
  }

  private void mergeArray(
    int[] array,
    int[] temp,
    int start,
    int mid,
    int end
  ) {
    // Copy the array to temp such that we can do comparisons only on the temp array,
    // while operating on the original array to make it like in-place operations
    temp = Arrays.copyOf(array, array.length);
    // Merge the two parts according to their values: smaller --> larger
    int left = start;
    int right = mid + 1;
    int index = start;
    while (left <= mid && right <= end) {
      if (temp[left] < temp[right]) {
        array[index++] = temp[left++];
      } else {
        array[index++] = temp[right++];
      }
    }
    // When there are left-over elements, only the ones in the left part should be concerned
    // because the ones in the right part are already in order.
    while (left <= mid) {
      array[index++] = temp[left++];
    }
  }
}
