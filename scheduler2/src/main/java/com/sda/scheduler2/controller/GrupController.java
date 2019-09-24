package com.sda.scheduler2.controller;

import com.sda.scheduler2.entity.Grup;
import com.sda.scheduler2.service.GrupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/grup")
public class GrupController {
    @Autowired
    private GrupService grupService;

    @GetMapping("/list")
    public String listGrup(Model model) {
        List<Grup> list = grupService.getAllGrups();
        model.addAttribute("grupList", list);
        model.addAttribute("newGrup", new Grup());
        return "grupList";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteGrup(ModelMap model, @RequestParam("GrupID") Integer GrupID) {

        grupService.deleteGrup(GrupID);
        List<Grup> list = grupService.getAllGrups();
        model.addAttribute("grupList", list);
        return "redirect:/grup/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateGrupView(ModelMap model, @RequestParam("GrupID") Integer GrupID) {
        Grup grupToBeUpdated = grupService.getById(GrupID);
        List<Grup> list = grupService.getAllGrups();
        model.addAttribute("grupList", list);
        model.addAttribute("newGrup", grupToBeUpdated);
        return "grupList";
    }


    @PostMapping("/save")
    public String save(Model model, @ModelAttribute Grup newGrup) {
        grupService.save(newGrup);
        return "redirect:/grup/list";
    }
}
