/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017-2020 Yegor Bugayenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.cactoos.scalar;

import org.cactoos.Scalar;
import org.hamcrest.core.AllOf;
import org.hamcrest.core.IsEqual;
import org.hamcrest.object.HasToString;
import org.junit.jupiter.api.Test;
import org.llorllale.cactoos.matchers.Assertion;
import org.llorllale.cactoos.matchers.HasValue;

/**
 * Test case for {@link Constant}.
 * @since 0.30
 * @checkstyle JavadocMethodCheck (500 lines)
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
final class ConstantTest {

    @Test
    void returnsGivenValue() {
        final String value = "Hello World";
        new Assertion<>(
            "Must return given value",
            new Constant<>(value),
            new HasValue<>(value)
        ).affirm();
    }

    @Test
    void shouldBeEqualToItself() {
        final Constant<String> constant = new Constant<>("Hello");
        new Assertion<>(
            "Must return same value",
            constant,
            new AllOf<Scalar<?>>(
                new IsEqual<>(new Constant<>("Hello")),
                new IsEqual<>(new ScalarOfSupplier<>(() -> "Hello"))
            )
        ).affirm();
    }

    @Test
    void shoudHaveToString() {
        final Constant<String> constant = new Constant<>("Hello");
        new Assertion<>(
            "Must return same value",
            constant,
            new HasToString<>(
                new IsEqual<>("Hello")
            )
        ).affirm();
    }
}
