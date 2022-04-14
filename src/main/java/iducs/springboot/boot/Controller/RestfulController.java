package iducs.springboot.boot.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulController {
    @GetMapping("/restful")
    public String getRestful() {
        return "{'attributeName': 'attributeValue'}";
    }
}
