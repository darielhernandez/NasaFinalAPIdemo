package com.careerdevs.NasaFinalAPIdemo.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController //allows us to create route handlers. A route handler is a method within a class that is given a specific HTTP method and specific path. When a request comes in that matches the method and path, the route handler returns specific data.
@RequestMapping ("/api/apod")// Will look for a specific path, but not a speicif HTTP method

public class APODcontroller {

    @Autowired
    private Environment env;

    //URL / Endpoint: GET http://localhost:3500/api/apod/test
    @GetMapping("/test")
    private String testRoute(){
        return "NIMBUSSSSS";

    }

    //URL / Endpoint: GET http://localhost:3500/api/apod/today
    @GetMapping("/today")
    private Object apodToday(RestTemplate restTemplate){
        String apodKey= env.getProperty("APOD_KEY", "IfwytowWwR35YpEAuZciPweFCX16uWvUEqPVJCyR");
        String URL= "https://api.nasa.gov/planetary/apod?api_key=" +apodKey;
        Object response= restTemplate.getForObject(URL, Object.class);
        System.out.println(response);
        return response;

    }
}
