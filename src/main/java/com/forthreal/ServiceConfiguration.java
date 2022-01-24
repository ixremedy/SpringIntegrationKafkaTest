package com.forthreal;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import java.util.HashMap;

@EnableIntegration
@SpringBootConfiguration
public class ServiceConfiguration
{
    @Bean
    public KafkaTemplate<String,String> kafkaTemplate()
    {
        var configProperties =
                new HashMap<String, Object>() {{
                    put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
                    put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
                    put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
                }};

        var factory = new DefaultKafkaProducerFactory<String,String>(configProperties);
        return new KafkaTemplate<>(factory);
    }

}
