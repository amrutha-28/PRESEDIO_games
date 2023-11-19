package com.amrutha.game;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {


    //Spring Boot will automagically wire this object using application.properties:
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //Create the database table:
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS games(id VARCHAR(10), title VARCHAR(20),genre VARCHAR(10), year VARCHAR(4))");

        //Insert a record:
        jdbcTemplate.execute("INSERT INTO games VALUES ('1', 'angrybirds','casual','1989')");

        //Read records:
        List<Game> games = jdbcTemplate.query("SELECT * FROM games",
                (resultSet, rowNum) -> new Game(resultSet.getString("id"),
                        resultSet.getString("title"),
                        resultSet.getString("genre"),
                        resultSet.getString("year")));

        //Print read records:
        games.forEach(System.out::println);
    }


}