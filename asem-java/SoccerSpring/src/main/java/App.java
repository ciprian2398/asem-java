import configurations.ApplicationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import soccerPack.Game;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ApplicationConfig.class);
        ctx.refresh();

        ApplicationConfig applicationConfig = ctx.getBean(ApplicationConfig.class);

        Game game = applicationConfig.game;
        game.showGoalsStatistics();

    }
}
