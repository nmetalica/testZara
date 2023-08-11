package com.testZara.configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.testZara.model.Price;
import com.testZara.repository.PricesRespository;

@Configuration
class LoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(PricesRespository repository) {
	  
	  LocalDateTime start1 = LocalDateTime.of(2020, 06, 14, 0, 0);
	  LocalDateTime end1 = LocalDateTime.of(2020, 12, 31, 23, 59,59);
	  
	  LocalDateTime start2 = LocalDateTime.of(2020, 06, 14, 15, 0);
	  LocalDateTime end2 = LocalDateTime.of(2020, 06, 14, 18, 30);
	  
	  LocalDateTime start3 = LocalDateTime.of(2020, 06, 15, 0, 0);
	  LocalDateTime end3 = LocalDateTime.of(2020, 06, 15, 11, 0);
	  
	  LocalDateTime start4 = LocalDateTime.of(2020, 06, 15, 16, 0);
	  LocalDateTime end4 = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
	  

    return args -> {
    	log.info("Saving"+repository.save(
    			new Price(1, start1,end1,35455, 0, 35.50, "EUR")));
    	log.info("Saving"+repository.save(
    			new Price(1, start2,end2,35455, 1, 25.45, "EUR")));
    	log.info("Saving"+repository.save(
    			new Price(1, start3,end3,35455, 1, 30.50, "EUR")));
    	log.info("Saving"+repository.save(
    			new Price(1, start4,end4,35455, 1, 38.95, "EUR")));
    };
  }
}
