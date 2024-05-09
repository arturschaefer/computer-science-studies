class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    fun firstUniqChar(s: String): Int {
        val map = mutableMapOf<Char, Int>()
        var position = Int.MAX_VALUE

        for (i in 0..s.length - 1) {
            if (!map.contains(s[i])){
                map[s[i]] = i
            } else {
                map[s[i]] = Int.MAX_VALUE
            }
        }

        map.forEach { key, value ->
            position = minOf(position, value)
        }

        return if(position == Int.MAX_VALUE) -1 else position
    }
}