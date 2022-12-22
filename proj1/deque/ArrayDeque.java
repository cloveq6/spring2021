package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>{
    private class ArrayDequeIterator implements Iterator<T> {
        private int wizPos;

        public ArrayDequeIterator() {
            wizPos = 0;
        }

        public boolean hasNext() {
            return wizPos < size;
        }

        public T next() {
            T returnItem = items[(wizPos + nextFirst + 1) % items.length];
            wizPos += 1;
            return returnItem;
        }
    }

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }


    public void addFirst(T item){
        if (isFull()){
            resize(items.length * 2);
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size += 1;
    }

    public void addLast(T item){
        if (isFull()){
            resize(items.length * 2);
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size += 1;
    }

    /**
     *nextFirst与nextLast相邻时为空
     */
    public boolean isEmpty(){
        return (nextFirst + 1) % items.length == nextLast;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        int printSize = size();
        int index = nextFirst + 1;
        while (printSize > 0){
            System.out.print(items[index % items.length] + " ");
            printSize -= 1;
            index += 1;
        }
        System.out.println();
    }

    public T removeFirst(){
        if (isEmpty()) return null;
        if ((size + 1 < items.length / 2) && (size > 4)) {
            resize(items.length / 2);
        }
        nextFirst = (nextFirst + 1) % items.length;
        T removeItem = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        return removeItem;
    }

    public T removeLast(){
        if (isEmpty()) return null;
        if ((size + 1 < items.length / 2) && (size > 4)) {
            resize(items.length / 2);
        }
        nextLast = (nextLast - 1 + items.length ) % items.length;
        T removeItem = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        return removeItem;
    }

    public T get(int index){
        if (isEmpty() || (index < 0 || index > size - 1)) return null;
        int curIndex = nextFirst + 1;
        return items[(curIndex + index) % items.length];
    }

    /**
     * to do 不起作用呀
     */
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

//    public boolean equals(Object o){
//        if (! (o instanceof ArrayDeque)) return false;
//        ArrayDeque<T> newObject = (ArrayDeque)o;
//        if (newObject.size() != this.size) return false;
//
//        for (int i=0; i<size(); ++i){
//            if(!this.iterator().next().equals(newObject.iterator().next())) return false;
//        }
//        return true;
//    }
    public boolean equals(Object o){
        if (! (o instanceof Deque)) return false;
        if (((Deque<?>) o).size() != this.size) return false;
        for (int i=0; i<size(); ++i){
            if(!this.iterator().next().equals(((Deque<?>) o).iterator().next())) return false;
        }
        return true;
    }

    /**
     * 判断队列是否满了
     */
    private boolean isFull(){
        return (this.size + 1) == items.length;
    }

    /**
     *重新调整位置
     */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];

        int printSize = size();
        int index = nextFirst + 1;
        int i = 1;
        while (printSize > 0){
            a[i] = items[index % items.length];
            printSize -= 1;
            index += 1;
            i += 1;
        }
        nextFirst = 0;
        nextLast = size() + 1;
        items = a;
    }
}
