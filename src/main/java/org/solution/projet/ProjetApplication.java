package org.solution.projet;

import org.solution.projet.security.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjetApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountService accountService){
        return args -> {
            /*

            accountService.createUser("admin", "123", "admin@gmail.com", "123");
                    accountService.createUser("avocat", "123", "avocat@gmail.com", "123");
                    accountService.createUser("client", "123", "client@gmail.com", "123");

            accountService.createRole("ADMIN");
            accountService.createRole("AVOCAT");
            accountService.createRole("USER");

            accountService.addRoleToUser("admin", "ADMIN");
            accountService.addRoleToUser("avocat", "AVOCAT");
            accountService.addRoleToUser("avocat", "USER");
            accountService.addRoleToUser("client", "USER");


         accountService.removeRoleFromUser("avocat", "USER" );

             */

        };
    }



}
