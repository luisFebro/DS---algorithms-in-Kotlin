/* DEFINITION:
a data structure taht stores unique keys to values. ex. <Integer, String>
- key, value collection
- a.k.a hash map - mutableHashOf
- hashing - takes a key and computes an integer (formula will vary based on key & data type). In a Hashtable, we use the hash % capacity to calculate an index number
- hashCode() % capacity = index
- if there is a collision, then position becomes a linkedlist (chaining). less collisions = more efficiency
- bucket - an indexed storage location for one or more Entries
 */

/* CHARACTERISTS
FAST insertion, look up, deletion of key/value pairs
Not ideal for small data sets (since there is overhead), great with LARGE DATA SETS

Runtime complexity:
Best case: constant time O(1)
Worst case: linear time O(n)
 */



//val table: Hashtable<Int, String> = Hashtable(10) // didn't work
val table = mutableMapOf<Int, String>()

table[100] = "Spongebob"
table[123] = "Patrcik"
table[555] = "Squidward"
table[777] = "Gary"

// table.remove(777)

for ((key, value) in table) {
    println("${key.hashCode() % 10}\t$key\t$value")
/*
100	100	Spongebob
123	123	Patrcik
555	555	Squidward
777	777	Gary

actual indices in the hashtable (key.hashCode() % 10%):
/*
0	100	Spongebob
3	123	Patrcik
5	555	Squidward
7	777	Gary
 */
}