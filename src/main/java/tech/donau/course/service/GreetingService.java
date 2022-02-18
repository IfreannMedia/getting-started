package tech.donau.course.service;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import tech.donau.course.config.Base64Value;
import tech.donau.course.config.GreetingConfig;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@ApplicationScoped
public class GreetingService {


    @Inject
    GreetingConfig greetingConfig;

//    @ConfigProperty(name = "greeting.base64name")
//    Base64Value name;

//    @ConfigProperty(name = "greeting.name")
//    String greeting;
//
//    @ConfigProperty(name = "greeting.suffix", defaultValue = "!")
//    String greetingSuffix;
//
//    @ConfigProperty(name = "greeting.prefix")
//    Optional<String> greetingPrefix;


    public String sayHello() {
//        String alternateConfigAccesssGreeting = ConfigProvider.getConfig().getValue("greeting.name", String.class);
        return greetingConfig.getPrefix().orElse("_")
                + greetingConfig.getName()
                + greetingConfig.getSuffix()
                + " your country name: " + greetingConfig.getCountry().getName()
                + " your country id: " + greetingConfig.getCountry().getId();
    }

    public String sayHello(final String name) {
        return String.format("Hello %s, your id is: " +
                "%s", name, UUID.randomUUID());
    }
}
