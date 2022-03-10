package Goldra9.bookStore.controller;

import Goldra9.bookStore.controller.form.MemberForm;
import Goldra9.bookStore.domain.Address;
import Goldra9.bookStore.domain.Member;
import Goldra9.bookStore.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    //== 회원 Form 등록 ==//
    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMember";
    }

    //== 회원 등록 ==//
    @PostMapping("/members/new")
    public String create(@Valid MemberForm memberForm, BindingResult result)
    {
        if (result.hasErrors())
        {
            return "members/createMember";
        }
        Address address = new Address(memberForm.getCity(), memberForm.getStreet(), memberForm.getZipcode());

        Member member = new Member(memberForm.getName(), address, memberForm.getPhone(),
                                   memberForm.getEmail(), memberForm.getPersonNumber());

        memberService.join(member);

        return "redirect:/";

    }

    //== 회원 목록 ==//
    @GetMapping("/members")
    public String List(Model model)
    {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
