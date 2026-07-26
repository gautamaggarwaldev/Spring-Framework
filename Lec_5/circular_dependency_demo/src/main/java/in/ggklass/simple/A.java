package in.ggklass.simple;

public class A {

    B b;

    public A() {
        System.err.println("A is created");
        this.b = new B();
    }
}