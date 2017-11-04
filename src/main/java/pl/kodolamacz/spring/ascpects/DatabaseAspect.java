package pl.kodolamacz.spring.ascpects;

import org.aspectj.lang.JoinPoint;

/**
 * Created by acacko on 04.11.17
 */
public class DatabaseAspect {

    public void before(JoinPoint joinPoint) {
        System.out.println("Before save");
    }

    public void after(JoinPoint joinPoint) {

    }


}
