/* DEFINITION:
Improvement over binary search. Best used for uniformly distributed "guesses" where a value might be based on calculated probe results.
If the probe is incorrect, search area is narrowed, and a new probe is calculated
 */

/* CARACTERISTICS
- data is sorted
 - worst case: O(n) [values increase exponentially]
 - best used for uniformly sequence of numbers like: 1, 2, 3 or 1, 2, 4, 8, 16.
*/

val array = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
val target = 1

val index = interpolationSearch(array, target)

if (index != -1) {
    println("Element found at index: $index")
} else {
    println("Element not found")
}

fun interpolationSearch(array: IntArray, target: Int): Int {
    var low = 0
    var high = array.size - 1
    val lowerBound = array[low]
    val upperBound = array[high]

    // after every iteration, our search will shrink
    val isTargetInBound = target in lowerBound..upperBound // val isTargetInBound = target >= lowerBound && target <= upperBound
    while (isTargetInBound && low <= high) {
        val probe = low + (high - low) * (target - lowerBound) / (upperBound - lowerBound)

        println("probe guess: $probe")
        if(array[probe] == target) {
            return probe
        } else if(target > array[probe]) {
            low = probe + 1;
        } else {
            high = probe - 1;
        }
    }

    return -1
}

//        if (low == high) {
//            if (array[low] == target) {
//                return low
//            }
//            return -1
//        }
//
//        val pos = low + (((high - low) / (array[high] - array[low])) * (target - array[low]))
//        if (array[pos] == target) {
//            return pos
//        } else if (array[pos] < target) {
//            low = pos + 1
//        } else {
//            high = pos - 1
//        }