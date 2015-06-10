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
package nl.knaw.dans.common.lang.os;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class LinuxOsStrategyTest
{

    @Test
    public void chmodLegal() throws Exception
    {
        LinuxOsStrategy los = new LinuxOsStrategy();
        File file = File.createTempFile("ostest", null);
        int exitValue = los.setAllRWX(file, System.out, System.err);
        assertEquals(0, exitValue);
        assertTrue(file.delete());
    }

    @Test
    public void chmodIllegal() throws Exception
    {
        LinuxOsStrategy los = new LinuxOsStrategy();
        File file = new File("/var/local/ostest");
        int exitValue = los.setAllRWX(file, System.out, System.err);
        assertFalse(exitValue == 0);
    }

}
