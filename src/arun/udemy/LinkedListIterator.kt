package udemy

class LinkedListIterator<T>(private val linkedList: LinkedList<T>) : Iterator<T>, MutableIterator<T> {
    private var index = 0

    private var lastNode: Node<T>? = null

    override fun hasNext(): Boolean {
        return index < linkedList.size
    }

    override fun next(): T {
        if (index >= linkedList.size) {
            throw IndexOutOfBoundsException()
        }

        lastNode =  if (index == 0) {
            linkedList.nodeAt(0)
        } else {
            lastNode?.next
        }

        index++
        return lastNode!!.data
    }

    override fun remove() {
        if (index == 0) {
            linkedList.pop()
        } else {
            val prevNode = linkedList.nodeAt(index - 2) ?: return
            linkedList.removeAfter(prevNode)
            lastNode = prevNode
        }
        index--
    }
}
