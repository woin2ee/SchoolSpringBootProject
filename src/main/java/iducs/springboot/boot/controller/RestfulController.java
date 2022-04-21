package iducs.springboot.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulController {
    @GetMapping("/restful")
    public String getRestful() {
        return "{'attributeName': 'attributeValue'}";
    }
}
