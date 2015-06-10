/*******************************************************************************
 * Copyright 2015 DANS - Data Archiving and Networked Services
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package nl.knaw.dans.common.lang.mail;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Test;

public class MailComposerTest
{

    @Test
    public void getRawString() throws Exception
    {
        MailComposer composer = new MailComposer();
        InputStream inStream = new FileInputStream("src/test/resources/test-files/mail/test-mail_01.txt");
        String raw = composer.composeMessage(inStream, false);
        assertEquals("Hallo,\n\nDit is een mailbericht.\n\ngroeten,\nde afzender", raw);
    }

    @Test
    public void getValue() throws Exception
    {
        TestObject to = new TestObject();
        MailComposer composer = new MailComposer(to);

        String placeHolder = "TestObject.getThis";
        assertEquals("something", composer.getValue(placeHolder));

        placeHolder = "TestObject.getThat";
        assertEquals("another thing", composer.getValue(placeHolder));

        placeHolder = "TestObject.getInt";
        assertEquals("6", composer.getValue(placeHolder));

        placeHolder = "TestObject.getBoolean";
        assertEquals("true", composer.getValue(placeHolder));

        placeHolder = "TestObject.getInteger";
        assertEquals("42", composer.getValue(placeHolder));

        placeHolder = "TestObject.getNull";
        assertEquals("", composer.getValue(placeHolder));
    }

    @Test(expected = MailComposerException.class)
    public void getValueWithWrongObject() throws Exception
    {
        TestObject to = new TestObject();
        MailComposer composer = new MailComposer(to);

        String placeHolder = "FooBar.getThis";
        composer.getValue(placeHolder);
    }

    @Test(expected = MailComposerException.class)
    public void getValueWithWrongMethod() throws Exception
    {
        TestObject to = new TestObject();
        MailComposer composer = new MailComposer(to);

        String placeHolder = "TestObject.getFooBar";
        composer.getValue(placeHolder);
    }

    @Test
    public void compose() throws Exception
    {
        TestObject to = new TestObject();
        MailComposer composer = new MailComposer(to);
        InputStream inStream = new FileInputStream("src/test/resources/test-files/mail/test-mail_02.txt");
        String message = composer.compose(inStream);
        assertEquals("something ought to be done.\n\nAnd there is another thing: 42 > 6.\n\nAnd that's true!\n\ngreetings", message);
        //System.out.println(message);
    }

    static class TestObject
    {
        public String getThis()
        {
            return "something";
        }

        public String getThat()
        {
            return "another thing";
        }

        public int getInt()
        {
            return 6;
        }

        public boolean getBoolean()
        {
            return true;
        }

        public Integer getInteger()
        {
            return new Integer(42);
        }

        public Object getNull()
        {
            return null;
        }
    }

}
