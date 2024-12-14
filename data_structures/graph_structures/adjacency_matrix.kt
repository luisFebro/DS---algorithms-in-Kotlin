/* DEFINITION:
Undirected Graph represents adjacency matrix
adjacency matrix - an 2D/array to store 1's/0's to represent edges
# of rows = # of unique nodes
# of columns = # of unique nodes

- social network
- two nodes connected: edge (adjancency)
 */

/* CHARACTERISTS
time complexity: constant time O(1)
space complexity: quadratic O(V^2) (uses more space)
 */

class Node(data: Char) {
    val data: Char

    init {
        this.data = data
    }
}

class Graph(private val size: Int) {
    private var matrix = Array(size) { IntArray(size) }
    private val nodes = mutableListOf<Node>()


    fun addNode(node: Node) {
        nodes.add(node)
    }

    fun addEdge(src: Int, dst: Int) {
        matrix[src][dst] = 1
    }

    fun checkEdge(src: Int, dst: Int): Boolean {
        return matrix[src][dst] == 1
    }

    fun print() {
        println("  ")
        for(node in nodes) {
            println("${node.data} ")
        }
        println()

        for (i in matrix.indices) {
            println("${nodes[i].data} ")
            for (j in 0 until matrix[i].size) {
                print("${matrix[i][j]} ")
            }
            println()
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
graph.addEdge(4, 2)

// println(graph.checkEdge(0, 0))
graph.print()