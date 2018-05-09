package com.aeasycredit.stream;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;

/**
 * http://www.tony666.com/2018/04/03/SpingCloud/spring-cloud-dataflow/
 * http://192.168.99.100:9393/dashboard/
 */
@EnableBinding(Source.class)
@SpringBootApplication
public class SourceApplication {
    
    private final Logger logger = LoggerFactory.getLogger(SourceApplication.class);
    private int count = 0;
    public static void main(String[] args) {
        SpringApplication.run(SourceApplication.class, args);
    }
    @InboundChannelAdapter(
            value = Source.OUTPUT,
            poller = @Poller(maxMessagesPerPoll = "1", fixedDelay = "10000")
    )
    public Long timeSource() {
        logger.info("Send event: {}", ++count);
        return new Date().getTime();
    }
}
