/*  DEFINITION:
a search algorithm for traversin a tree or graph data structure
this is done one "level" at a time with queue
rather than one branch at a time like DFS

 */

/* CARACTERISTICS
- traverse a graph level by level
- Utilizes a Queue
- Better if destination is on average close to start
- Siblings are visited before children
 */

class Node(data: Char) {
    val data: Char

    init {
        this.data = data
    }
}

class Graph(private val size: Int) {
    private val nodes = mutableListOf<Node>()
    private var matrix = Array(size) { IntArray(size) }


    fun addNode(node: Node) {
//        nodes.add(node)
    }

    fun addEdge(src: Int, dst: Int) {
//        matrix[src][dst] = 1
    }

    fun checkEdge(src: Int, dst: Int): Boolean {
        return matrix[src][dst] == 1
    }

    fun print() {
//        print("  ")
//
//        for (node in nodes) {
//            print("${node.data} ")
//        }
//
//        println()
//
//        for (i in matrix.indices) {
//            print("${nodes[i].data} ")
//            for (j in 0 until matrix[i].size) {
//                print("${matrix[i][j]} ")
//            }
//            println()
//        }
    }


    fun depthFirstSearch(src: Int) {
        val visited = Array(matrix.size) { false }

        dFSHelper(src, visited)
    }

    private fun dFSHelper(src: Int, visited: Array<Boolean>) {
        if (visited[src]) {
            return
        }

        visited[src] = true
        println(nodes[src].data + " = visited")

        for(i in 0 until matrix[src].size) {
            if(matrix[src][i] == 1) { // src = row, i is the column
                dFSHelper(i, visited)
            }
        }
        return
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

graph.depthFirstSearch(0) // current this exception occur: Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0