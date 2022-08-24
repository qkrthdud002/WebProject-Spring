package Java0824;

import org.w3c.dom.css.Counter;

import java.util.HashMap;
import java.util.Map;

public class ResultCounter extends SayHelloResult {

    protected Map<String, Integer> map;

    public ResultCounter(){
        super();
        this.map = new HashMap<>();
    }

    @Override
    protected void doJob(String name){
        Integer count = map.get(name);
        if(count == null){
            count = 0;
        }

        count++;
        map.put(name, count);

        System.out.printf("%S님의 %d번째 방문입니다.", name, count);
    }

    public static void main(String[] args) {
        ResultCounter counter = new ResultCounter();
        counter.execute();

    }
}
