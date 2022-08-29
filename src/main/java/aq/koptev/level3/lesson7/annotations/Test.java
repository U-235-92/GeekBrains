package aq.koptev.level3.lesson7.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@TestLevel(min = 0, max = 10)
@CallOrder
public @interface Test {
    int priority() default 5;
}
