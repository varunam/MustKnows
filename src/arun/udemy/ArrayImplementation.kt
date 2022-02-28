package udemy

fun main(args: Array<String>) {
    val array = arrayOf(1, 2, 3, 5, 6, 7)
    addElement(array, 3, 44)
    searchElement(array)
    deleteElement(array)
}

/**
 * Adds the given element to the given index in the array.
 */
fun addElement(originalArray: Array<Int>, index: Int, elementToAdd: Int) {
    val newArray = IntArray(originalArray.size + 1)
    for (i in 0 until index) {
        newArray[i] = originalArray[i]
    }
    newArray[index] = elementToAdd
    for (i in index + 1 until newArray.size) {
        newArray[i] = originalArray[i - 1]
    }
    println(newArray.contentToString())
}

private fun deleteElement(array: Array<Int>) {
    // Deleting an element in the array
    val newArray = deleteElement(array, 44)
    println(newArray.contentToString())
}

private fun searchElement(array: Array<Int>) {
    // Searching an element in array
    val elementToSearch = 44
    val index = search(array, elementToSearch)
    println("Element $elementToSearch found at index: $index")
}

/**
 * Returns the index if found, else returns -1
 */
fun search(array: Array<Int>, elementToSearch: Int): Int {
    var index = -1
    array.forEachIndexed { i, item ->
        if (elementToSearch == item) {
            index = i
        }
    }
    return index
}

fun deleteElement(array: Array<Int>, elementToDelete: Int): Array<Int> {
    val index = search(array, elementToDelete)
    return if (index >= 0) {
        for (i in index + 1 until array.size) {
            array[i - 1] = array[i];
        }
        array
    } else {
        array
    }
}