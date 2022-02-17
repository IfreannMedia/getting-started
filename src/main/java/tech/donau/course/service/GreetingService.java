package tech.donau.course.service;

import java.util.UUID;

public class GreetingService {


    public String sayHello(final String name) {
        return String.format("Hello %s, your id is: " +
                "%s", name, UUID.randomUUID());
    }
}
