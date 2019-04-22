public class Testabstrct extends abstractclass {
    public static void main(String[] args) {
        Testabstrct test = new Testabstrct();
        test.printabTest();
        test.printTest();
    }

    public void printabTest() {
        System.out.println("abstract Test");
    }

    @Override
    public void printTest() {
        System.out.println("this Test");
    }
}

abstract class abstractclass {
    public void printTest() {
        System.out.println("Test");
    }

    public abstract void printabTest();
}
