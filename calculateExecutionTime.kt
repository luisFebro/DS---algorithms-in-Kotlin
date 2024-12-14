val start = System.nanoTime()

// ... program ...

Thread.sleep(3000)

val duration = (System.nanoTime() - start) / 1000000
println("$duration ms")