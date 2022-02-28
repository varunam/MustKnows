fun main(args: Array<String>) {
    searchInArray(arrayOf("ddd", "D"), "ddd")
}

fun searchInArray(arrayOfString: Array<String>, searchTerm: String) {
    arrayOfString.forEachIndexed { index, it ->
        if (it == searchTerm) {
            println("found at index $index")
        }
    }
}