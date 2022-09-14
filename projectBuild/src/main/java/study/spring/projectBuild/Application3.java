package study.spring.projectBuild;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.spring.projectBuild.scan.Hello;

public class Application3 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Configuration3.class);

        Hello hello = context.getBean("hello", Hello.class);
        hello.sayHello();
    }
}
