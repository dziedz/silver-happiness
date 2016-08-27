package my.learn.boardgame.game;


import lombok.Builder;
import lombok.Data;
import my.learn.boardgame.player.Player;
import my.learn.boardgame.client.Client;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@Builder
public class Game {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "game")
    private List<Player> players;

    @OneToMany(mappedBy = "game")
    private List<Client> clients;
}
