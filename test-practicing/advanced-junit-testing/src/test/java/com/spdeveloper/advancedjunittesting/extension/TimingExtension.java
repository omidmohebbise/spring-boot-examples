package com.spdeveloper.advancedjunittesting.extension;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;

public class TimingExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {
    private static final String START_TIME="start time";

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        getStore(context).put(START_TIME,System.currentTimeMillis());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        Method testMethod = context.getRequiredTestMethod();
        long startTime = (long) getStore(context).remove(START_TIME);
        long duration = System.currentTimeMillis() - startTime;
        System.out.println(testMethod.getName() + "execute duration: " + duration);
    }

    private ExtensionContext.Store getStore(ExtensionContext extensionContext){
        return extensionContext.getStore(ExtensionContext.Namespace.create(getClass(),
                extensionContext.getRequiredTestMethod()));
    }
}
