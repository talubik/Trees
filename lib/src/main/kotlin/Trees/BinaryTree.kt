package binaryTrees

interface Tree<K : Comparable<K>, V> {
    open fun insert(newKey: K, value: V) {}
    open fun remove(newKey: K) {}
}