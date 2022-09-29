package house;

// 11_4 MyVector.java
// Vector 클래스의 실제 코드

import java.util.*;

public class MyVector implements List{
    Objects[] data = null;  // 객체를 담기 위한 객체 배열을 선언한다.
    int capacity = 0;       // 용량
    int size = 0;           // 크기

    // 1) 생성자 1
    public MyVector(int capacity) {
        if(capacity<0)
            throw new IllegalArgumentException("유효하지 않은 값입니다. :" + capacity);

        this.capacity = capacity;
        data = new Objects[capacity];
    }

    // 2) 생성자 2
    public MyVector() {
        this(10);   // 크기를 지정하지 않았을 경우를 대비, 10으로 default설정.
    }

    // 3) 최소한의 저장공간(capacity)를 확보하는 메서드
    public void ensureCapacity(int minCapacity) {
        if(minCapacity - data.length > 0)
            setCapacity(minCapacity);
    }

    // 4) 새로운 객체를 저장하는 add 메서드
    public boolean add(Object obj) {
        //새로운 객체를 저장하기 전에 저장 공간 확보
        ensureCapacity(size+1);
        data[size++] = (Objects) obj;
        return true;
    }

    // 5) 원하는 데이터를 얻는 get 메서드
    public Object get(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
        return data[index];
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    // 6) 해당인덱스의 데이터를 제거하는 remove메서드
    public Objects remove(int index) {
        Objects oldObj = null;

        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
        oldObj = data[index];

        // 삭제하고자 하는 객체가 마지막 객체가 아니라면 배열복사를 통해 빈자리를 채워줘야함.
        if(index!=size-1) {
            System.arraycopy(data, index+1, data, index, size-index-1);
        }

        // 마지막 데이터를 null로 한다.
        // 배열은 0부터 시작하므로 마지막 요소는 index가 size-1이다.
        data[size-1] = null;
        size--;
        return oldObj;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    // 7) 해당 오브젝트를 삭제하는데 성공했는지 알려주는 메서드
    public boolean remove(Object obj) {
        for(int i=0;i<size;i++) {
            if(obj.equals(data[i])){
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    // 8) 여분의 공백을 제거하는 메서드.
    public void trimToSize() {
        setCapacity(size);
    }

    // 9) 해당 사이즈로 공백을 설정하는 메서드
    private void setCapacity(int capacity) {
        // 크기가 같으면 변경 안함.
        if(this.capacity==capacity) return;

        Objects[] tmp = new Objects[capacity];
        System.arraycopy(data,0,tmp,0,size);
        data = tmp;
        this.capacity = capacity;
    }

    // 10) 모든 데이터들을 삭제하는 메서드
    public void clear() {
        for(int i=0;i<size;i++) {
            data[i] = null;
        }
        size = 0;
    }

    // 11) toArray()메서드... 배열 생성하는 함수인가..?
    public  Object[] toArray() {
        Objects[] result = new Objects[size];
        System.arraycopy(data, 0, result, 0, size);

        return result;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    // 12) 비어있는지 확인하는 메서드
    public boolean isEmpty() { return size == 0;}

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    public int capacity() { return capacity; }
    public int size() { return size; }

    // 그 외에 여러 메서드들...p592
}
