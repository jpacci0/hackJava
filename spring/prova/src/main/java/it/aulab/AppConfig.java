package it.aulab;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.aulab.model.Batman;
import it.aulab.model.Batmobile;
import it.aulab.model.Hook;
import it.aulab.model.Mask;
import it.aulab.model.Suit;

@Configuration
public class AppConfig {
    @Bean(name = "batman")
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public Batman getBatman() {
        return new Batman(getSuit(), getBatmobile());
    }

    @Bean(name = "batmobile")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Batmobile getBatmobile() {
        return new Batmobile("grigio");
    }

    @Bean(name = "hook")
    public Hook getHook() {
        return new Hook(10);
    }

    @Bean(name = "mask")
    public Mask getMask() {
        return new Mask("Nero");
    }

    @Bean(name = "suit")
    public Suit getSuit() {
        return new Suit("nero", getMask(), getHook());
    }
}
