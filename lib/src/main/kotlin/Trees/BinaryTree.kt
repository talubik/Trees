package binaryTree

import Nodes.Node

abstract class Tree<K : Comparable<K>, V, someNode: Node<K, V>>: Iterable<Node<K, V>> {
    internal var size: Int = 0
    internal lateinit var root: someNode

    open fun insert(newKey: K, value: V) {}

    open fun remove(newKey: K) {}

    open fun find() {}

    open fun initTree(fKey: K, fValue: V) {}

    override fun iterator(): Iterator<Node<K, V>> {
        return object : Iterator<Node<K, V>> {
            var isrinq = false
            override fun hasNext(): Boolean {
                if(!isrinq){
                    queue.add(root)
                    isrinq=true
                }
                val node=queue.firstOrNull() ?: return false
                if (node.leftChild !=null){
                    queue.add(node.leftChild?:root)
                }
                if (node.rightChild !=null){
                    queue.add(node.rightChild?:root)
                }
                return queue.isNotEmpty()
            }
            val queue: ArrayDeque<Node<K, V>> = ArrayDeque()

            override fun next(): Node<K, V> {
                return queue.removeFirst()
            }
        }
    }
}
