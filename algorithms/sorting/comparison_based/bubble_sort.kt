/* DEFINITION:
a sorting algotithm that compares adjacent elements and checks if they are in order. If not, switched. This pattern will continue until the end of the collection of data and all numbers be in a ascending order.

 */

/* CARACTERISTICS
- runtime completixity of quadratic time O(n^2). So the larger the data set, the more inefficient is the execution process.
- with small data set, not horrible, but better options are available
*/

val array = intArrayOf(9, 12,3, 49, 3, 8, 10, 1)

bubbleSort(array)

for(i in array) {
    println(i)
}

fun bubbleSort(array: IntArray) {
    for(i in 0 until array.size - 1) {
        for(j in 0 until array.size - i - 1) {
            // if current value is greater than next one, need to switch
            // to reverse order, switch > to <
            if(array[j] > array[j + 1]) {
                val temp = array[j]

                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
    }
}

