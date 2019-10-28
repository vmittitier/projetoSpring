package com.invillia.resources;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/xablua")
public class XablauController {


    @GetMapping
    public String index(@RequestParam String name, Model model) {
        model.addAttribute("nameHtml", name);
        return "xablau";
    }

    @GetMapping("/{id}")
    public String index(@PathVariable Long id, Model model) {
        model.addAttribute("nameHtml", "name" + id);
        return "xablau";
    }

}
