/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

 class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        var result = root
        val pVal = p?.`val` ?: -1
        val qVal = q?.`val` ?: -1

        while (result != null) {
            val currValue = result.`val` ?: 0

            if (pVal > currValue && qVal > currValue) {
                result = result?.right
            } else if (pVal < currValue && qVal < currValue) {
                result = result?.left
            } else {
                return result
            }
        }

        return null
    }
}