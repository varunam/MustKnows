package upgrad

import java.util.*

fun main() {
    print("Enter a number to find factorial: ")
    val scanner = Scanner(System.`in`)
    val number = scanner.nextInt()
    print("Factorial of $number is ${findFactorial(number)}")
}

fun findFactorial(number: Int): Int {
    return if (number == 1) {
        1
    } else {
        number * findFactorial(number - 1)
    }
}