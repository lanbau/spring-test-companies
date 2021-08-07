package com.example.lanbau;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
public class LanbauApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(LanbauApplication.class);

	@Autowired
	private CompanyRepository repository;

	@RequestMapping
	public String home(){
		repository.save(new Company("Amazon"));
		repository.save(new Company("Oracle"));
		repository.save(new Company("Tencent"));

		System.out.println("\nfindAll()");
		repository.findAll().forEach(x -> System.out.println(x));

		System.out.println("\nfindById(1L)");
		repository.findById(1l).ifPresent(x -> System.out.println(x));

		System.out.println("\nfindByName('Node')");
		repository.findByName("Node").forEach(x -> System.out.println(x));

		return "<h1>Saved 3 Companies!</h1>";
	}


	public static void main(String[] args) {
		SpringApplication.run(LanbauApplication.class, args);
	}

	@Override
	public void run(String... args) {

		log.info("StartApplication...");


	}

}