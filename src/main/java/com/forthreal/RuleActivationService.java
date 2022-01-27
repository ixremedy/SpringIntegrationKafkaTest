package com.forthreal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
