package org.solution.projet.services;

import org.solution.projet.entities.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {
    Client saveClient(Client client);
    Client updateClient(Client client);
    void deleteClientById(Long id);
    void deleteAllClient();
    Client getClientById(Long id);

    List<Client> getAllClient();




    //boolean createRendezVous(RendezVousDTO rendezVousDTO);
}
