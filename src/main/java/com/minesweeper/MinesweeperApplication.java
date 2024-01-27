package com.minesweeper;

import com.minesweeper.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties(RsaKeyProperties.class)
public class MinesweeperApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinesweeperApplication.class, args);
	}

}
