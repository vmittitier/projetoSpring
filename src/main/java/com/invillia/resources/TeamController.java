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
public class TeamController{

    @Autowired
    private TeamService teamService;

    @GetMapping("/list-team-members/{id}")
    public String findAllMembers(@PathVariable Long id,Model model){
        Optional<Team> team = teamService.findById(id);
        List<Member> members = team.get().getListMembers();
        model.addAttribute("members",members);
        model.addAttribute("teamName",team.get());
        return "list-team-members";
    }

    @GetMapping
    public String findAll(Model model) {
        List<Team> teams = teamService.findAll();
        model.addAttribute("teams", teams);
        return "teamservice";
    }

    @PostMapping("/updateteam/{id}")
    public String editForm(@PathVariable Long id, @Valid Team team, String editTeamName,Model model) {
        team.setTeamName(editTeamName);
        teamService.save(team);
        model.addAttribute("team",team);
        return "redirect:/teamservice";
    }

    @GetMapping("/editteam/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model){
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

