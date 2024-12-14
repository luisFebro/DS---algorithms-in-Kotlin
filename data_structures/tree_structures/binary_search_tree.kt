/*  DEFINITION:
organized

 */

/* CARACTERISTICS
- a tree WITH no more than two children
- The main difference between a binary tree and a binary search tree (BST) is that a BST enforces a strict ordering on its nodes, while a binary tree does not. Left nodes are lesser than the parent. Right nodes are higher than parent
 */

class Node(private val value: Int) {
    var data: Int = value
    var left: Node? = null
    var right: Node? = null
}

class BinarySearchTree {
    var root: Node? = null

    fun insert(data: Int) {
        root = insertHelper(root, data)
    }

    private fun insertHelper(root: Node?, data: Int): Node? {
        if (root == null) {
            return Node(data)
        }

        if (data < root.data) {
            root.left = insertHelper(root.left, data)
        } else if (data > root.data) {
            root.right = insertHelper(root.right, data)
        }

        return root
    }

    fun display() {
        displayHelper(root)
    }

    private fun displayHelper(root: Node?) {
        if (root == null) {
            return
        }

        displayHelper(root.left)
        print("${root.data} ")
        displayHelper(root.right)
    }

    fun search(data: Int): Boolean {
        return searchHelper(root, data)
    }

    private fun searchHelper(root: Node?, data: Int): Boolean {
        if (root == null) {
            return false
        }

        if (root.data == data) {
            return true
        } else if (data < root.data) {
            return searchHelper(root.left, data)
        } else {
            return searchHelper(root.right, data)
        }
    }

    fun remove(data: Int) {
        root = removeHelper(root, data)
    }

    private fun removeHelper(root: Node?, data: Int): Node? {
        if (root == null) {
            return root
        }

        if (data < root.data) {
            root.left = removeHelper(root.left, data)
        } else if (data > root.data) {
            root.right = removeHelper(root.right, data)
        } else {
            // Node with one or no child
            if (root.left == null) {
                return root.right
            } else if (root.right == null) {
                return root.left
            }

            // Node with two children: Get the inorder successor (smallest
            // in the right subtree)
            val temp = minValue(root.right)
            root.data = temp!!.data
            root.right = removeHelper(root.right, temp.data)
        }

        return root
    }

    private fun minValue(root: Node?): Node? {
        var minv = root
        while (minv!!.left != null) {
            minv = minv.left
        }
        return minv
    }

    fun successor(data: Int): Int {
        val node = searchNode(root, data)
        return if (node == null) {
            -1
        } else {
            successorHelper(node)
        }
    }

    private fun successorHelper(node: Node): Int {
        var current = node
        while (current.left != null) {
            current = current.left
        }
        return current.data
    }

    fun predecessor(data: Int): Int {
        val node = searchNode(root, data)
        return if (node == null) {
            -1
        } else {
            predecessorHelper(node)
        }
    }

    private fun predecessorHelper(node: Node): Int {
        var current = node
        while (current.right != null) {
            current = current.right
        }
        return current.data
    }

    private fun searchNode(root: Node?, data: Int): Node? {
        if (root == null) {
            return null
        }

        if (root.data == data) {
            return root
        } else if (data < root.data) {
            return searchNode(root.left, data)
        } else {
            return searchNode(root.right, data)
        }
    }
}