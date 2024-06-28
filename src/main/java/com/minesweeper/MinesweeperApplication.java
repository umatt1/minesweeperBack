package com.minesweeper;

import com.minesweeper.model.Role;
import com.minesweeper.model.User;
import com.minesweeper.repo.RoleRepository;
import com.minesweeper.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "com.minesweeper")
@EntityScan(basePackages = "com.minesweeper.model")
@EnableJpaRepositories(basePackages = "com.minesweeper.repo")
public class MinesweeperApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinesweeperApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (roleRepository.findByAuthority("ADMIN").isPresent()) {
				return;
			}
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

//			Set<Role> roles = new HashSet<>();
//			roles.add(adminRole);
//			User admin = new User(12345, "user", "password", roles);
//			userRepository.save(admin);
		};
	}

}
