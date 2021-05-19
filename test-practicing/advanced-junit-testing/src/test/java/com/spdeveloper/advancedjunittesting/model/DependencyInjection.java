package com.spdeveloper.advancedjunittesting.model;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class DependencyInjection {

    @Test
    public void injectTestInfo(TestInfo testInfo){
        System.out.println("Test info: " + testInfo.toString());
        //The result must be like this
        //Test info: DefaultTestInfo [displayName = 'injectTestInfo(TestInfo)', tags = [], testClass = class com.spdeveloper.advancedjunittesting.model.DependencyInjection, testMethod = public void com.spdeveloper.advancedjunittesting.model.DependencyInjection.injectTestInfo(org.junit.jupiter.api.TestInfo)]
    }


    @RepeatedTest(value = 4)
    void injectRepeatedTestInfo(RepetitionInfo repetitionInfo){
        System.out.println(repetitionInfo.getCurrentRepetition());
    }
}
