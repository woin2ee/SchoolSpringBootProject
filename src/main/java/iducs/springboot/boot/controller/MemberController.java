package iducs.springboot.boot.controller;

import iducs.springboot.boot.domain.Member;
import iducs.springboot.boot.domain.PageRequestDTO;
import iducs.springboot.boot.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/members")
public class MemberController {
    private final
    MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("regform")
    public String getRegform(Model model) {
        // 정보를 전달받을 객체를 보냄
        model.addAttribute("member", Member.builder().build());
        return "/members/regform";
    }

    @PostMapping("")
    public String postMember(@ModelAttribute("member") Member member, Model model) {
        memberService.create(member);
        return "redirect:/members";
    }

    @GetMapping("")
    public String getMembers(PageRequestDTO pageRequestDTO, Model model) {
//        List<Member> members = memberService.readAll();
//        model.addAttribute("members", members);
        model.addAttribute("list", memberService.readListBy(pageRequestDTO));
        return "members/members";
    }

    // /members/일련번호 : PathVariable 매핑해서 접근
    @GetMapping("/{idx}")
    public String getMember(@PathVariable("idx") Long seq, Model model) {
        Member member = memberService.readById(seq);
        model.addAttribute("member", member);
        return "/members/member";
    }

    @GetMapping("/{idx}/upform")
    public String getUpform(@PathVariable("idx") Long seq, Model model) {
        Member member = memberService.readById(seq);
        model.addAttribute("member", member);
        return "/members/upform";
    }

    @PutMapping("{idx}")
    public String putMember(@ModelAttribute("member") Member member, Model model) {
        memberService.update(member);
        model.addAttribute(member);
        return "/members/member";
    }

    @GetMapping("/{idx}/delform")
    public String getDelform(@PathVariable("idx") Long seq, Model model) {
        Member member = memberService.readById(seq);
        model.addAttribute(member);
        return "/members/delform";
    }

    // Model 을 이용한 방법
    @DeleteMapping("{idx}")
    public String delMember(@ModelAttribute("member") Member member, Model model) {
        memberService.delete(member);
        return "redirect:/members";
    }
//    // Seq 를 이용한 방법
//    @DeleteMapping("{idx}")
//    public String delMember(@PathVariable("idx") Long seq, Model model) {
//        Member member = memberService.readById(seq);
//        memberService.delete(member);
//        return "redirect:/members";
//    }




    @GetMapping("/th")
    public String getThymeleaf() {
        return "thymeleaf";
    }
//
//    @GetMapping({"/", "/index"})
//    public String getIndex(Model model) {
//        List<MemberEntity> list = memberService.readAll();
//        model.addAttribute("members", list);
//        return "index";
//    }
//
//    @GetMapping("/{idx}")
//    public String getMember(@PathVariable("idx") Long seq, Model model) {
//        Optional<MemberEntity> member = memberService.readById(seq);
//        MemberEntity m = member.get();
//        model.addAttribute("member", m);
//        return "charts";
//    }

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




