package com.invillia.resources;

import com.invillia.services.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    private TeamService teamService;

    @GetMapping
    public String redirect(){
        return "index";
    }




}
