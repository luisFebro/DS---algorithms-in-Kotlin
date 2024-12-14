/* DEFINITION:
an array/arraylist of linkedlists
Each linkedlist has a unique node at the head
All adjacent neighbors to that node are added to that node's linkedlist
- one-way direction
- e.g street map
*/

/* CHARACTHERISTIC
time complexity: linear time O(V)
space complexity: O(V + E) (uses LESS space - V # of vertices - E # of edges)

 */

class Node(data: Char) {
    val data: Char

    init {
        this.data = data
    }
}

class Graph {
    private val adjacencyList = mutableListOf<MutableList<Node>>()

    init {
        adjacencyList.add(mutableListOf())
    }

    fun addNode(node: Node) {
        val currentList = mutableListOf<Node>()
        currentList.add(node)
        adjacencyList.add(currentList)
    }

    fun addEdge(src: Int, dst: Int) {
        val currentList = adjacencyList[src]
        val dstNode = adjacencyList[dst][0]
        currentList.add(dstNode)
    }

    fun checkEdge(src: Int, dst: Int): Boolean {
        val currentList = adjacencyList[src]
        val dstNode = adjacencyList[dst][0]

        for (node in currentList) {
            if (node == dstNode) {
                return true
            }
        }

        return false
    }

    fun print() {
        for (currentList in adjacencyList) {
            for (node in currentList) {
                print("${node.data} -> ")
            }
            println()
        }
    }
}


val graph = Graph()
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

graph.print()