package com.forthreal;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = ServiceConfiguration.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestRuleProcessing {
    @Lazy @Autowired
    private SampleProducer sampleProducer;

    @Test
    @Order(0)
    @DisplayName("check if we can submit a kafka message - not failing data")
    public void sendSimplePositiveMessageTest()
    {
        assertTrue(sampleProducer.sendMessageSimple("incomingRule","type", "{\"testType\": \"normalState\"}"));
    }

    @Test
    @Order(1)
    @DisplayName("check if we can submit a kafka message - failing data")
    public void sendSimpleNegativeMessageTest()
    {
        assertTrue(sampleProducer.sendMessageSimple("incomingRule","type", "{\"testType\": \"wrongState\"}"));
    }

}
