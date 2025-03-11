package Nodes

abstract class Node<K: Comparable<K>, V,someNode> (val key: K,var value: V) {
    var leftChild: someNode? = null
    internal var rightChild: someNode? = null
}
