// Input n = 153
// Output = true

// Input n = 123
// Output = false

class Solution {
    // only positive integers
    fun isArmstrong(n: Int): Boolean {
        val number = n.toString()
        val size = number.length
        var sum = 0
        
        number.forEach{ char ->
          val temp = char.digitToInt().toDouble().pow(size)
          sum += temp.toInt()
        }

        return sum == n
    }
}