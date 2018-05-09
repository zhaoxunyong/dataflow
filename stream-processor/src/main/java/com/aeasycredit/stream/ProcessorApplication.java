package com.aeasycredit.stream;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

/**
 * http://www.tony666.com/2018/04/03/SpingCloud/spring-cloud-dataflow/
 * http://192.168.99.100:9393/dashboard/
 */
@EnableBinding(Processor.class)
@SpringBootApplication
public class ProcessorApplication {
    private final Logger logger = LoggerFactory.getLogger(ProcessorApplication.class);
    private int count = 0;
    public static void main(String[] args) {
        SpringApplication.run(ProcessorApplication.class, args);
    }
    @Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
    public Object transform(Long timestamp) {
        logger.info("processor input: {}", ++count);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        return dateFormat.format(timestamp);
    }
}