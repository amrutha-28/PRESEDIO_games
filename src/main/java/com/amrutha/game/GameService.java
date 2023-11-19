package com.amrutha.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GameService {
//    @Autowired
//    private GameRepository gameRepository;
//
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Game> getAllGames() {
        return this.jdbcTemplate.query("SELECT id, title, genre, year from games", new GameMapper());
    }
//
    public int addGame(Game game) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("id",game.getId());
//        params.put("title",game.getTitle());
//        params.put("genre",game.getGenre());
//        params.put("year",game.getYear());
        return this.jdbcTemplate.update("INSERT INTO games( title, genre, year) VALUES(:title,:genre,:year)",  game.getTitle(),game.getGenre(),game.getYear());
    }


//
//    public List<Game> searchGames(String criteria, String value) {
//        // Implement search logic based on criteria (e.g., title, genre, year)
//        // Use gameRepository.findBy<Criteria> methods
//        return null;
//    }
    private static final class GameMapper implements RowMapper<Game> {
        public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
            Game emp = new Game();
            emp.setId(rs.getString("id"));
            emp.setTitle(rs.getString("title"));
            emp.setGenre(rs.getString("genre"));
            emp.setYear(rs.getString("year"));
            return emp;
        }
    }
}
