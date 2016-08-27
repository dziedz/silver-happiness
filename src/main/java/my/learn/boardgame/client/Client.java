package my.learn.boardgame.client;

import lombok.Builder;
import lombok.Data;
import my.learn.boardgame.game.Game;
import my.learn.boardgame.player.Player;

import javax.persistence.*;

@Entity
@Data
@Builder
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Game game;

    @OneToMany(mappedBy = "client")
    private Player player;

}
