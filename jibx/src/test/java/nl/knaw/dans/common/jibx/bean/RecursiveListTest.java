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
package nl.knaw.dans.common.jibx.bean;

import static org.junit.Assert.assertEquals;
import nl.knaw.dans.common.jibx.JiBXObjectFactory;
import nl.knaw.dans.common.lang.repo.bean.RecursiveEntry;
import nl.knaw.dans.common.lang.test.Tester;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecursiveListTest
{

    private static final Logger logger = LoggerFactory.getLogger(RecursiveListTest.class);

    private boolean verbose = Tester.isVerbose();

    @Test
    public void serializeDeserializeEmpty() throws Exception
    {
        JiBXRecursiveList rl = new JiBXRecursiveList("foo");
        if (verbose)
            logger.debug("\n" + rl.asXMLString(4) + "\n");
        JiBXRecursiveList rl2 = (JiBXRecursiveList) JiBXObjectFactory.unmarshal(JiBXRecursiveList.class, rl.asObjectXML());
        assertEquals(rl.asXMLString(), rl2.asXMLString());
    }

    @Test
    public void serializeDeserializeFull() throws Exception
    {
        JiBXRecursiveList rl = new JiBXRecursiveList("foo");

        JiBXRecursiveEntry entry = new JiBXRecursiveEntry();
        entry.setKey("ABC");
        entry.setName("Name");
        entry.setShortname("shortname");
        entry.setOrdinal(1);

        JiBXRecursiveEntry a = new JiBXRecursiveEntry();
        a.setKey("a");
        a.setName("aName");
        a.setShortname("aShortname");
        a.setOrdinal(2);

        entry.add(a);

        rl.add(entry);

        JiBXRecursiveEntry b = new JiBXRecursiveEntry();
        b.setKey("bABC");
        b.setName("bName");
        b.setShortname("bshortname");
        b.setOrdinal(3);

        rl.add(b);

        //if (verbose)
        logger.debug("\n" + rl.asXMLString(4) + "\n");
        JiBXRecursiveList rl2 = (JiBXRecursiveList) JiBXObjectFactory.unmarshal(JiBXRecursiveList.class, rl.asObjectXML());
        assertEquals(rl.asXMLString(), rl2.asXMLString());

        RecursiveEntry af = rl.get("a");
        assertEquals(a, af);
    }

}
