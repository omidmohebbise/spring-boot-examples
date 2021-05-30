package com.spdeveloper.advancedjunittesting.extension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TimingExtension.class)
public class UseExtension {

    @Test
    public void  checkExtension(){
        System.out.println("check extension method body");
    }
}
