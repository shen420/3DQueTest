package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    //Launches application using Spring Boot without need for XML file
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    //@GetMapping maps HTTP GET requests to reverse() method
    //@RequestParam binds value of the query string into "string" parameter of the reverse() method,
    // if the "string" parameter is empty use the defaultValue
    @GetMapping("/reverse")
    public String reverse(@RequestParam(value = "string", defaultValue = "----") String string) {
        StringBuilder input = new StringBuilder();

        // append a string into StringBuilder input1
        input.append(string);

        // reverse StringBuilder input
        input = input.reverse();

        // print reversed String
        return input.toString();
    }
}