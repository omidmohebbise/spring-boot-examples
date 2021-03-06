package com.spdeveloper.mockitostarter.sample01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

public class AnnotationMocks {
    @Mock
    Map<String,Object> mockedMap;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMock(){
        mockedMap.put("key1","value1");
        //assertEquals(mockedMap.size(),1);
    }

}
