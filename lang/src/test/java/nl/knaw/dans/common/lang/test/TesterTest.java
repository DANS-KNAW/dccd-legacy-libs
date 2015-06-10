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
package nl.knaw.dans.common.lang.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import nl.knaw.dans.common.lang.ResourceNotFoundException;

import org.junit.Test;

public class TesterTest
{

    @Test
    public void getString()
    {
        assertEquals("testing nl.knaw.dans.common.lang", Tester.getString(Tester.KEY_TEST));
    }

    @Test
    public void getResource()
    {
        assertNull(Tester.getResource("this/resource/does/not/exist"));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void getNoneExistingFile() throws ResourceNotFoundException
    {
        Tester.getFile("this/file/does/not/exist");
    }

    @Test
    public void getFile() throws ResourceNotFoundException
    {
        assertTrue(Tester.getFile("test.properties").exists());
    }

}
