package udemy


data class Node<T>(var data: T, var next: Node<T>? = null) {
    override fun toString(): String {
        return if (this.next != null) {
            "$data ${next.toString()}"
        } else {
            "$data"
        }
    }
}

class LinkedList<T>: Iterable<T>, Collection<T>, MutableIterable<T>, MutableCollection<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    override var size: Int = 0
        private set

    override fun isEmpty(): Boolean {
        return size == 0
    }

    fun push(data: T): LinkedList<T> {
        head = Node(data = data, next = head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    fun append(data: T): LinkedList<T> {
        if (isEmpty()) {
            push(data)
            return this
        }
        tail?.next = Node(data, next = null)
        this.tail = tail?.next
        size++
        return this
    }

    fun nodeAt(index: Int): Node<T>? {
        return when (index) {
            0 -> {
                head
            }
            size - 1 -> {
                tail
            }
            else -> {
                var currentNode = head
                var currentIndex = 0
                while (currentIndex < index && currentNode != null) {
                    currentNode = currentNode.next
                    currentIndex++
                }
                currentNode
            }
        }
    }

    fun insert(data: T, afterIndex: Int): LinkedList<T> {
        val newNode = Node(data)
        when (val afterNode = nodeAt(afterIndex)) {
            tail, null -> {
                append(data)
            }
            else -> {
                newNode.next = afterNode.next
                afterNode.next = newNode
                size++
            }
        }
        return this
    }

    fun pop(): T? {
        if (!isEmpty()) {
            size--
        }
        val result = head?.data
        head = head?.next
        if (isEmpty()) {
            tail = null
        }
        return result
    }

    fun removeLast(): T? {
        val head = head ?: return null
        if (head.next == null) {
            pop()
        }
        size--

        var prev = head
        var current = head
        var next = current.next
        while (next != null) {
            prev = current
            current = next
            next = current.next
        }

        prev.next = null
        tail = prev
        return current.data
    }

    fun removeAfter(index: Int): T? {
        val node = nodeAt(index) ?: return null

        if (node.next == tail) {
            // Update the tail node when the tail node is removed
            tail = node
        }

        if (node.next != null) {
            size--
        }

        node.next = node.next?.next
        return node.next?.data
    }

    fun removeAfter(node: Node<T>): T? {
        if (node.next == tail) {
            // Update the tail node when the tail node is removed
            tail = node
        }

        if (node.next != null) {
            size--
        }

        node.next = node.next?.next
        return node.next?.data
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty List"
        } else {
            head.toString() + " | Size " + size
        }
    }

    override fun iterator(): MutableIterator<T> {
        return LinkedListIterator(this)
    }

    override fun contains(element: T): Boolean {
        for (item in this) {
            if (item == element) {
                return true
            }
        }
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        for (searched in elements) {
            if (!contains(searched)) {
                return false
            }
        }
        return true
    }

    override fun add(element: T): Boolean {
        append(element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean {
        for (item in elements) {
            add(item)
        }
        return true
    }

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun remove(element: T): Boolean {
        val iterator = iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (item == element) {
                return true
            }
        }
        return false
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        for (item in elements) {
            result = remove(item) || result
        }
        return result
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        var result = false
        val iterator = iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (!elements.contains(item)) {
                iterator.remove()
                result = true
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
    val linkedList = LinkedList<String>()
    linkedList.push("n").push("r").push("a")

    linkedList.append("y")

    linkedList.insert("u", 1)
    println(linkedList.toString())

    linkedList.insert("OutOfBounds", 23)
    println(linkedList.toString())

    linkedList.pop()
    println(linkedList.toString())

    linkedList.removeLast()
    println(linkedList.toString())

    linkedList.insert("junk", linkedList.size - 1)
    println(linkedList.toString())

    linkedList.removeAfter(linkedList.size - 2)
    println(linkedList.toString())

    println("\nPrinting Using Iterator")
    for (item in linkedList) {
        println(item)
    }

    linkedList.printInReverse()
}