package ru.netology.SpringBoot_HW1_ConditionalApp.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.SpringBoot_HW1_ConditionalApp.profile.DevProfile;
import ru.netology.SpringBoot_HW1_ConditionalApp.profile.ProductionProfile;
import ru.netology.SpringBoot_HW1_ConditionalApp.profile.SystemProfile;

@Configuration
public class JavaConfig {
    @Bean
    @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "true")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
