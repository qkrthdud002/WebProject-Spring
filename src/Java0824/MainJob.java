package Java0824;

import java.util.Scanner;

public class MainJob {
    protected Scanner sc;

    public MainJob() {
        this.sc = new Scanner(System.in);
    }
    public void execute(Doer doer){
        while(true) {
            // 이름을 입력받는다.
            String name = inputName();

            // quit라면 종료한다.
            if("quit".equals(name)){
                break;
            }

            // 개별적인 일을 수행한다.
            doer.doJob(name);
        }

        sc.close();
    }

    protected String inputName(){
        System.out.println("이름을 입력하세요 : ");
        return sc.nextLine();
    }
}
