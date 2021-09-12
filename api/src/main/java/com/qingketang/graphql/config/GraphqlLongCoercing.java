package com.qingketang.graphql.config;

import graphql.language.IntValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import org.jetbrains.annotations.NotNull;
import graphql.language.Value;
import static graphql.Assert.assertNotNull;

import java.math.BigDecimal;
import java.math.BigInteger;

public class GraphqlLongCoercing implements Coercing<Long, Long> {

    private static final BigInteger LONG_MAX = BigInteger.valueOf(Long.MAX_VALUE);
    private static final BigInteger LONG_MIN = BigInteger.valueOf(Long.MIN_VALUE);

    private Long convertImpl(Object input) {
        if (input instanceof Long) {
            return (Long) input;
        } else if (input instanceof Number || input instanceof String) {
            BigDecimal value;
            try {
                value = new BigDecimal(input.toString());
            } catch (NumberFormatException e) {
                return null;
            }
            try {
                return value.longValueExact();
            } catch (ArithmeticException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public Long serialize(@NotNull Object input) throws CoercingSerializeException {
        Long result = convertImpl(input);
        if (result == null) {
            throw new CoercingSerializeException(
                    "Expected type 'Long' but was '" + typeName(input) + "'."
            );
        }
        return result;
    }

    @Override
    public @NotNull Long parseValue(@NotNull Object input) throws CoercingParseValueException {
        Long result = convertImpl(input);
        if (result == null) {
            throw new CoercingParseValueException(
                    "Expected type 'Long' but was '" + typeName(input) + "'."
            );
        }
        return result;
    }

    @Override
    public @NotNull Long parseLiteral(@NotNull Object input) throws CoercingParseLiteralException {
        if (!(input instanceof IntValue)) {
            throw new CoercingParseLiteralException(
                    "Expected AST type 'IntValue' but was '" + typeName(input) + "'."
            );
        }
        BigInteger value = ((IntValue) input).getValue();
        if (value.compareTo(LONG_MIN) < 0 || value.compareTo(LONG_MAX) > 0) {
            throw new CoercingParseLiteralException(
                    "Expected value to be in the Integer range but it was '" + value.toString() + "'"
            );
        }
        return value.longValue();
    }

    @Override
    public @NotNull Value valueToLiteral(@NotNull Object input) {
        Long result = assertNotNull(convertImpl(input));
        return IntValue.newIntValue(BigInteger.valueOf(result)).build();
    }

    static String typeName(Object input) {
        if (input == null) {
            return "null";
        }

        return input.getClass().getSimpleName();
    }
}
