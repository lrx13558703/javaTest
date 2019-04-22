public class ArrayListTest<E> {
    Object[] arrylist;

    int size;

    private final int ARRYLENGHT = 10;

    public ArrayListTest() {
        arrylist = new Object[ARRYLENGHT];
    }

    public void add(E e) {
        if (size == arrylist.length) {
            Object[] newArray = new Object[arrylist.length + (arrylist.length << 1)];
            System.arraycopy(arrylist, 0, newArray, 0, arrylist.length);
            arrylist = newArray;
        }
        arrylist[size] = e;
        size++;
    }

    public E get(int index) {
        return (E) arrylist[index];
    }

    public void remove(int index) {
        System.arraycopy(arrylist, index + 1, arrylist, index, arrylist.length - index - 1);
        size--;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        //[a,b,c]
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(arrylist[i] + ",");
        }
        sb.setCharAt(sb.length() - 1, ']');

        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayListTest<String> test = new ArrayListTest<String>();
        for (int i = 1; i < 16; i++) {
            test.add(i + "888");
        }

        System.out.println(test.toString());
        System.out.println(test.get(10));
        test.remove(8);
        System.out.println(test);
    }
}
