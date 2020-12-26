package me.hosick.demospring51.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ScopeRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext ctx;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("\n### scope ###");

        System.out.println("    proto (객체 마다 다름)");
        System.out.println("        " + ctx.getBean(Proto.class));
        System.out.println("        " + ctx.getBean(Proto.class));
        System.out.println("        " + ctx.getBean(Proto.class));

        System.out.println("    single (모두 같은 객체)");
        System.out.println("        " + ctx.getBean(Single.class));
        System.out.println("        " + ctx.getBean(Single.class));
        System.out.println("        " + ctx.getBean(Single.class));

        System.out.println("    proto by single(프록시를 이용해서 proto하게 사용할 수 있음)");
        System.out.println("        " + ctx.getBean(Single.class).getProto());
        System.out.println("        " + ctx.getBean(Single.class).getProto());
        System.out.println("        " + ctx.getBean(Single.class).getProto());
    }
}
