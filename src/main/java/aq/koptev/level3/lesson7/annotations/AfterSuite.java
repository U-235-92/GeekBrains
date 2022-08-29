package aq.koptev.level3.lesson7.annotations;

import aq.koptev.level3.lesson7.util.LaunchOrder;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@CallOrder(order = LaunchOrder.AFTER_ALL)
public @interface AfterSuite {
}
