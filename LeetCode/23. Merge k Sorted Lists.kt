/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
private class Solution {
    // Time complexity: O(n log k), where k is the number of linked lists
    // Space complexity: O(n + k), where k is the PriorityQueue space
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val queue = PriorityQueue<ListNode>(compareBy { it.`val` })
        
        lists.forEach {
            it?.let { queue.add(it) }
        }

        val result = ListNode(0)
        var prev = result

       while (queue.isNotEmpty()) {
            val minNode = queue.poll()
            minNode.next?.let { queue.add(it) }
            prev.next = minNode
            prev = minNode
        }
        
        return result.next
    }
}