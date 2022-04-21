package iducs.springboot.boot.controller;

import iducs.springboot.boot.entity.MemberEntity;
import iducs.springboot.boot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/members")
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/th")
    public String getThymeleaf() {
        return "thymeleaf";
    }

    @GetMapping({"/", "/index"})
    public String getIndex(Model model) {
        List<MemberEntity> list = memberService.readAll();
        model.addAttribute("members", list);
        return "index";
    }

    @GetMapping("/{idx}")
    public String getMember(@PathVariable("idx") Long seq, Model model) {
        Optional<MemberEntity> member = memberService.readById(seq);
        MemberEntity m = member.get();
        model.addAttribute("member", m);
        return "charts";
    }

    @GetMapping("/buttons")
    public String getButtons() {
        return "buttons";
    }

    @GetMapping("/cards")
    public String getCards() {
        return "cards";
    }

    @GetMapping("/utilities-color")
    public String getUtilitiesColor() {
        return "utilities-color";
    }

    @GetMapping("/utilities-border")
    public String getUtilitiesBorder() {
        return "utilities-border";
    }

    @GetMapping("/utilities-animation")
    public String getUtilitiesAnimation() {
        return "utilities-animation";
    }

    @GetMapping("/utilities-other")
    public String getUtilitiesOther() {
        return "utilities-other";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @GetMapping("/forgot-password")
    public String getForgotPassword() {
        return "forgot-password";
    }

    @GetMapping("/404")
    public String get404() {
        return "404";
    }

    @GetMapping("/blank")
    public String getBlank() {
        return "blank";
    }

    @GetMapping("/charts")
    public String getCharts() {
        return "charts";
    }

    @GetMapping("/tables")
    public String getTables() {
        return "tables";
    }
}




