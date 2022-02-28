package upgrad

import java.util.*


private fun sum(n: Int): Int {
    return if (n == 0) {
        0
    } else {
        n % 10 + sum(n / 10)
    }
}

fun main(list: List<String>) {
    print("Enter a number to add up all the digits: ")
    val sc = Scanner(System.`in`)
    val num = sc.nextInt()
    println(sum(num))
}
