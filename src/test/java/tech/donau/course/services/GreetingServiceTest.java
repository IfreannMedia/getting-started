package tech.donau.course.services;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.donau.course.service.GreetingService;

import javax.inject.Inject;

@QuarkusTest
class GreetingServiceTest {

    @Inject
    GreetingService greetingService;

    @Test
    void checkSaysHello() {
        Assertions.assertEquals(greetingService.sayHello(), "_hello test! your country name: Testland your country id: 23");
    }
}
