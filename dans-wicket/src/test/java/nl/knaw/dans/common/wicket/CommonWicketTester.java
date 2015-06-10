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
package nl.knaw.dans.common.wicket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.util.tester.WicketTester;
import org.apache.wicket.util.tester.WicketTesterHelper;

public class CommonWicketTester extends WicketTester
{
    private static final int TIME_FIELD_LENGTH = 24;

    public CommonWicketTester(final CommonWicketApplication application)
    {
        super(application, null);
    }

    /**
     * Asserts Easy error-level feedback messages.  This method functions the same as 
     * 'assertErrorMessages' in 'WicketTester', but it strips off the time value from 
     * the beginning of the error message.
     * 
     * @param expectedErrorMessages
     *            expected error messages
     */
    public void assertEasyErrorMessages(String[] expectedErrorMessages)
    {
        List<Serializable> actualMessages = getMessages(FeedbackMessage.ERROR);
        List<Serializable> msgs = new ArrayList<Serializable>();
        for (Iterator<Serializable> iterator = actualMessages.iterator(); iterator.hasNext();)
        {
            msgs.add(iterator.next().toString().substring(TIME_FIELD_LENGTH));
        }
        WicketTesterHelper.assertEquals(Arrays.asList(expectedErrorMessages), msgs);
    }
}
