package Java0824;

public class SayHelloDoer implements Doer {

    @Override
    public void doJob(String name) {
        System.out.printf("안녕하세요. %s님\n", name);
    }

    public static void main(String[] args) {
        MainJob job = new MainJob();
        Doer doer = new SayHelloDoer();
        job.execute(doer);
    }
}
