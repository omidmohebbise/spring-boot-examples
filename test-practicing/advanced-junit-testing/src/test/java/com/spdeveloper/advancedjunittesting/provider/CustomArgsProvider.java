package com.spdeveloper.advancedjunittesting.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CustomArgsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.arguments("omid","mohebbi"),
                Arguments.arguments("ali","mohebbi"),
                Arguments.arguments("ehsan","ahmadi")
        );
    }
}
