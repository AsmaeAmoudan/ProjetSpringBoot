package org.solution.projet.controllers;

import lombok.AllArgsConstructor;
import org.solution.projet.entities.Client;
import org.solution.projet.services.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class ClientController {

    private ClientService clientService;

    @RequestMapping("/createClient")
    public String createClient(){
        return "CreateClient";
    }

    @RequestMapping("/saveClient")
    public String saveClient(@ModelAttribute("clientVue")Client clientController)
    {
        Client saveClient= clientService.saveClient(clientController);
        return "CreateClient";

    }

    @RequestMapping("/clientsList")
    public String clientsList(ModelMap modelMap)
    {
        List<Client> clientsController= clientService.getAllClient();
        modelMap.addAttribute("clientsVue", clientsController);
        return "ClientsList";

    }

    @RequestMapping("/deleleClient")
    public String deleleClient(@RequestParam("id") Long id, ModelMap modelMap){
        clientService.deleteClientById(id);
        List<Client> clientsController= clientService.getAllClient();
        modelMap.addAttribute("clientsVue", clientsController);
        return "ClientsList";
    }

    @RequestMapping("/editClient")
    public String editClient(@RequestParam("id") Long id, ModelMap modelMap){
        Client client = clientService.getClientById(id);
        if (client != null) {
            modelMap.addAttribute("clientVue", client);
            return "EditClient";
        } else {
            // Gérer le cas où le client n'est pas trouvé
            return "error";
        }
    }


    @RequestMapping("/updateClient")
    public String updateClient(@ModelAttribute("clientVue")Client clientController){
        clientService.updateClient(clientController);
        return "createClient";

    }

}
