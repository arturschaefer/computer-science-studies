// 1302. Deepest Leaves Sum

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
data class DepthSum(val total: Int, val depth: Int)

// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    var depth = 0
    var sum = 0

    fun deepestLeavesSum(root: TreeNode?): Int {
        dfsLevel(root, 0)
        return sum
    }

    fun dfsLevel(root: TreeNode?, level: Int) {
         root?.let {
            if (level > depth) {
                depth = level
                sum = it.`val`
            } else if (level == depth) {
                sum += it.`val`
            }
            dfsLevel(root.left, level + 1)
            dfsLevel(root.right, level + 1)
        }
    }
}
