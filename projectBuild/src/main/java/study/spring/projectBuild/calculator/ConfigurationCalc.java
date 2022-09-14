package study.spring.projectBuild.calculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationCalc {

    @Bean
    public Machine machine() {
        Machine machine = new Machine();
        machine.setCalculator();

        return machine;
    }

    @Bean
    public Calculator calculator() {
        return new Adder();
    }
}
