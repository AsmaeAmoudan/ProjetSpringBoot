package org.solution.projet.controllers;

import lombok.AllArgsConstructor;
import org.solution.projet.entities.Avocat;
import org.solution.projet.entities.Client;
import org.solution.projet.services.AvocatService;
import org.solution.projet.services.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class AvocatController {

    private AvocatService avocatService;

    @RequestMapping("/createAvocat")
    public String createAvocat(){
        return "CreateAvocat";
    }

    @RequestMapping("/saveAvocat")
    public String saveAvocat(@ModelAttribute("avocatVue") Avocat avocatController)
    {
        Avocat saveAvocat= avocatService.saveAvocat(avocatController);
        return "CreateAvocat";

    }

    @RequestMapping("/avocatsList")
    public String avocatsList(ModelMap modelMap)
    {
        List<Avocat> avocatsController= avocatService.getAllAvocat();
        modelMap.addAttribute("avocatsVue", avocatsController);
        return "AvocatsList";

    }

    @RequestMapping("/deleleAvocat")
    public String deleteAvocat(@RequestParam("id") Long id, ModelMap modelMap){
        avocatService.deleteAvocatById(id);
        List<Avocat> avocatsController= avocatService.getAllAvocat();
        modelMap.addAttribute("avocatsVue", avocatsController);
        return "AvocatsList";
    }

    @RequestMapping("/editAvocat")
    public String editAvocat(@RequestParam("id") Long id, ModelMap modelMap){
        Avocat avocat = avocatService.getAvocatById(id);
        if (avocat != null) {
            modelMap.addAttribute("avocatVue", avocat);
            return "editAvocat";
        } else {
            // Gérer le cas où l'avocat n'est pas trouvé
            return "error";
        }
    }


    @RequestMapping("/updateAvocat")
    public String updateAvocat(@ModelAttribute("avocatVue")Avocat avocatController){
        avocatService.updateAvocat(avocatController);
        return "createAvocat";

    }
}
