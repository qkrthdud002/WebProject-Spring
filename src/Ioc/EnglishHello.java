package Ioc;

public class EnglishHello implements HelloIF {

    protected String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sayHello() {
        System.out.printf("Hello %s\n", this.name);
    }
}
