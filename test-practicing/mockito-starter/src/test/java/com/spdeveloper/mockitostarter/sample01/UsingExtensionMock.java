package com.spdeveloper.mockitostarter.sample01;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class UsingExtensionMock {
    @Mock
    Map<String,Object> mockedMap;
    @Test
    void testMock(){
        mockedMap.put("key1","value1");
    }
}
