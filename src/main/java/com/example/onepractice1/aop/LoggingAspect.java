package com.example.onepractice1.aop;

import com.example.onepractice1.models.Client;
import com.example.onepractice1.models.Post;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution (* com.example.onepractice1.service.AddressService.*(..))")
    private void allMethodsFromAddressService() {
    }

    @Pointcut("execution (* com.example.onepractice1.service.ClientService.save*())")
    private void allSaveMethodsFromClientService() {
    }

    @Pointcut("execution (* com.example.onepractice1.service.ClientService.*(..))")
    private void allMethodsFromClientService() {
    }

    @Pointcut("execution (* com.example.onepractice1.service.PostService.find*())")
    private void allFindMethodsFromPostService() {
    }

    @Pointcut("execution (* com.example.onepractice1.service.PostService.save*())")
    private void allSaveMethodsFromPostService() {
    }

    @Before("allFindMethodsFromPostService() || allSaveMethodsFromPostService()")
    public void beforePostServiceLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("beforePostServiceLoggingAdvice" + " methodSignature " + methodSignature + ", "
                + methodSignature.getMethod() + ", " + methodSignature.getReturnType()
                + ", " + methodSignature.getName());
        System.out.println("----------------------------------------------");
    }

    @Around("allSaveMethodsFromClientService()")
    public Object aroundClientServiceAllMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Trying to save a client to the database");

        Object object = proceedingJoinPoint.proceed();

        System.out.println("saved the client to the database");
        System.out.println("----------------------------------------------");

        return object;
    }

    @AfterReturning(value = "allFindMethodsFromPostService()", returning = "posts")
    public void afterReturningAllFindMethodsFromPostServiceAdvice(JoinPoint joinPoint, List<Post> posts) {
        Post lastPost = posts.get(posts.size() - 1);
        lastPost.setPostStatus("DELIVERED");

        System.out.println("afterReturningAllFindMethodsFromPostService");
        System.out.println("----------------------------------------------\n");
    }

    @AfterThrowing(value = "allMethodsFromAddressService()", throwing = "e")
    public void afterThrowingAllMethodsFromAddressServiceAdvice(JoinPoint joinPoint, Exception e) {
        System.out.println("Method clientName: " + joinPoint.getSignature().getName() + ", exception: " + e);
        System.out.println("----------------------------------------------");
    }

    @After("allMethodsFromClientService() && !allSaveMethodsFromPostService())")
    public void afterAllMethodsFromClientServiceExceptAllSaveMethodsAdvice() {
        System.out.println("afterAllMethodsFromClientServiceExceptAllSaveMethodsAdvice");
        System.out.println("----------------------------------------------");
    }

}
