/* DEFINITION:
- moves smaller elements to left of a pivot, recursively divide array in 2 aprtitions
- pivot position can very: most standard form is at the end of array
- numbers to the left, should be less than pivot. Same for numbers to right. At first, they are not sorted
- dividing-and-conquer algo
 */

/* CARACTERISTICS
RUNTIME COMPLEXITY
Best and avg. case O(n log(n)) - quasilinear time
Worst case quadratic time O(n^2) - if arealdy sorted (rare case)

SPACE COMPLEXITY
O(log(n)) due to recursion
*/

val array = intArrayOf(8, 2, 5, 3, 4, 7, 6, 1)

quickSort(array, 0, array.size - 1)

for(i in array) {
    println(i)
}

fun quickSort(array: IntArray, start: Int, end: Int) {
    if(end <= start) return // base case

    val pivot = partition(array, start, end)
    quickSort(array, start, pivot - 1)
    quickSort(array, pivot + 1, end)
}

fun partition(array: IntArray, start: Int, end: Int): Int {
    val pivot = array[end]
    var i = start - 1

    for (j in start until end) {
        if (array[j] < pivot) {
            i++
            val temp = array[i]
            array[i] = array[j]
            array[j] = temp
        }
    }
    i++
    val temp = array[i]
    array[i] = array[end]
    array[end] = temp

    return i
}

