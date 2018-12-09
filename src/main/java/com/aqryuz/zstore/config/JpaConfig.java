package com.aqryuz.zstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.aqryuz.zstore.entity.User;
import com.aqryuz.zstore.utils.SpringSecurityAuditorAware;


@Configuration
@EnableJpaAuditing
public class JpaConfig {
	@Bean
	public AuditorAware<User> auditorAware(){
		return new SpringSecurityAuditorAware();
	}
}