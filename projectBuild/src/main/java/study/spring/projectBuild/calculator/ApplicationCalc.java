package study.spring.projectBuild.calculator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.spring.projectBuild.Configuration1;

public class ApplicationCalc {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationCalc.class);

        Machine machine = context.getBean("machine", Machine.class);
        machine.execute();


    }
}
