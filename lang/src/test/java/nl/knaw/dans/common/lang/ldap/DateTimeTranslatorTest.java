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
package nl.knaw.dans.common.lang.ldap;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.junit.Test;

public class DateTimeTranslatorTest
{

    @Test
    public void fromAndToLdap()
    {
        DateTimeTranslator translator = new DateTimeTranslator();

        String object = "20100222154032Z";
        DateTime dateTime = translator.fromLdap(object);        
        Object ldapValue = translator.toLdap(dateTime);
        assertEquals(object, ldapValue);
    }

}
