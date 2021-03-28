class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIndex = start + (end - start) / 2;
        int pivot = nums[pivotIndex];
        swap(nums, end, pivotIndex);
        int left = start;
        int right = end - 1;
        while (left <= right) {
            if (nums[left] < pivot) {
                left++;
            } else if (nums[right] >= pivot) {
                right--;
            } else {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        swap(nums, left, end);
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}