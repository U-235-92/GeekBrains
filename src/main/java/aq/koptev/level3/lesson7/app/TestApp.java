package aq.koptev.level3.lesson7.app;

import aq.koptev.level3.lesson7.annotations.*;
import aq.koptev.level3.lesson7.exception.NoSingleAnnotationException;
import aq.koptev.level3.lesson7.exception.PriorityTestLevelException;
import aq.koptev.level3.lesson7.test.TestDemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestApp {
    private static final Comparator<? super Method> CALL_METHOD_ORDER_COMPARATOR = ((m1, m2) -> {

    });

    private static final Comparator<? super Method> PRIORITY_TEST_COMPARATOR = ((m1, m2) -> {

    });
    private static int countBeforeSuitAnnotation = 0;
    private static int countAfterSuitAnnotation = 0;
    
    public static <T extends Object> void test(Class<?> clazz, T obj) {
        try {
            test0(clazz, obj);
        } catch (PriorityTestLevelException e) {
            e.printStackTrace();
        } catch (NoSingleAnnotationException e) {
            e.printStackTrace();
        }
    }

    public static <T extends Object> void test(String clazz, T obj) {
        Class<?> cl;
        try {
            cl = Class.forName(clazz);
            test0(cl, obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (PriorityTestLevelException e) {
            e.printStackTrace();
        } catch (NoSingleAnnotationException e) {
            e.printStackTrace();
        }
    }

    private static <T extends Object> void test0(Class<?> clazz, T obj) throws PriorityTestLevelException, NoSingleAnnotationException {
        List<Method> methods = new ArrayList<>(Arrays.asList(clazz.getDeclaredMethods()));
        methods.sort(CALL_METHOD_ORDER_COMPARATOR);
        methods.sort(PRIORITY_TEST_COMPARATOR);
        for(Method method : methods) {
            System.out.println(method);
//            handleMethod(method, obj);
        }
    }

    private static <T extends Object> void handleMethod(Method method, T obj) throws NoSingleAnnotationException {
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            if(annotation.annotationType() == BeforeSuite.class) {
                if(isSingleBeforeSuitAnnotation()) {
                    try {
                        handleBeforeSuitAnnotation(method, obj);
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            } else if(annotation.annotationType() == AfterSuite.class) {
                if(isSingleAfterSuitAnnotation()) {
                    try {
                        handleAfterSuitAnnotation(method, obj);
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            } else if(annotation.annotationType() == aq.koptev.level3.lesson7.annotations.Test.class) {
                try {
                    handleTestAnnotation(method, obj);
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (PriorityTestLevelException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean isSingleBeforeSuitAnnotation() throws NoSingleAnnotationException {
        if(++countBeforeSuitAnnotation <= 1) {
            return true;
        }
        throw new NoSingleAnnotationException();
    }

    private static <T extends Object> void handleBeforeSuitAnnotation(Method method, T obj) throws InvocationTargetException, IllegalAccessException {
        method.invoke(obj);
    }

    private static boolean isSingleAfterSuitAnnotation() throws NoSingleAnnotationException {
        if(++countAfterSuitAnnotation <= 1) {
            return true;
        }
        throw new NoSingleAnnotationException();
    }

    private static <T extends Object> void handleAfterSuitAnnotation(Method method, T obj) throws InvocationTargetException, IllegalAccessException {
        method.invoke(obj);
    }

    private static <T extends Object> void handleTestAnnotation(Method method, T obj) throws InvocationTargetException, IllegalAccessException, PriorityTestLevelException {
        TestLevel level = method.getAnnotation(Test.class).annotationType().getAnnotation(TestLevel.class);
        Test test = method.getAnnotation(Test.class);
        if(test.priority() > level.max() || test.priority() < level.min()) {
            throw new PriorityTestLevelException();
        }
        method.invoke(obj);
    }

    public static void main(String[] args) {
        TestDemo triangleTest = new TestDemo();
        TestApp.test(triangleTest.getClass(), triangleTest);
    }
}
