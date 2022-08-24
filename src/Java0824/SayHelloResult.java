package Java0824;

import java.util.Scanner;

//class Name{
//    public String name;
//}
//
//class SayHello extends Name{
//    Scanner sc = new Scanner(System.in);
//        void sayHello(){
//        while(true){
//            System.out.print("이름을 입력하세요 : ");
//            name = sc.nextLine();
//
//            if(name.equals("quit")) {
//                System.out.println("프로그램을 종료합니다.");
//                break;
//            }
//            else
//                System.out.println("안녕하세요. " + name + "님");
//        }
//    }
//}
//
//public class SayHelloResult {
//    public static void main(String[] args) {
//        SayHello sh = new SayHello();
//        sh.sayHello();
//    }
//}

public class SayHelloResult {
    protected Scanner sc;

    public SayHelloResult(){
        sc = new Scanner(System.in);
    }

    public void execute() {
        while(true) {
            // 이름을 입력받는다.
            String name = inputName();

            //'quit'가 입력되면 종료된다.
            if(name.equals("quit")){
                break;
            }
            doJob(name);
        }
        sc.close();
    }
    protected void doJob(String name){
        System.out.printf("안녕하세요. %s님", name);
    }
    protected String inputName() {
        System.out.print("이름을 입력하세요 : ");
        String name = sc.nextLine();
        return name;
    }

    public static void main(String[] args) {
        System.out.print("이름을 입력하세요 : ");
        SayHelloResult sayHelloResult = new SayHelloResult();
        sayHelloResult.execute();
    }
}



