package com.example.demo.configure;

import com.example.demo.listener.RegisterListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author
 * @date
 */
@Configuration
public class ListenerConfig {
    @Bean
    public RegisterListener registerListener() {
        return new RegisterListener();
    }
}
