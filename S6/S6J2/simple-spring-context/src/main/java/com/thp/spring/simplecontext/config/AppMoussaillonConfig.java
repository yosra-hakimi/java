package com.thp.spring.simplecontext.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.thp.spring.simplecontext.entity.Bateau;
import com.thp.spring.simplecontext.entity.Moussaillon;

@Configuration
public class AppMoussaillonConfig {

   @Bean
   public Moussaillon moussaillon() {
      Moussaillon moussaillon = new Moussaillon();
      moussaillon.setFirstName("Johnny");
      moussaillon.setLastName("Depp");
      moussaillon.setConfig("Java");
      return moussaillon;
   }
}



