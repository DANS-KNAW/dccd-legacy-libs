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
/**
 *
 */
package nl.knaw.dans.common.wicket.util;

import junit.framework.TestCase;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.util.tester.WicketTester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tests for the Require one validator.
 *
 * @author Herman Suijs
 */
public class RequireOneValidatorTest extends TestCase
{
    /**
     * Logger for this class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RequireOneValidatorTest.class);

    /**
     * Wicket application tester for this class.
     */
    @SuppressWarnings("unused")
    private WicketTester tester;

    /**
     * Set up for tests.
     */
    @Override
    public void setUp()
    {
        this.tester = new WicketTester();
    }

    /**
     * Test without parameters.
     */
    public void testNoParameters()
    {
        try
        {
            RequireOneValidator validator = new RequireOneValidator();
            LOGGER.info("Created validator: " + validator);
            fail("Validator should not be created without parameters.");
        }
        catch (IllegalArgumentException e)
        {
            LOGGER.info("Proper exception caught.");
        }
    }

    /**
     * Test with one parameter.
     */
    public void testOneParameter()
    {
        try
        {
            TextField textField = new TextField("testId");
            final RequireOneValidator validator = new RequireOneValidator(textField);
            LOGGER.info("Created validator: " + validator);
            fail("Validator should not be created with 1 parameter (at least 2)");
        }
        catch (IllegalArgumentException e)
        {
            LOGGER.info("Proper exception caught.");
        }
    }

    /**
     * Test with null as parameter.
     */
    public void testNullParameter()
    {
        try
        {
            final RequireOneValidator validator = new RequireOneValidator(new TextField("testId"), null);
            LOGGER.info("Created validator: " + validator);
            fail("Validator should not be created with a null as parameters");
        }
        catch (IllegalArgumentException e)
        {
            LOGGER.info("Proper exception caught.");
        }
    }

    public void testTwoParameters()
    {
        try
        {
            final RequireOneValidator validator = new RequireOneValidator(new TextField("testId"), null);
            LOGGER.info("Created validator: " + validator);
            fail("Validator should not be created with a null as parameters");
        }
        catch (IllegalArgumentException e)
        {
            LOGGER.info("Proper exception caught.");
        }
    }
}
