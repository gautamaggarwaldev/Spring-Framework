package in.ggklass.simple;

public class B {
    A a;
    public B() {
        System.err.println("B is created");
        this.a = new A();
    }
}
