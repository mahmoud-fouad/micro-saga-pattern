package com.mfouad.shipmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.thoughtworks.xstream.XStream;

@SpringBootApplication
public class ShipmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShipmentServiceApplication.class, args);
	}

		@Bean
public XStream xStream() {
    XStream xStream = new XStream();

    xStream.allowTypesByWildcard(new String[] { "com.mfouad.**" });
    return xStream;
}

}
