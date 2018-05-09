package com.aeasycredit.hkcash.configserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * http://www.tony666.com/2018/04/03/SpingCloud/spring-cloud-dataflow/
 */
@SpringBootApplication
@EnableBinding(Sink.class)
public class SinkApplication {
    private final Logger logger = LoggerFactory.getLogger(SinkApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SinkApplication.class, args);
    }
    @StreamListener(Sink.INPUT)
    public void loggerSink(String date) {
        logger.info("Received: " + date);
    }
}