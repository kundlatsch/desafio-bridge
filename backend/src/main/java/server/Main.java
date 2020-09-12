package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import server.History;

@SpringBootApplication
@RestController
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  
  }

}