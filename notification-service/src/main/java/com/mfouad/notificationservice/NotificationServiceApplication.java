package com.mfouad.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.thoughtworks.xstream.XStream;

@SpringBootApplication
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

		@Bean
public XStream xStream() {
    XStream xStream = new XStream();

    xStream.allowTypesByWildcard(new String[] { "com.mfouad.**" });
    return xStream;
}

}
