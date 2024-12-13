/*
DEFINITION:
apply the result of a procedure, to a procedure. A recursive method calls itself.
can be a substitute for iteration.
divide a problem into sub-problems of the same type as the original.
commonly used with advanced sorting algorithms and navigating trees.

 */
/* CARACTERISTICS
- easier to read/write
- easier to debug

- sometimes slower and use more memory
 */

// SIMPLE EXAMPLE
walk(5)


fun walk(steps: Int) {
    if(steps < 1) return // base case
    println(steps)
    walk(steps - 1)
}

// FACTORIAL
val result = factorial(4)
println(result) // 24

fun factorial(num: Int): Int {
    if(num < 1) return 1 // base case
    return num * factorial(num - 1) // recursive
}

// POWER
val result = power(2, 4)
println(result)


fun power(base: Int, exponent: Int): Int {
    if(exponent < 1) return 1 // base case -  Any number raised to the power of 0 is 1.
    return base * power(base, exponent - 1) // recursive case
}