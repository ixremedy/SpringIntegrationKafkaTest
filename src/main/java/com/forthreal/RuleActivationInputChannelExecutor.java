package com.forthreal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static java.lang.Thread.currentThread;

@Service
public class RuleActivationInputChannelExecutor implements TaskExecutor
{
    private final Logger logger = LogManager.getLogger(RuleActivationInputChannelExecutor.class);
    private static final ExecutorService executorService;

    static {
        executorService = Executors.newFixedThreadPool(10);
    }

    @Override
    public void execute(Runnable task) {
        //logger.info("{} Executing task", currentThread().getStackTrace()[1].getMethodName());
        executorService.execute(task);
    }
}
