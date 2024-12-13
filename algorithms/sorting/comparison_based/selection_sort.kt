/* DEFINITION: in-place comparision sorting algorithm that keeps track of the minimum value during each iteration.
At the end of each iteration, we swap variables.

 */

/* CARACTERISTICS
- runtime completixity of quadratic time O(n^2). So the larger the data set, the more inefficient is the execution process.
- okay for small data set
*/

val array = intArrayOf(9, 12,3, 49, 3, 8, 10, 1, 2)

selectionSort(array)

for(i in array) {
    println(i)
}

fun selectionSort(array: IntArray) {
    for(i in 0 until array.size - 1) {
        var min = i

        for(j in i + 1 until array.size) {
            if(array[j] < array[min]) { // if next value is lower than current, then change int
                min = j
            }
        }

        val temp = array[i]
        array[i] = array[min]
        array[min] = temp
    }
}