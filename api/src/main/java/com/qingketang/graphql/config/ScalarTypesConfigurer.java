package com.qingketang.graphql.config;

import graphql.schema.GraphQLScalarType;
import graphql.schema.idl.RuntimeWiring;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class ScalarTypesConfigurer implements RuntimeWiringConfigurer {
    @Override
    public void configure(RuntimeWiring.Builder builder) {
        var longType = GraphQLScalarType.newScalar()
                .name("Long")
                .description("Build-in Long")
                .coercing(new GraphqlLongCoercing())
                .build();

        builder.scalar(longType);
    }
}
