package Nodes

abstract class Node<K: Comparable<K>, V> (val key: K, var value: V) {
    internal var leftChild: Node<K, V>? = null
    internal var rightChild: Node<K, V>? = null
}
