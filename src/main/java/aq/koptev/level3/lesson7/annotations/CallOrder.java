package aq.koptev.level3.lesson7.annotations;

import aq.koptev.level3.lesson7.util.LaunchOrder;

public @interface CallOrder {
    LaunchOrder order() default LaunchOrder.QUEUE;
}
