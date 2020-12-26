package me.hosick.demospring51.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class ResourceRunner implements ApplicationRunner {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("\n### resouce ###");

        System.out.println("    " + resourceLoader.getClass());

        Resource resource = resourceLoader.getResource("classpath:test.txt");
        System.out.println("    " + resource.getClass());

        System.out.println("    " + resource.exists());
        System.out.println("    " + resource.getDescription());
        System.out.println("    " + Files.readString(Path.of(resource.getURI())));
    }
}
