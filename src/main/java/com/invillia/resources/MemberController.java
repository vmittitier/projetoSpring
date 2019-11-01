package com.invillia.resources;

import com.invillia.entities.Member;
import com.invillia.entities.Team;
import com.invillia.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping(value = "/teamservice")
public class MemberController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/list-team-members/{id}")
    public String findAllMembers(@PathVariable Long id,Model model){
        List<Member> members = teamService.findAllById(id);
        System.out.println("Entrou");
        model.addAttribute("members",members);
        System.out.println(members);
        return "list-team-members";
    }

    @GetMapping
    public String findAll(Model model) {
        List<Team> teams = teamService.findAll();
        Optional<Team> team = teamService.findById(1L);
        System.out.println(team.get().getListMembers());
        model.addAttribute("teams", teams);
        return "teamservice";
    }

    @PostMapping("/updateteam/{id}")
    public String editForm(@PathVariable Long id, @Valid Team team, String editTeamName) {
        System.out.println(id+"Update");
        team.setTeamName(editTeamName);
        teamService.save(team);
        return "redirect:/teamservice";

    }

    @GetMapping("/editteam/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model){
        System.out.println(id+"Edit");
        Team team = teamService.findById(id).get();
        model.addAttribute("team",team);
        return "editteam";
    }

    @GetMapping("/registerteam")
    public String showForm(){
        return "registerteam";
    }

    @PostMapping("/delete/{id}")
    public String deleteTeam(@PathVariable Long id){
        teamService.deleteTeamById(id);
        return "redirect:/teamservice";
    }

    @PostMapping("/teamregister")
    public String insertTeam(@RequestParam String teamName){
        teamService.insertTeam(new Team(teamName));
        return "redirect:/teamservice";
    }








}

