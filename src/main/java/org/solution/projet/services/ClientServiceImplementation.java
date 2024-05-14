package org.solution.projet.services;

import org.solution.projet.entities.Avocat;
import org.solution.projet.entities.Client;
import org.solution.projet.entities.RendezVous;
import org.solution.projet.repositories.AvocatRepository;
import org.solution.projet.repositories.ClientRepository;
import org.solution.projet.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImplementation implements ClientService {

    private final ClientRepository clientRepository;


    // Injection de dépendance via le constructeur
    public ClientServiceImplementation(ClientRepository clientRepository, AvocatRepository avocatRepository, RendezVousRepository rendezVousRepository) {
        this.clientRepository = clientRepository;

    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void deleteAllClient() {
        clientRepository.deleteAll();
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }


/*
    @Override
    public boolean createRendezVous(RendezVousDTO rendezVousDTO) {
        Optional<Avocat> optionalAvocat= avocatRepository.findById(rendezVousDTO.getAvocat_id());
        Optional<Client> optionalClient= clientRepository.findById(rendezVousDTO.getClient_id());
        if(optionalAvocat.isPresent() && optionalClient.isPresent()){
            RendezVous rendezVous= new RendezVous();
            rendezVous.setClient(optionalClient.get());
            rendezVous.setAvocat(optionalAvocat.get());


            rendezVousRepository.save(rendezVous);
            return true;


        }

        return false;
    }

 */


}
