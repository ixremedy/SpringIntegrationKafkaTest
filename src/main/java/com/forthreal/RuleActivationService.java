package com.forthreal;

import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class RuleActivationService
{
    public void ruleActivationInputMessage(Optional<String> opPayload)
    {
        opPayload.ifPresent(System.out::println);
    }
}
