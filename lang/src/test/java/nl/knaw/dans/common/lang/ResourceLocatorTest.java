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
package nl.knaw.dans.common.lang;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;
import java.util.Locale;

import org.junit.Test;

public class ResourceLocatorTest
{

    @Test
    public void getLocaleSpecificURL()
    {
        URL url = ResourceLocator.getURL("test-files/resourceLocator/resource/x", null, "txt");
        assertTrue(url.toString().endsWith("test-files/resourceLocator/resource/x.txt"));

        Locale locale = new Locale("nl");
        url = ResourceLocator.getURL("test-files/resourceLocator/resource/x", locale, "txt");
        assertTrue(url.toString().endsWith("test-files/resourceLocator/resource/x_nl.txt"));

        locale = new Locale("nl", "NL");
        url = ResourceLocator.getURL("test-files/resourceLocator/resource/x", locale, "txt");
        assertTrue(url.toString().endsWith("test-files/resourceLocator/resource/x_nl_NL.txt"));

        locale = new Locale("nl", "FR");
        url = ResourceLocator.getURL("test-files/resourceLocator/resource/x", locale, "txt");
        assertTrue(url.toString().endsWith("test-files/resourceLocator/resource/x_nl.txt"));

        locale = Locale.US;
        url = ResourceLocator.getURL("test-files/resourceLocator/resource/x", locale, "txt");
        assertTrue(url.toString().endsWith("test-files/resourceLocator/resource/x.txt"));

        url = ResourceLocator.getURL("test-files/resourceLocator/resource/y", locale, "txt");
        assertTrue(url.toString().endsWith("test-files/resourceLocator/resource/y.txt"));

        url = ResourceLocator.getURL("test-files/resourceLocator/resource/z", locale, "txt");
        assertNull(url);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void getFile1() throws ResourceNotFoundException
    {
        ResourceLocator.getFile("this/file/does/not/exist");
    }

    @Test(expected = ResourceNotFoundException.class)
    public void getFile2() throws ResourceNotFoundException
    {
        ResourceLocator.getFile("test-files/resourceLocator/resource/x");
    }

    @Test
    public void getFile3() throws ResourceNotFoundException
    {
        File file = ResourceLocator.getFile("test-files/resourceLocator/resource/x.txt");
        assertTrue(file.exists());
    }

    @Test
    public void getLocaleSpecificFile() throws ResourceNotFoundException
    {
        Locale locale = new Locale("nl");
        File file = ResourceLocator.getFile("test-files/resourceLocator/resource/x", locale, "txt");
        assertTrue(file.exists());
        assertEquals("x_nl.txt", file.getName());
    }

}
