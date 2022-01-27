package com.forthreal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import static java.lang.Thread.currentThread;

@Service
public class RuleErrorService
{
    private Logger logger = LogManager.getLogger(RuleErrorService.class);

    public String ruleActivationErrorMessage(String error)
    {
        logger.info("{} Received error message: {}",
                currentThread().getStackTrace()[1].getMethodName(),
                error);

        return "{\"errorMessage\": \"wrong content\"}";
    }
}
