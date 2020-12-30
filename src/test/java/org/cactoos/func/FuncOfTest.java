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
package org.cactoos.func;

import java.util.concurrent.atomic.AtomicBoolean;
import org.cactoos.proc.ProcOf;
import org.cactoos.scalar.Constant;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;
import org.llorllale.cactoos.matchers.Assertion;

/**
 * Test case for {@link FuncOf}.
 *
 * @since 0.20
 * @checkstyle JavadocMethodCheck (500 lines)
 */
final class FuncOfTest {

    @Test
    void convertsProcIntoFunc() throws Exception {
        final AtomicBoolean done = new AtomicBoolean(false);
        new Assertion<>(
            "Must convert procedure into function",
            new FuncOf<String, Boolean>(
                new ProcOf<>(
                    input -> {
                        done.set(true);
                    }
                ),
                true
            ).apply("hello world"),
            new IsEqual<>(done.get())
        ).affirm();
    }

    @Test
    void convertsScalarIntoFunc() throws Exception {
        new Assertion<>(
            "Result of func must be equal to the original value",
            new FuncOf<>(new Constant<>(1)).apply(new Object()),
            new IsEqual<>(1)
        ).affirm();
    }
}
