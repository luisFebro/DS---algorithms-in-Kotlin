/* DEFINITION:
after comparing elements to the left, shift elements tot he right ot make room to insert a value
like jigsaw that we move the whole sections of pieces to fit room for a piece that fits
 */

/* CARACTERISTICS
- less steps than bubble sort
- best case is O(n) - linear time which is better than selection sort with runtime complexity of quadratic time O(n^2)
*/

val array = intArrayOf(9, 1, 8, 2, 7, 3, 6, 5, 4)

insertionSort(array)

for(i in array) {
    println( "$i ")
}

fun insertionSort(array: IntArray) {
    for(i in 1 until array.size) {
        val temp = array[i]
        var j = i - 1 // keep tracks to which value to left we were compared with

        // if declared like: val needShiftToRight = j >= 0 && array[j] > temp -> The corrected while loop condition ensures that the loop continues only as long as j is non-negative and the element at index j is greater than temp. This prevents the ArrayIndexOutOfBoundsException by avoiding the access to an invalid index.
        while(j >= 0 && array[j] > temp) {
            array[j + 1] = array[j]
            j--
        }

        array[j + 1] = temp
    }
}