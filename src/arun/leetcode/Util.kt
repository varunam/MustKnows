package arun.leetcode

import java.util.*

fun printArray(array: IntArray) {
    for (element in array) print("$element ")
    println("")
}

fun generateRandomArray(size: Int, bound: Int = 100): IntArray {
    val random = Random()
    val array = IntArray(size)
    for (i in 0 until size) {
        val number = random.nextInt(bound)
        array[i] = number
    }
    return array
}

