package upgrad

import java.util.*

fun main() {
    print("Enter a number to find fibonacci number: ")
    val scanner = Scanner(System.`in`)
    val number = scanner.nextInt()
//    print("Fibonacci of $number is ${findFibonacciWithoutRecursion(number)}")
    print("Fibonacci of $number is ${findFibonacciMostEfficient(number)}")
}

private fun findFibonacciWithoutRecursion(number: Int): Int {
    val array = IntArray(number)
    array[0] = 0
    array[1] = 1
    for (i in 2 until number) {
        array[i] = array[i - 1] + array[i - 2]
    }
    return array[array.size - 1]
}

private fun findFibonacciMostEfficient(number: Int): Int {
    var (a, b, c) = listOf(0, 1, number)
    for (i in 2..number) {
        c = a + b
        a = b
        b = c
    }
    return c
}