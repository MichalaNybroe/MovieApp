package com.example.demomedtine.controllers;

import com.example.demomedtine.services.IMDBDBService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IMDBDBController {
    // Vi vil gerne vide hvordan vi formår at lukke vores connection - helst igennem en finally
    // og samtidig kunne genlæser siden med nyt resultat.

    @GetMapping("/")
    public String welcome() {
        String welcome = "Welcome!";
        String description;
        description = "This application will give you permission to search though imdb database!";
        return welcome + description;
    }

    @GetMapping("/getFirst")
    public String findFirstMovieTitle() {
        return IMDBDBService.findColumnValueFromQuery("SELECT movies.title FROM movies WHERE ID=1", "title");
    }

    @GetMapping("/getRandom")
    public String findRandomMovieTitle() {
        return IMDBDBService.findColumnValueFromQuery("SELECT movies.title FROM movies ORDER BY RAND() LIMIT 1", "title");
    }

    @GetMapping("/getTenSortByPopularity")
    public String findTenRandomSortedByPopularity() {
        return IMDBDBService.getMoviesFromQuery("SELECT * FROM (SELECT * FROM movies ORDER BY RAND() LIMIT 10) AS randomTen ORDER BY popularity ASC").toString();
    }

    @GetMapping("/howManyWonAnAward")
    public String countWhoWon() {
        return "" + IMDBDBService.countAwards("SELECT count(*) FROM movies WHERE awards='Yes'");
    }

    @GetMapping("/inputMovie")
    public String makeAndShowMovie(
            @RequestParam String title,
            @RequestParam String year,
            @RequestParam int length,
            @RequestParam String subject,
            @RequestParam int popularity,
            @RequestParam String awards
            ) {
        return IMDBDBService.advanced(title, year, length, subject, popularity, awards).toString();
    }

    @GetMapping("/advanced")
    public String findComediesThatWon() {
        return IMDBDBService.displayComediesThatWon("SELECT * FROM movies WHERE awards='Yes' AND subject='Comedy'");
    }
}
