package tech.donau.course;

import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.logging.Logger;

@ApplicationScoped
public class AppLifecycleListener {

    private static Logger logger = Logger.getLogger("AppLifecycleListener");

    public void onStart(@Observes StartupEvent startup) {
        logger.info("WE STARTED");
    }
}
