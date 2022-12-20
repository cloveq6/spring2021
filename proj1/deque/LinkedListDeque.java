package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>{

    private ItemNode sentinel;
    private int size;

    /**
     * 内部Node节点
     */
    public class ItemNode {
        public ItemNode prev;
        public T item;
        public ItemNode next;

        public ItemNode(T i, ItemNode p, ItemNode n){
           item = i;
           prev = p;
           next = n;
        }
    }

    /**
     * LinkedListDequeIterator的迭代器
     */
    public class LinkedListDequeIterator implements Iterator<T> {
        ItemNode curNode;

        public LinkedListDequeIterator() {
            curNode = sentinel.next;
        }

        public T next() {
            T item = curNode.item;
            curNode = curNode.next;
            return item;
        }

        public boolean hasNext() {
            return curNode != sentinel;
        }

    }

    public LinkedListDeque(){
        size = 0;
        sentinel = new ItemNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }


    public void addFirst(T item){
        ItemNode ItemNode = new ItemNode(item, null, null);
        ItemNode nextNode = sentinel.next;
        // 后面节点
        nextNode.prev = ItemNode;
        ItemNode.next = nextNode;
        //前面节点
        ItemNode.prev = sentinel;
        sentinel.next = ItemNode;
        size += 1;
    }

    public void addLast(T item){
        ItemNode ItemNode = new ItemNode(item, null, null);
        ItemNode lastNode = sentinel.prev;
        //前面节点
        lastNode.next = ItemNode;
        ItemNode.prev = lastNode;
        ItemNode.next = sentinel;
        sentinel.prev = ItemNode;
        size += 1;

    }

    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }

    public void printDeque(){
        ItemNode ItemNode = sentinel.next;
        while (ItemNode != sentinel){
            System.out.print(ItemNode.item + " ");
            ItemNode = ItemNode.next;
        }
        System.out.println();
    }

    public T removeFirst(){
        if (isEmpty()) return null;
        ItemNode removeNode = sentinel.next;
        sentinel.next = removeNode.next;
        removeNode.next.prev = sentinel;
        T item = removeNode.item;
        removeNode = null;
        size -= 1;
        return item;
    }

    public T removeLast(){
        if (isEmpty()) return null;
        ItemNode removeNode = sentinel.prev;
        removeNode.next.prev = removeNode.prev;
        removeNode.prev.next = removeNode.next;
        T item = removeNode.item;
        removeNode = null;
        size -= 1;
        return item;

    }

    public T get(int index){
        ItemNode ItemNode = sentinel.next;
        while (ItemNode != sentinel){
            if (index == 0) return ItemNode.item;
            ItemNode = ItemNode.next;
            index -= 1;
        }
        return null; // 这里应该返回null
    }

    /**
     *使用递归获取元素
     */
    public T getRecursive(int index){
        if (index<0 || index > size()-1) return null;
        return getRecursiveHelper(index, sentinel.next);

    }

    /**
     * 返回迭代器
     */
    public Iterator<T> iterator(){
        return new LinkedListDequeIterator();
    }

    /**
     *判断o是否是双端队列，且相同
     */
    public boolean equals(Object o){
        if (! (o instanceof LinkedListDeque)) return false;
        LinkedListDeque<T> newObject = (LinkedListDeque)o;
        if (newObject.size() != this.size) return false;
        for (int i=0; i<size(); ++i){
            if(this.iterator().next() != newObject.iterator().next()) return false;
        }
        return true;
    }

    /**
     * getRecursive递归辅助函数
     */
    private T getRecursiveHelper(int index, ItemNode ItemNode){
        if (index == 0) return ItemNode.item;
        return getRecursiveHelper(index - 1, ItemNode.next);
    }
}
