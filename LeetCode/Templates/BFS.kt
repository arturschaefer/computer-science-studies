import java.util.Deque
import java.util.LinkedList

data class TreeNode(val num: Int, val left: TreeNode? = null, val right: TreeNode? = null)

fun main() {
    val root = TreeNode(
        num = 10,
        left = TreeNode(
            num = 5,
            left = TreeNode(2),
            right = TreeNode(7)
        ),
        right = TreeNode(20)
    )

    levelOrder(root)
    println("DFS")
    dfs(root)
}

fun levelOrder(root: TreeNode){
    // safe check if root is null
    val deque: Deque<TreeNode> = LinkedList()
    deque.addLast(root)

    while (deque.isNotEmpty()){
        val size = deque.size - 1

        for (i in 0..size){
            val node = deque.removeFirst()
            println(node)

            if (node.left != null) deque.addLast(node.left)
            if (node.right != null) deque.addLast(node.right)
        }
    }
}

fun dfs(root: TreeNode?){
    if (root == null) return

    dfs(root.left)
    println(root)
    dfs(root.right)
}
