package org.solution.projet.controllers;

import lombok.AllArgsConstructor;
import org.solution.projet.entities.Client;
import org.solution.projet.entities.Specialite;
import org.solution.projet.services.ClientService;
import org.solution.projet.services.SpecialiteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@AllArgsConstructor
public class SpecialiteController {
    private SpecialiteService specialiteService;

    @RequestMapping("/createSpecialite")
    public String createSpecialite(){
        return "CreateSpecialite";
    }

    @RequestMapping("/saveSpecialite")
    public String saveSpecialite(@ModelAttribute("specialiteVue") Specialite specialiteController)
    {
        Specialite saveSpecialite= specialiteService.saveSpecialite(specialiteController);
        return "CreateSpecialite";

    }

    @RequestMapping("/specialitesList")
    public String specialitesList(ModelMap modelMap)
    {
        List<Specialite> specialitesController= specialiteService.getAllSpecialite();
        modelMap.addAttribute("specialitesVue", specialitesController);
        return "SpecialitesList";

    }

    @RequestMapping("/deleleSpecialite")
    public String deleleSpecialite(@RequestParam("id") Long id, ModelMap modelMap){
        specialiteService.deleteSpecialiteById(id);
        List<Specialite> specialitesController= specialiteService.getAllSpecialite();
        modelMap.addAttribute("specialitesVue", specialitesController);
        return "SpecialitesList";
    }

    @RequestMapping("/editSpecialite")
    public String editSpecialite(@RequestParam("id") Long id, ModelMap modelMap){
        Specialite specialite = specialiteService.getSpecialiteById(id);
        if (specialite != null) {
            modelMap.addAttribute("specialiteVue", specialite);
            return "EditSpecialite";
        } else {
            // Gérer le cas où le client n'est pas trouvé
            return "error";
        }
    }


    @RequestMapping("/updateSpecialite")
    public String updateSpecialite(@ModelAttribute("specialiteVue")Specialite specialiteController){
        specialiteService.updateSpecialite(specialiteController);
        return "CreateSpecialite";

    }
}
