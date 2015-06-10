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
package nl.knaw.dans.common.search.bean;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import nl.knaw.dans.common.lang.search.bean.StringListCollapserConverter;

import org.junit.Test;

@SuppressWarnings("serial")
public class StringListCollapserConverterTest
{
    // Note that inside the Java string literals, we need to escape the '\' as well
    final static String testEmptyString = "";
    final static String testStringPart1 = "This is";
    final static String testStringPart2 = " a string";
    final static String testSingleItemString = testStringPart1 + testStringPart2;//"This is a string";
    final static String testDoubleItemString = testStringPart1 + "," + testStringPart2;//"This is, a string";
    final static String testSingleItemStringEcsaped = testStringPart1 + "\\," + testStringPart2;//"This is\\, a string";

    final static String testDoubleEmptyItemString = ",";

    final static List<String> testSingleItemStringList = new ArrayList<String>()
    {
        {
            add(testSingleItemString);
        }
    };

    final static List<String> testDoubleItemStringList = new ArrayList<String>()
    {
        {
            add(testStringPart1);
            add(testStringPart2);
        }
    };

    final static List<String> testSingleItemStringEscapedList = new ArrayList<String>()
    {
        {
            add(testDoubleItemString);
        }
    };

    @Test
    public void testConvertionFromFieldValue() throws Exception
    {
        StringListCollapserConverter converter = new StringListCollapserConverter();
        List<String> fromFieldValue;

        fromFieldValue = converter.fromFieldValue(testEmptyString);
        assertTrue(fromFieldValue.size() == 1);

        fromFieldValue = converter.fromFieldValue(testSingleItemString);
        assertTrue(fromFieldValue.size() == 1);
        assertTrue(fromFieldValue.get(0).equals(testSingleItemString));

        fromFieldValue = converter.fromFieldValue(testDoubleItemString);
        assertTrue(fromFieldValue.size() == 2);
        assertTrue(fromFieldValue.get(0).equals(testStringPart1));
        assertTrue(fromFieldValue.get(1).equals(testStringPart2));

        fromFieldValue = converter.fromFieldValue(testSingleItemStringEcsaped);
        assertTrue(fromFieldValue.size() == 1);
        assertTrue(fromFieldValue.get(0).equals(testDoubleItemString));

        fromFieldValue = converter.fromFieldValue(testDoubleEmptyItemString);
        assertTrue(fromFieldValue.size() == 2);

        // TODO test if empty strings should be an list item!

        // TODO test the un-escaping of '\'

    }

    @Test
    public void testConvertionToFieldValue() throws Exception
    {
        StringListCollapserConverter converter = new StringListCollapserConverter();

        String fieldValue;
        fieldValue = (String) converter.toFieldValue(testDoubleItemStringList);
        assertTrue(fieldValue.equals(testDoubleItemString));

        fieldValue = (String) converter.toFieldValue(testSingleItemStringList);
        assertTrue(fieldValue.equals(testSingleItemString));

        // Now the ',' should be escaped
        fieldValue = (String) converter.toFieldValue(testSingleItemStringEscapedList);
        assertTrue(fieldValue.equals(testSingleItemStringEcsaped));

        // TODO test the escaping of '\'
    }

    // TODO test SearchBeanConverterException
}
