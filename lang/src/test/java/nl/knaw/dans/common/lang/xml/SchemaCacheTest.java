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

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.validation.Schema;

import nl.knaw.dans.common.lang.test.Tester;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public final class SchemaCacheTest
{

    @Test(expected = SchemaCreationException.class)
    public void testGetSchemaWithNullUrlString() throws SchemaCreationException
    {
        String urlString = null;
        SchemaCache.getSchema(urlString);
    }

    @Test(expected = SchemaCreationException.class)
    public void testGetSchemaWithEmptyUrlString() throws SchemaCreationException
    {
        SchemaCache.getSchema("");
    }

    @Test(expected = SchemaCreationException.class)
    public void testGetSchemaWithFoopString() throws SchemaCreationException
    {
        SchemaCache.getSchema("foo");
    }

    @Test(expected = RuntimeException.class)
    public void testGetSchemaWithIllegalArgument() throws SchemaCreationException
    {
        SchemaCache.getSchema("http://");
    }

    @Test
    public void testGetSchema() throws SchemaCreationException
    {
        URL url = Tester.getResource("test-files/xml/schemacacheTest.xsd");
        Schema schema = SchemaCache.getSchema(url.toString());
        Assert.assertNotNull(schema);
    }

    @Test(expected = SchemaCreationException.class)
    public void testGetSchemaWithNullURL() throws SchemaCreationException
    {
        SchemaCache.getSchema(this.getClass().getResource("foo"));
    }

    @Ignore("Creates dependency because (1) must be online and (2) w3c may be asleep.")
    @Test
    public void testGetSchemaWithURL() throws MalformedURLException, SchemaCreationException
    {
        URL url = new URL("http://www.w3.org/2001/xml.xsd");
        Schema schema = SchemaCache.getSchema(url);
        Assert.assertNotNull(schema);
    }

    @Ignore("Creates dependency because (1) must be online and (2) dans may be asleep.")
    @Test(expected = SchemaCreationException.class)
    public void testGetSchemaWithLegalArgument() throws SchemaCreationException
    {
        SchemaCache.getSchema("http://www.dans.knaw.nl/nl/");
    }

    @Test(expected = SchemaCreationException.class)
    public void testGetInvalidSchema() throws SchemaCreationException
    {
        SchemaCache.getSchema(Tester.getResource("test-files/xml/schemacacheTest-invalid.xsd"));
    }

}
