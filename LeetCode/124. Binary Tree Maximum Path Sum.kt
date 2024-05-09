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
private class Solution {
    var result = 0
    fun maxPathSum(root: TreeNode?): Int {
        result = root?.`val` ?: 0

        dfs(root)

        return result
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    fun dfs(root: TreeNode?): Int{
        if(root == null){
            return 0
        }

        val leftMax = max(dfs(root.left), 0)
        val rightMax = max(dfs(root.right), 0)
        result = max(result, root.`val` + leftMax + rightMax)

        return root.`val` + max(leftMax, rightMax)
    }

}