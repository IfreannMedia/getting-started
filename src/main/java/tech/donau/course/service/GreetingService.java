package tech.donau.course.service;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class GreetingService {


    public String sayHello() {
        return "hello";
    }

    public String sayHello(final String name) {
        return String.format("Hello %s, your id is: " +
                "%s", name, UUID.randomUUID());
    }
}
