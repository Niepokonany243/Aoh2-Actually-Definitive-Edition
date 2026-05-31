/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.StringBuilder;
import java.util.Arrays;

public class BinaryHeap<T extends Node> {
    public int size;
    private Node[] nodes;
    private final boolean isMaxHeap;

    public BinaryHeap() {
        this(16, false);
    }

    public BinaryHeap(int capacity, boolean isMaxHeap) {
        this.isMaxHeap = isMaxHeap;
        this.nodes = new Node[capacity];
    }

    public T add(T node) {
        if (this.size == this.nodes.length) {
            Node[] newNodes = new Node[this.size << 1];
            System.arraycopy(this.nodes, 0, newNodes, 0, this.size);
            this.nodes = newNodes;
        }
        ((Node)node).index = this.size;
        this.nodes[this.size] = node;
        this.up(this.size++);
        return node;
    }

    public T add(T node, float value) {
        ((Node)node).value = value;
        return this.add(node);
    }

    public boolean contains(T node, boolean identity) {
        if (node == null) {
            throw new IllegalArgumentException("node cannot be null.");
        }
        if (identity) {
            for (Node n : this.nodes) {
                if (n != node) continue;
                return true;
            }
        } else {
            for (Node other : this.nodes) {
                if (!other.equals(node)) continue;
                return true;
            }
        }
        return false;
    }

    public T peek() {
        if (this.size == 0) {
            throw new IllegalStateException("The heap is empty.");
        }
        return (T)this.nodes[0];
    }

    public T pop() {
        Node removed = this.nodes[0];
        if (--this.size > 0) {
            this.nodes[0] = this.nodes[this.size];
            this.nodes[this.size] = null;
            this.down(0);
        } else {
            this.nodes[0] = null;
        }
        return (T)removed;
    }

    public T remove(T node) {
        if (--this.size > 0) {
            Node moved = this.nodes[this.size];
            this.nodes[this.size] = null;
            this.nodes[((Node)node).index] = moved;
            if (moved.value < ((Node)node).value ^ this.isMaxHeap) {
                this.up(((Node)node).index);
            } else {
                this.down(((Node)node).index);
            }
        } else {
            this.nodes[0] = null;
        }
        return node;
    }

    public boolean notEmpty() {
        return this.size > 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        Arrays.fill(this.nodes, 0, this.size, null);
        this.size = 0;
    }

    public void setValue(T node, float value) {
        float oldValue = ((Node)node).value;
        ((Node)node).value = value;
        if (value < oldValue ^ this.isMaxHeap) {
            this.up(((Node)node).index);
        } else {
            this.down(((Node)node).index);
        }
    }

    private void up(int index) {
        Node[] nodes = this.nodes;
        Node node = nodes[index];
        float value = node.value;
        while (index > 0) {
            int parentIndex = index - 1 >> 1;
            Node parent = nodes[parentIndex];
            if (!(value < parent.value ^ this.isMaxHeap)) break;
            nodes[index] = parent;
            parent.index = index;
            index = parentIndex;
        }
        nodes[index] = node;
        node.index = index;
    }

    private void down(int index) {
        int leftIndex;
        Node[] nodes = this.nodes;
        int size = this.size;
        Node node = nodes[index];
        float value = node.value;
        while ((leftIndex = 1 + (index << 1)) < size) {
            float rightValue;
            Node rightNode;
            int rightIndex = leftIndex + 1;
            Node leftNode = nodes[leftIndex];
            float leftValue = leftNode.value;
            if (rightIndex >= size) {
                rightNode = null;
                rightValue = this.isMaxHeap ? -3.4028235E38f : Float.MAX_VALUE;
            } else {
                rightNode = nodes[rightIndex];
                rightValue = rightNode.value;
            }
            if (leftValue < rightValue ^ this.isMaxHeap) {
                if (leftValue == value || leftValue > value ^ this.isMaxHeap) break;
                nodes[index] = leftNode;
                leftNode.index = index;
                index = leftIndex;
                continue;
            }
            if (rightValue == value || rightValue > value ^ this.isMaxHeap) break;
            nodes[index] = rightNode;
            if (rightNode != null) {
                rightNode.index = index;
            }
            index = rightIndex;
        }
        nodes[index] = node;
        node.index = index;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BinaryHeap)) {
            return false;
        }
        BinaryHeap other = (BinaryHeap)obj;
        if (other.size != this.size) {
            return false;
        }
        Node[] nodes1 = this.nodes;
        Node[] nodes2 = other.nodes;
        int n = this.size;
        for (int i = 0; i < n; ++i) {
            if (nodes1[i].value == nodes2[i].value) continue;
            return false;
        }
        return true;
    }

    public int hashCode() {
        int h = 1;
        Node[] nodes = this.nodes;
        int n = this.size;
        for (int i = 0; i < n; ++i) {
            h = h * 31 + Float.floatToIntBits(nodes[i].value);
        }
        return h;
    }

    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        Node[] nodes = this.nodes;
        StringBuilder buffer = new StringBuilder(32);
        buffer.append('[');
        buffer.append(nodes[0].value);
        for (int i = 1; i < this.size; ++i) {
            buffer.append(", ");
            buffer.append(nodes[i].value);
        }
        buffer.append(']');
        return buffer.toString();
    }

    public static class Node {
        float value;
        int index;

        public Node(float value) {
            this.value = value;
        }

        public float getValue() {
            return this.value;
        }

        public String toString() {
            return Float.toString(this.value);
        }
    }
}

