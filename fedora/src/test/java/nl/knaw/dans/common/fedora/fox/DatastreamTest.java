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
package nl.knaw.dans.common.fedora.fox;

import static org.junit.Assert.assertEquals;
import nl.knaw.dans.common.jibx.JiBXObjectFactory;
import nl.knaw.dans.common.lang.test.Tester;
import nl.knaw.dans.common.lang.xml.XMLException;
import nl.knaw.dans.common.lang.xml.XMLSerializationException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatastreamTest
{
    private static final Logger logger = LoggerFactory.getLogger(DatastreamTest.class);

    private boolean printXml = Tester.isVerbose();

    @Test
    public void testNextVersionId() throws XMLSerializationException
    {
        Datastream ds = new Datastream("DC", ControlGroup.X);
        assertEquals("DC.0", ds.nextVersionId());
        ds.addDatastreamVersion("BlaBla", null);
        assertEquals("DC.0", ds.nextVersionId());
        ds.addDatastreamVersion(ds.nextVersionId(), null);
        assertEquals("DC.1", ds.nextVersionId());
        ds.addDatastreamVersion("DC.100", null);
        assertEquals("DC.101", ds.nextVersionId());

        if (printXml)
            logger.debug("\n" + ds.asXMLString(4) + '\n');
    }

    @Test
    public void serializeDeserializeEmpty() throws XMLException
    {
        Datastream ds = new Datastream("FOO", ControlGroup.B);
        if (printXml)
            logger.debug("\n" + ds.asXMLString(4) + '\n');

        Datastream ds2 = (Datastream) JiBXObjectFactory.unmarshal(Datastream.class, ds.asObjectXML());
        assertEquals(ds.asXMLString(), ds2.asXMLString());
    }

}
