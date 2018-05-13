package configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import soccerPack.Game;

@Configuration
@Import(MainBeans.class)
public class ApplicationConfig {

    @Autowired
    public Game game;

}
