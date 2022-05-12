package iducs.springboot.boot.controller;

import iducs.springboot.boot.domain.Member;
import iducs.springboot.boot.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("")
    public String getHome() {
        return "index";
    }
}
