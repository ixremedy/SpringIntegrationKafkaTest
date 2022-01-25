package com.forthreal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static java.lang.Thread.currentThread;

@Service
public class RuleActivationService
{
    private Logger logger = LogManager.getLogger(RuleActivationService.class);

    public String ruleActivationInputMessage(String payload) throws AppException {
        if(payload != null)
        {
           logger.info("{} Received message: {}",
                    currentThread().getStackTrace()[1].getMethodName(),
                    payload);

           if(payload.toLowerCase().contains("wrong"))
           {
               throw new AppException("Wrong message received");
           }
           else
           {
               logger.info("{} Sending status: {}", currentThread().getStackTrace()[1].getMethodName());
               return "{\"status\": \"rule activated\"}";
           }
        }

        return null;
    }
}
