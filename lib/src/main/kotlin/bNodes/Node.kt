package bNodes

abstract class Node<K: Comparable<K>, V, someNode: Node<K, V, someNode>> (val key: K, var value: V) {
    internal var leftChild: someNode? = null
    internal var rightChild: someNode? = null
}
