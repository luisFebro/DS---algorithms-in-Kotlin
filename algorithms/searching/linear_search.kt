// DEFINITION: iterate through a collection of element at a time
/* CARACTERISTICS
 - fast for small to medium data sets
 - slow for big data
 - no need sorting
*/

val array = intArrayOf(9, 1, 8, 2, 3, 2, 9)

fun linearSearch(array: IntArray, value: Int): Any {
    for(i in array.indices) {
        if(array[i] == value) {
            return i
        }
    }

    return -1 // sentinel value
}

val ind = linearSearch(array, 3)

if(ind != -1) {
    println("Element found is: $ind")
} else {
    println("Not found")
}
