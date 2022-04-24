package mk.ukim.finki.emt.homework2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Homework2Application {

    public static void main(String[] args) {
        SpringApplication.run(Homework2Application.class, args);
    }

}
