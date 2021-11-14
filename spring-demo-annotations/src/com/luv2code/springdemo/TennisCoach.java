package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component()
/*
    -> Spring will automatically register this bean, bean id = "thatSillyCoach"
    -> If we don't specify a component name, it uses default bean id which is lowercase of class name : tennisCoach
    -> We can call it ->  context.getBean("tennisCoach", Coach.class)
*/
public class TennisCoach implements Coach{
    /*
        -> Field Injection : No need constructor and setter injection to inject that private field
        -> A FortuneService implementation directly into this class making use of some Java Technology called Reflection
    */
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public TennisCoach () {
        System.out.println(">> TennisCoach: inside default constructor >>");
    }
/*
    @Autowired

        -> configure dependency injection with @Autowired annotation
        -> Spring will scan for a component that implements FortuneService
        -> our example HappyFortuneService meets the requirement

    public TennisCoach (FortuneService fortuneService) {
        System.out.println(">> TennisCoach: Constructor injection >> ");
        this.fortuneService = fortuneService;
    }
 */

    /*
    // define a setter method to setter injection
    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println(">> TennisCoach: Setter Injection >> ");
        this.fortuneService = fortuneService;
    }
    */

    @Override
    public String getDailyWorkOut() {
        return "Practice your backend volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
