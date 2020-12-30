package me.hoscick.demowebmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
// @RequestMapping(method = RequestMethod.GET) // 메소드들에 일괄 적용
/*@RequestMapping("/hello")*/
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SampleController {

    /*@GetMapping(value = "/hello"*//*, params = "name=hosick" headers = HttpHeaders.FROM + "=" + "111" consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.TEXT_PLAIN_VALUE*//*)*/
    @GetHelloMapping
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @GetMapping("/events")
    @ResponseBody
    public String getEvents() {
        return "events";
    }

    @GetMapping("/events/{id}")
    @ResponseBody
    public String getAnEvents(@PathVariable int id) {
        return "event";
    }

    @DeleteMapping("events/{id}")
    @ResponseBody
    public String removeAnEvent(@PathVariable int id) {
        return "events";
    }
}