package org.solution.projet.controllers;

import lombok.AllArgsConstructor;
import org.solution.projet.entities.Avocat;
import org.solution.projet.entities.Bureau;
import org.solution.projet.entities.RendezVous;
import org.solution.projet.services.AvocatService;
import org.solution.projet.services.BureauService;
import org.solution.projet.services.ClientService;
import org.solution.projet.services.RendezVousService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class BureauController {

    private BureauService bureauService;

    @RequestMapping("/createBureau")
    public String createBureau() {

        return "CreateBureau";
    }

    @RequestMapping("/saveBureau")
    public String saveBureau(@ModelAttribute("bureauVue") Bureau bureauController) {
        Bureau saveBureau = bureauService.saveBureau(bureauController);
        return "CreateBureau";

    }

    @RequestMapping("/bureauList")
    public String bureauList(ModelMap modelMap) {
        List<Bureau> bureausController = bureauService.getAllBureau();
        modelMap.addAttribute("bureauVue", bureausController);
        return "BureauList";

    }

    @RequestMapping("/deleleBureau")
    public String deleteBureau(@RequestParam("id") Long id, ModelMap modelMap) {
        bureauService.deleteBureauById(id);
        List<Bureau> bureausController = bureauService.getAllBureau();
        modelMap.addAttribute("bureauVue", bureausController);
        return "BureauList";
    }

    @RequestMapping("/editBureau")
    public String editBureau(@RequestParam("id") Long id, ModelMap modelMap) {
        Bureau bureau = bureauService.getBureauById(id);
        if (bureau != null) {
            modelMap.addAttribute("bureauVue", bureau);
            return "EditBureau";
        } else {
            // Gérer le cas où le bureau n'est pas trouvé
            return "error";
        }
    }

    @RequestMapping("/updateBureau")
    public String updateBureau(@ModelAttribute("bureauVue") Bureau bureauController){
        bureauService.updateBureau(bureauController);
        return "CreateBureau";

    }
}
