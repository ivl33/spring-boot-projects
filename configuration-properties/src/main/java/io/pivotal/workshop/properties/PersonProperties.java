package io.pivotal.workshop.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "person")
public class PersonProperties {

	private String greeting;

	private String farewell;
	
	private int count;

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String getFarewell() {
		return farewell;
	}

	public void setFarewell(String farewell) {
		this.farewell = farewell;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
