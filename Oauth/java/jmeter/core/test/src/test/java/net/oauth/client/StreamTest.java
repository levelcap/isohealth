/*
 * Copyright 2008 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.oauth.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;

import junit.framework.TestCase;
import net.oauth.OAuthMessage;

public class StreamTest extends TestCase
{
    public void testExcerptInputStream() throws Exception
    {
        ExcerptInputStream input = new ExcerptInputStream(new ByteArrayInputStream("abcdef"
                .getBytes()));
        assertEquals("abcdef", new String(input.getExcerpt()));
        assertEquals('a', input.read());
        byte[] actual = new byte[3];
        assertEquals(3, input.read(actual));
        assertEquals('b', actual[0]);
        assertEquals('c', actual[1]);
        assertEquals('d', actual[2]);
        assertEquals(1, input.read(actual, 1, 1));
        assertEquals('e', actual[1]);
        assertEquals(1, input.read(actual, 1, 2));
        assertEquals('f', actual[1]);
        assertEquals(-1, input.read());
        byte[] expected = new byte[] { -128, -1, 0, 1, 127 };
        for (int offset = 0; offset <= expected.length; ++offset) {
            testExcerpt(expected, offset);
        }
        input = new ExcerptInputStream(new ByteArrayInputStream(expected));
        actual = new byte[6];
        actual[0] = (byte) input.read();
        actual[1] = (byte) input.read();
        assertEquals(3, input.read(actual, 2, 4));
        for (int i = 0; i < expected.length; ++i) {
            assertEquals(expected[i], actual[i]);
        }
        expected = new byte[1024 + ExcerptInputStream.ELLIPSIS.length];
        for (int i = 0; i < 1024; ++i) {
            expected[i] = (byte) i;
        }
        System.arraycopy(ExcerptInputStream.ELLIPSIS, 0, expected, 1024,
                ExcerptInputStream.ELLIPSIS.length);
        for (int offset = 0; offset <= expected.length; ++offset) {
            testExcerpt(expected, offset);
        }
        input = new ExcerptInputStream(new ByteArrayInputStream(expected));
        while (input.read(actual) > 0)
            ;
        actual = input.getExcerpt();
        assertEqual(expected, actual);
    }

    public void testLongMessage() throws IOException {
        byte[] original = new byte[2048];
        ByteArrayInputStream bais = new ByteArrayInputStream(original);
        ExcerptInputStream eis = new ExcerptInputStream(bais);
        byte[] excerpt = eis.getExcerpt();
        byte[] expected = new byte[1028];
        System.arraycopy(ExcerptInputStream.ELLIPSIS, 0, expected, 1024, ExcerptInputStream.ELLIPSIS.length);
        assertEqual(expected, excerpt);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[8192];
        int read;
        while ((read = eis.read(buffer, 0, buffer.length)) != -1) {
            baos.write(buffer, 0, read);
        }
        assertEqual(original, baos.toByteArray());
    }

    private void testExcerpt(byte[] expected, int offset) throws IOException
    {
        byte[] actual = new byte[expected.length];
        ExcerptInputStream input = new ExcerptInputStream(new ByteArrayInputStream(expected));
        if (offset > 0) {
            input.read(actual, 0, offset);
        }
        assertEqual(expected, input.getExcerpt());
        if (offset < actual.length) {
            input.read(actual, offset, actual.length - offset);
        }
        assertEqual(expected, actual);
    }

    private static void assertEqual(byte[] expected, byte[] actual)
    {
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; ++i) {
            assertEquals("[" + i + "]", expected[i], actual[i]);
        }
    }

    static void assertEqual(String message, byte[] expected, byte[] actual)
    {
        assertEquals(message, expected.length, actual.length);
        for (int i = 0; i < expected.length; ++i) {
            assertEquals(message + "[" + i + "]", expected[i], actual[i]);
        }
    }

    public void testReadBodyAsString() throws Exception
    {
        String expected = "Hello!";
        OneShotMessage message = new OneShotMessage(expected);
        assertSame(message.shot, message.getBodyAsStream());
        assertEquals(expected, message.readBodyAsString());
        assertSame(message.shot, message.getBodyAsStream());

        message = new OneShotMessage(expected);
        assertEquals(expected, message.readBodyAsString());
        assertSame(message.shot, message.getBodyAsStream());
        assertEquals(-1, message.getBodyAsStream().read());
        assertEquals("", message.readBodyAsString());
    }

    private static class OneShotMessage extends OAuthMessage
    {
        OneShotMessage(String body)
        {
            super(null, null, null);
            shot = new ByteArrayInputStream(body.getBytes());
        }

        final InputStream shot;

        @Override
        public InputStream getBodyAsStream() throws IOException
        {
            return shot;
        }
    }
}
