package com.forthreal;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class SampleProducer
{
    @Lazy @Autowired
    private Producer<String,String> kafkaProducer;

    public boolean sendMessageSimple(String topicName, String key, String value)
    {
        final ProducerRecord<String,String> record =
                new ProducerRecord<>(topicName, key, value);

        final var metadata = kafkaProducer.send(record);

        var timeStarted = System.currentTimeMillis();

        do {
            try {
                Thread.sleep(1);
            }
            catch (Exception exc) { }

            if(metadata.isDone()) return true;
            else if(metadata.isCancelled()) break;
        } while(System.currentTimeMillis() < (timeStarted + 2_000) );

        return false;
    }

}
