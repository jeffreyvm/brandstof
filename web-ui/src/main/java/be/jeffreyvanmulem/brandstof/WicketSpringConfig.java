package be.jeffreyvanmulem.brandstof;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 5/06/12
 * Time: 20:27
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class WicketSpringConfig {
    @Bean
    public WicketApplication wicketApplication(){
        return new WicketApplication();
    }
}
