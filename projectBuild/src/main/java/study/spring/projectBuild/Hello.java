package study.spring.projectBuild;

public class Hello {
    private Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    public void sayHello() {
        System.out.printf("Hello %s\n", (person != null ? person.getName() : "Someone"));
        System.out.println("Hello Spring");
    }
}
