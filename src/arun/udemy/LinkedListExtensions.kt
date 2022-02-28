package udemy


fun <T> LinkedList<T>.printInReverse() {
    nodeAt(0)?.printInReverse()
}

fun <T> Node<T>.printInReverse() {
    next?.printInReverse()

    if (next != null) {
        print(" -> ")
    }
    print(data)
}

fun <T> LinkedList<T>.getMiddle(): Node<T>? {
/*
    In the while declaration, you bind the next node to fast. If there’s a next node, you update fast to the next node
    of fast, effectively traversing down the list twice. slow is updated only once.
    This is also known as the runner technique.
*/
    var slow = nodeAt(0)
    var fast = nodeAt(0)

    while (fast != null) {
        fast = fast.next
        if (fast != null) {
            fast = fast.next
            slow = slow?.next
        }
    }

    return slow
}
