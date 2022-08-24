package Java0824;

import java.util.HashMap;
import java.util.Map;

public class CounterDoer implements Doer{
    private Map<String, Integer> map;

    public CounterDoer(){
        this.map = new HashMap<>();
    }

    @Override
    public void doJob(String name) {
        Integer count = map.get(name);
        if(count == null) {
            count = 0;
        }

        count++;
        map.put(name, count);

        System.out.printf("%s님의 %d번째 방문입니다.\n", name, count);
    }
}
