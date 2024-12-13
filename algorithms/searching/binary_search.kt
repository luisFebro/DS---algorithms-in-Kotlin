// DEFINITION: search algorithm that finds the position of a target value within a sorted array. Half of the array is eliminated during each "step"
/* CARACTERISTICS
 - fantastic for searching in a large data with a runtime complexity of O (log n) which is the second most optimal performance behind constant time O (1).
 - not much efficient working with small data set
 */


val array = IntArray(10) { it } // Initialize array with values 0 to 99
val target = 5

//val index = array.binarySearch(target) // build-in
val index = binarySearch(array, target)

if (index < 0) {
    println("Target $target not found")
} else {
    println("Target found at index: $index")
}

fun binarySearch(array: IntArray, target: Int): Int {
    var lowInd = 0
    var highInd = array.size - 1

    while(lowInd <= highInd) { // while loop ensures that there's still a portion of the array to search.
        val middle = lowInd + (highInd - lowInd) / 2
        val middleValue = array[middle]

        println("middle running: $middleValue")
        // considering all data is sorted
        if(target > middleValue) lowInd = middle + 1 //  If the target is greater than the middleValue, it means the target must be in the right half of the current search range. So, we update lowInd to be one position to the right of the middle.
        else if(target < middleValue) highInd = middle - 1 // If the target is less than the middleValue, it means the target must be in the left half of the current search range. So, we update highInd to be one position to the left of the middle.
        else return middle // target is found
    }

    return -1;
}