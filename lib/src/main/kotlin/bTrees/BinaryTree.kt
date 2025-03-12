package bTrees

import bNodes.Node

abstract class Tree<K : Comparable<K>, V, someNode : Node<K, V, someNode>>: Iterable<someNode> {
    internal var size: Int = 0
    protected lateinit var root: someNode

    abstract fun insert(key: K, newValue: V)

    abstract fun remove(key: K)

    abstract fun find(key: K): V?

    override fun iterator(): Iterator<someNode> {
        return object : Iterator<someNode> {
            var isRootWas = false
            override fun hasNext(): Boolean {
                if(!isRootWas){
                    queue.add(root)
                    isRootWas=true
                }
                val node=queue.firstOrNull() ?: return false
                if (node.leftChild !=null){
                    queue.add((node.leftChild?:root))
                }
                if (node.rightChild !=null){
                    queue.add((node.rightChild?:root))
                }
                return queue.isNotEmpty()
            }
            val queue: ArrayDeque<someNode> = ArrayDeque()

            override fun next(): someNode {
                return queue.removeFirst()
            }
        }
    }
}
