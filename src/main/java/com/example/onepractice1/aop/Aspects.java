package com.example.onepractice1.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aspects {
    private static final Logger log = LoggerFactory.getLogger(Aspects.class);

    @Pointcut("execution(* com.example.onepractice1.controller.PostController.*(..))")
    private void allMethodsFromPostController() { }

    @Pointcut("execution(* com.example.onepractice1.controller.ClientController.*(..))")
    private void allMethodsFromClientController() { }

    @Pointcut("execution(* com.example.onepractice1.controller.AddressController.*(..))")
    private void allMethodsFromAddressController() { }

    @Before("allMethodsFromPostController() || allMethodsFromClientController() || allMethodsFromAddressController()")
    public void endpointBefore(JoinPoint p) {
        if (log.isTraceEnabled()) {
            log.trace(p.getTarget().getClass().getSimpleName() + " " + p.getSignature().getName() + " START");
            Object[] signatureArgs = p.getArgs();


            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            try {
                if (signatureArgs[0] != null) {
                    log.trace("\nRequest object: \n" + mapper.writeValueAsString(signatureArgs[0]));
                }
            } catch (JsonProcessingException e) {
            }
        }
    }

    @AfterReturning(value = ("allMethodsFromPostController() || allMethodsFromClientController() || allMethodsFromAddressController()")
            , returning = "returnValue")
    public void endpointAfterReturning(JoinPoint p, Object returnValue) {
        if (log.isTraceEnabled()) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            try {
                log.trace("\nResponse object: \n" + mapper.writeValueAsString(returnValue));
            } catch (JsonProcessingException e) {
                System.out.println(e.getMessage());
            }
            log.trace(p.getTarget().getClass().getSimpleName() + " " + p.getSignature().getName() + " END");
        }
    }

    @AfterThrowing(value = ("allMethodsFromPostController() || allMethodsFromClientController() || allMethodsFromAddressController()"), throwing = "e")
    public void endpointAfterThrowing(JoinPoint p, Exception e) {
        if (log.isTraceEnabled()) {
            System.out.println(e.getMessage());

            e.printStackTrace();


            log.error(p.getTarget().getClass().getSimpleName() + " " + p.getSignature().getName() + " " + e.getMessage());
        }
    }
}
