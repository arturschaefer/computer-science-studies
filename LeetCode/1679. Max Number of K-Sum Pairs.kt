class Solution {
    // Time complexity: O(n log n)
    // Space complexity: O(1)
    fun maxOperations(nums: IntArray, k: Int): Int {
        nums.sort()

        var count = 0
        var left = 0
        var right = nums.lastIndex

        while(left < right){
            if (nums[left] + nums[right] == k){
                count++
                left++
                right--
            } else if (nums[left] + nums[right] < k) {
                left++
            } else{
                right--
            }
        }

        return count
    }
}