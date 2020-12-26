package me.hosick.demospring51.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

// 싱글톤 객체 안의 프로토타입의 객체를 매번 다르게 하기 위해서 빈을 프록시로 감싼다.
@Component @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Proto {
}
