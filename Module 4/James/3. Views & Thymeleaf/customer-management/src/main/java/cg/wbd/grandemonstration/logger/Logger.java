package cg.wbd.grandemonstration.logger;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    @AfterThrowing(pointcut = "execution(public * cg.wbd.grandemonstration.service.CustomerService.*(..))")
    public void log() {
    System.out.println("[CMS] ERROR!");
    }
}
