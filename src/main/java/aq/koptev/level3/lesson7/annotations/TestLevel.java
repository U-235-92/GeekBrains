package aq.koptev.level3.lesson7.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TestLevel {
    int min();
    int max();
}
