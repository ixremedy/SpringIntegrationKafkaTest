package com.forthreal;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import java.util.HashMap;
import java.util.Map;

@EnableIntegration
@SpringBootConfiguration
public class ServiceConfiguration
{
    final private Map<String, Object> configProperties =
            new HashMap<>() {{
                put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.31.52:9092");
                put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
                put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
            }};

    private DefaultKafkaProducerFactory<String,String> factory =
                new DefaultKafkaProducerFactory<>(configProperties);

    @Bean
    public Producer<String,String> kafkaProducer()
    {
        return factory.createProducer();
    }

    @Bean
    public KafkaTemplate<String,String> kafkaTemplate()
    {
        return new KafkaTemplate<>(factory);
    }

    @Bean
    public SampleProducer sampleProducer()
    {
        return new SampleProducer();
    }
}
