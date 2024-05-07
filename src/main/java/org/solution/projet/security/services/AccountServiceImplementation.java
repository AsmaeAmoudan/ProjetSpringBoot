package org.solution.projet.security.services;

import jakarta.transaction.Transactional;
import org.solution.projet.security.entities.Role;
import org.solution.projet.security.entities.User;
import org.solution.projet.security.repositories.RoleRepository;
import org.solution.projet.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional //permet insertion de role
public class AccountServiceImplementation implements AccountService{

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public User createUser(String username, String password, String email, String confirmPassword) {
        /*

        User user1= new User();
        user1.setUserId(UUID.randomUUID().toString());
        user1.setUsername(username);
        user1.setPassword(bCryptPasswordEncoder.encode(password));
        user1.setEmail(email);
        userRepository.save(user1);


         */




        User user1= userRepository.findByUsername(username);
        if(user1!=null) throw new RuntimeException("User already exists");
        if(!password.equals(confirmPassword)) throw new RuntimeException("Password do not match");
                user1= User.builder()
                .userId(UUID.randomUUID().toString())
                .username(username)
                .password(bCryptPasswordEncoder.encode(password))
                .email(email)
                .build();
        return userRepository.save(user1);

    }

    @Override
    public Role createRole(String newRole) {
        Role role= roleRepository.findByRole(newRole);
        if(role!= null) throw new RuntimeException("Role already exists");
                role= org.solution.projet.security.entities.Role
                .builder()
                .role(newRole)
                .build();
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String usename, String newRole) {

        User user= userRepository.findByUsername(usename);
        Role role= roleRepository.findByRole(newRole);
        user.getRoles().add(role);

    }

    @Override
    public void removeRoleFromUser(String username, String newRole) {
        User user= userRepository.findByUsername(username);
        Role role= roleRepository.findByRole(newRole);
        user.getRoles().remove(role);

    }

    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
