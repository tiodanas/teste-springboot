package br.gov.sc.ciasc.webnuc.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebnucApplication {

	public static final String API_ENDPOINT = "/api/";

	public static void main(String[] args) {
		SpringApplication.run(WebnucApplication.class, args);
	}
}
