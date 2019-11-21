package io.pivotal.workshop.directory.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.pivotal.workshop.directory.aop.SimpleAudit;

@Configuration
public class DirectoryConfig {
	
	@ConditionalOnClass(name = "io.pivotal.workshop.directory.repository.DirectoryRepository")
	@Bean
	public SimpleAudit simpleAudit() {
		return new SimpleAudit();
	}
}
