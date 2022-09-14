package study.spring.projectBuild.scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import study.spring.projectBuild.Person;

@Component("hello")
public class Hello {
    private Person person;

    @Autowired
    public void setPerson(Person person) {
        this.person = person;
    }

    public void sayHello() {
        System.out.printf("Hello %s\n", (person != null ? person.getName() : "Someone"));
//        System.out.println("Hello Spring");
    }
}
