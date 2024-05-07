package org.solution.projet.security.services;

import org.solution.projet.security.entities.Role;
import org.solution.projet.security.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    User createUser(String username, String password, String email, String confirmPassword);
    Role createRole(String newRole);
    void addRoleToUser(String usename, String newRole);
    void removeRoleFromUser(String User, String newRole);
    User loadUserByUsername (String username);
}
