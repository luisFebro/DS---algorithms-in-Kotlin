/* DEFINITION:
recursively devide array in 2, sort, re-combine
dividing-and-conquer algo
 */

/* CARACTERISTICS
use more space with a space complexity of linear space O(n) and time complexity of O(n log n) - quasi-linear time
*/

val array = intArrayOf(8, 2, 5, 3, 4, 7, 6, 1)

mergeSort(array)

for(i in array) {
    println("i = $i")
}

fun mergeSort(array: IntArray) {
    val size = array.size
    if(size <= 1) return // if the size is one, no need divide array further

    val middle = size / 2

    val leftArray = IntArray(middle)
    val rightArray = IntArray(size - middle)

    var j = 0

    for(i in 0 until size) {
        if(i < middle) {
            leftArray[i] = array[i]
        } else {
            rightArray[j] = array[i]
            j++
        }
    }

    mergeSort(leftArray)
    mergeSort(rightArray)
    merge(leftArray, rightArray, array)
}

fun merge(leftArray: IntArray, rightArray: IntArray, array: IntArray) {
    val leftSize = array.size / 2
    val rightSize = array.size - leftSize
    var i = 0
    var l = 0
    var r = 0 // indices

    // check the conditions for merging
    while(l < leftSize && r < rightSize) {
        if(leftArray[l] < rightArray[r]) { // comparing number from teh left to right and add whatever number which is smaller
            array[i] = leftArray[l]
            i++
            l++
        } else {
            array[i] = rightArray[r]
            i++
            r++
        }
    }

    while(l < leftSize) {
        array[i] = leftArray[l]
        i++
        l++
    }

    while(r < rightSize) {
        array[i] = rightArray[r]
        i++
        r++
    }
}