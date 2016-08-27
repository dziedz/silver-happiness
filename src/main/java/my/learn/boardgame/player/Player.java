package my.learn.boardgame.player;

import lombok.Builder;
import lombok.Data;
import my.learn.boardgame.game.Game;
import my.learn.boardgame.client.Client;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@Builder
public class Player {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Game game;

    @ManyToOne
    private Client client;
}
