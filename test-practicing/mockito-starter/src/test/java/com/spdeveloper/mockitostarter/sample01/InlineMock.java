package com.spdeveloper.mockitostarter.sample01;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class InlineMock {

    @Test
    void testInlineMock() {
        Map mockMap = mock(Map.class);
        assertEquals(mockMap.size(), 0);
    }
}
