package com.invillia.resources;

import com.invillia.entities.Member;
import com.invillia.entities.Team;
import com.invillia.services.MemberService;
import com.invillia.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "/memberservice")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private TeamService teamService;

    @GetMapping("/list-team-members/{id}")
    public String findAllMembers(@PathVariable Long id, Model model) {
        List<Member> members = memberService.findByTeamId(id);
        System.out.println("Entrou");
        model.addAttribute("members", members);
        System.out.println(members);
        return "list-team-members";
    }

    @GetMapping
    public String findAll(Model model) {
        List<Member> members = memberService.findAll();
        System.out.println(members);
        model.addAttribute("member", members);
        return "memberservice";
    }

    @PostMapping("/updatemember/{id}")
    public String editForm(@PathVariable Long id, String editMemberName) {
        System.out.println(id + "Update");
         memberService.findById(id).ifPresent(member -> {
             member.setMemberName(editMemberName);
             System.out.println(member);
             memberService.save(member);
        });

        return "redirect:/memberservice";
    }

    @GetMapping("/editmember/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        System.out.println(id + "Edit");
        Member member = memberService.findById(id).get();
        model.addAttribute("member", member);
        return "editmember";
    }

    @GetMapping("/registermember")
    public String showForm(Model model) {
        model.addAttribute("teams", teamService.findAll());
        return "registermember";
    }

    @PostMapping("/delete/{id}")
    public String deleteTeam(@PathVariable Long id) {
        memberService.deleteMemberById(id);
        return "redirect:/memberservice";
    }

    @PostMapping("/registermember")
    public String insertTeam(@RequestParam String memberName, @RequestParam Team teamName) {
        memberService.save(new Member(memberName,teamName));
        return "redirect:/memberservice";
    }


}

