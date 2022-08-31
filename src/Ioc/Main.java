package Ioc;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        HelloIF hello = new EnglishHello();

        Bower bower = new Bower();
        bower.execute(hello);
    }
}
