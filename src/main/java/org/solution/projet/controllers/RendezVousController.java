package org.solution.projet.controllers;

import lombok.AllArgsConstructor;
import org.solution.projet.entities.Avocat;
import org.solution.projet.entities.Client;
import org.solution.projet.entities.RendezVous;
import org.solution.projet.services.AvocatService;
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
public class RendezVousController {
    private RendezVousService rendezVousService;
    private AvocatService avocatService;
    private ClientService clientService;

    @RequestMapping("/createRendezVous")
    public String createRendezVous(ModelMap modelMap) {
        List<Avocat> avocatsController= avocatService.getAllAvocat();
        modelMap.addAttribute("avocatsVue", avocatsController);
        return "CreateRendezVous";
    }

    @RequestMapping("/saveRendezVous")
    public String saveRendezVous(@ModelAttribute("rendezVousVue") RendezVous rendezVousController) {
        RendezVous saveRendezVous = rendezVousService.saveRendezVous(rendezVousController);
        return "CreateRendezVous";

    }

    @RequestMapping("/rendezVousList")
    public String rendezVousList(ModelMap modelMap) {
        List<RendezVous> rendezVousController = rendezVousService.getAllRendezVous();
        modelMap.addAttribute("rendezVousVue", rendezVousController);
        return "RendezVousList";

    }

    @RequestMapping("/deleleRendezVous")
    public String deleteRendezVous(@RequestParam("id") Long id, ModelMap modelMap) {
        rendezVousService.deleteRendezVousById(id);
        List<RendezVous> rendezVousController = rendezVousService.getAllRendezVous();
        modelMap.addAttribute("rendezVousVue", rendezVousController);
        return "RendezVousList";
    }

    @RequestMapping("/editRendezVous")
    public String editRendezVous(@RequestParam("id") Long id, ModelMap modelMap) {
        RendezVous rendezVous = rendezVousService.getRendezVousById(id);
        if (rendezVous != null) {
            modelMap.addAttribute("rendezVousVue", rendezVous);
            return "EditRendezVous";
        } else {
            // Gérer le cas où l'avocat n'est pas trouvé
            return "error";
        }
    }

    @RequestMapping("/updateRendezVous")
    public String updateRendezVous(@ModelAttribute("rendezVousVue") RendezVous rendezVousController){
        rendezVousService.updateRendezVous(rendezVousController);
        return "CreateRendezVous";

    }
}
