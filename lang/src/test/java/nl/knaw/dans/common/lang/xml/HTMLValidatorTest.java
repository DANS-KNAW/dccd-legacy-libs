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
package nl.knaw.dans.common.lang.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import nl.knaw.dans.common.lang.test.Tester;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HTMLValidatorTest
{

    private static HtmlValidator validator;
    private static final Logger logger = LoggerFactory.getLogger(HTMLValidatorTest.class);

    private boolean verbose = Tester.isVerbose();

    @BeforeClass
    public static void beforeClass()
    {
        validator = new HtmlValidator();
    }

    @Test
    public void tidyPartialHtml()
    {
        String markup = "bla";
        String tidied = validator.tidyPartialHtml(markup);
        if (verbose)
            logger.debug("\n" + tidied + "\n");
        for (String msg : validator.getMessages())
        {
            if (verbose)
                System.out.println(msg);
        }
        assertEquals("bla\n", tidied);
        assertFalse(validator.hasErrors());
        assertFalse(validator.hasWarnings());
    }

    @Test
    public void tidyPartialHtml2()
    {
        String markup = "bla<br>bla<div><div>hop</div>bla\n<hr/>";
        String tidied = validator.tidyPartialHtml(markup, false);
        if (verbose)
            logger.debug("\n" + tidied + "\n");
        for (String msg : validator.getWarningMessages())
        {
            if (verbose)
                System.out.println(msg);
        }
        assertFalse(validator.hasErrors());
        assertTrue(validator.hasWarnings());
        assertEquals(2, validator.warningCount());
    }

    @Test
    public void tidyPartialHtml3()
    {
        String markup = "<div foo</div>bla<foo>bar</foo>";
        String tidied = validator.tidyPartialHtml(markup, false);
        //if (verbose)
        {
            logger.debug("\n" + tidied + "\n");

            for (String msg : validator.getErrorMessages())
            {
                System.out.println(msg);
            }
            for (String msg : validator.getWarningMessages())
            {
                System.out.println(msg);
            }
        }

        assertTrue(validator.hasErrors());
        assertTrue(validator.hasWarnings());
        assertEquals(4, validator.warningCount());
        assertEquals(2, validator.errorCount());
    }

    @Test
    public void tidyPartialHtml4()
    {
        String markup = "<DIV>foo</DIV><div>bar</DIV>";
        String tidied = validator.tidyPartialHtml(markup, true);
        if (verbose)
        {
            logger.debug("\n" + tidied + "\n");
            for (String msg : validator.getWarningMessages())
            {
                System.out.println(msg);
            }
        }
        assertFalse(validator.hasErrors());
        assertFalse(validator.hasWarnings());
        assertFalse(tidied.contains("DIV"));
    }

}
