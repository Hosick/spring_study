package me.hosick.demospring51.environment.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ProperyRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext ctx;

    @Value("${app.name}")
    String appName;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("\n### property ###");

        Environment environment = ctx.getEnvironment();
        System.out.println("    abb.name = " + environment.getProperty("app.name"));
        System.out.println("    abb.name = " + appName);
    }
}
