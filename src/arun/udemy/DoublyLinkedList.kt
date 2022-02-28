package udemy

class DoubleNode(val data: Int, var prevNode: DoubleNode? = null, var next: DoubleNode? = null)


class DoubleLinkedList {
    private var headNode: DoubleNode? = null

    fun addNode(node: DoubleNode) {
        if (headNode == null) {
            node.prevNode = null
            node.next = null
            headNode = node
        } else {
            var currentNode = headNode
            while (currentNode?.next != null) {
                currentNode = currentNode.next
            }
            currentNode?.next = node
            node.prevNode = currentNode
        }
    }

    fun search(value: Int): DoubleNode? {
        var result: DoubleNode? = null
        var currentNode = headNode
        while (currentNode != null) {
            if (currentNode.data == value) {
                result = currentNode
                break
            }
            currentNode = currentNode.next
        }
        if (result != null) {
            println("value $value found in the list")
        } else {
            println("value $value not found in the list")
        }
        return result
    }

    fun delete(value: Int): Boolean {
        val node = search(value)
        if (node == null) {
            println("value $value not deleted")
            return false
        } else {
            if (node.prevNode == null) {
                node.next?.prevNode = null
                // Make the next node the head node
                headNode = node.next
            } else if (node.next == null) {
                node.prevNode?.next = null
            } else {
                node.prevNode?.next = node.next
                node.next?.prevNode = node.prevNode
            }
            println("value $value deleted")
            return true
        }
    }

    fun printContents() {
        var currentNode = headNode
        while (currentNode != null) {
            println(currentNode.data)
            currentNode = currentNode.next
        }
    }
}

fun main(args: Array<String>) {
    val doubleLinkedList = DoubleLinkedList()

    // Adding contents
    doubleLinkedList.addNode(DoubleNode(1))
    doubleLinkedList.addNode(DoubleNode(2))
    doubleLinkedList.addNode(DoubleNode(3))
    doubleLinkedList.addNode(DoubleNode(4))
    doubleLinkedList.addNode(DoubleNode(5))

    doubleLinkedList.delete(1)
    doubleLinkedList.delete(5)

    doubleLinkedList.search(1)
    doubleLinkedList.search(5)
    doubleLinkedList.search(2)
    doubleLinkedList.search(3)

    doubleLinkedList.addNode(DoubleNode(6))

    doubleLinkedList.printContents()
}