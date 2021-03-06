/*
 * Copyright 2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package powermock.examples.suppress.constructor;

import org.junit.Test;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertNull;

/**
 * Example that demonstrates PowerMock's ability to suppress an objects own
 * constructor.
 */
public class ExampleWithEvilConstructorTest {

	@Test
	public void testSuppressOwnConstructor() throws Exception {
		ExampleWithEvilConstructor tested = Whitebox.newInstance(ExampleWithEvilConstructor.class);
		assertNull(tested.getMessage());
	}

	@Test(expected = UnsatisfiedLinkError.class)
	public void testNotSuppressOwnConstructor() throws Exception {
		final String message = "myMessage";
		new ExampleWithEvilConstructor(message);
	}
}
