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
// all the number are unique
class Solution {
    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) return null
        
        val root = TreeNode(preorder[0])
        var prevNode = root
        
        for(i in 1..preorder.lastIndex) {
            val curr = preorder[i]
            val newNode = TreeNode(curr)

            if (prevNode.`val` > newNode.`val`){
                prevNode.left = newNode
            } else {
                putNode(root, newNode)
            }
            
            prevNode = newNode
        }
        
        return root
    }
    
    fun putNode(root: TreeNode, newNode: TreeNode) {
        if (newNode.`val` < root.`val`){
            if (root.left != null){
                putNode(root.left, newNode)
            } else {
                root.left = newNode
            }
        } else {
            if (root.right != null) {
                putNode(root.right, newNode)
            } else {
                root.right = newNode
            }
        }
    }
}
