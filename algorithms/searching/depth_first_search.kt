/*  DEFINITION:
a search algorithm for traversin a tree or graph data structure
3 steps:
1. pick a route
2. keep going until you reach a dead end, or a previously visited node
3. backtrack (retroceder) to last node that has unvisited adjacent neighbors

 */


/* CARACTERISTICS
- traverse a graph branch by branch
- Utilizes a Stack
- Better if destination is on average far from the start
- Children are visited before siblings
- More popular for games/puzzles
 */


import java.util.*

class Node(data: Char) {
    val data: Char

    init {
        this.data = data
    }
}

class Graph(private val size: Int) {
    private val nodes = mutableListOf<Node>()
    private var matrix = Array(size) { IntArray(size) }

    fun addNode(node: Node) {}
    fun addEdge(src: Int, dst: Int) {}
    fun checkEdge(src: Int, dst: Int) {}
    fun print() {}


    fun breathFirstSearch(src: Int) {
        val queue: Queue<Int> = LinkedList<>()
        val visited = BooleanArray(matrix.size)

        queue.offer(src)
        visited[src] = true

        while (queue.isNotEmpty()) {
            src = queue.poll() // ????
            println("${nodes[src].data} = visited")

            for (i in matrix[src].indices) {
                if (matrix[src][i] == 1 && !visited[i]) {
                    queue.offer(i)
                    visited[i] = true
                }
            }
        }
    }
}

val graph = Graph(5)
graph.addNode(Node('A'))
graph.addNode(Node('B'))
graph.addNode(Node('C'))
graph.addNode(Node('D'))
graph.addNode(Node('E'))

graph.addEdge(0, 1)
graph.addEdge(1, 2)
graph.addEdge(2, 3)
graph.addEdge(2, 4)
graph.addEdge(4, 0)
graph.addEdge(4, 2)

// println(graph.checkEdge(0, 0))
//graph.print()

graph.breathFirstSearch(0)
