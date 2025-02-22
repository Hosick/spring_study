package me.hosick.demospring51.messagesource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageRunner implements ApplicationRunner {
    @Autowired
    MessageSource messageSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("\n### messageSource ###");
        System.out.println("    "+messageSource.getMessage("greeting", new String[]{"hosick"}, Locale.KOREA));
        System.out.println("    "+messageSource.getMessage("greeting", new String[]{"hosick"}, Locale.US));
    }
}
