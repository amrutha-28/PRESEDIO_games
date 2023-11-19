package com.amrutha.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GameController {
    @Autowired
    private GameService gameService;
//
    @GetMapping("/")
    public String landingPage(Model model) {
        List<Game> games = gameService.getAllGames();
        model.addAttribute("games", games);
        return "index";
    }
//
//    @GetMapping("/search")
//    public String searchGames(@RequestParam String criteria, @RequestParam String value, Model model) {
//        List<Game> searchResults = gameService.searchGames(criteria, value);
//        model.addAttribute("games", searchResults);
//        return "index";
//    }
//
    @GetMapping("/add")
    public String addGamePage(Model model) {
        Game game = new Game();
        model.addAttribute("game", game);
        return "add";
    }

    @PostMapping("/add")
    public String addGame(@ModelAttribute Game game) {
        gameService.addGame(game);
        return "redirect:/";
    }

}
