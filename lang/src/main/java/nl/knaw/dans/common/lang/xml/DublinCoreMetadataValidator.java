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

import java.net.URL;

import nl.knaw.dans.common.lang.repo.bean.DublinCoreMetadata;

public final class DublinCoreMetadataValidator extends AbstractXMLBeanValidator<DublinCoreMetadata>
{

    public static final String SCHEMA_LOCATION = "dc-xsd/oai_dc.xsd";

    private static DublinCoreMetadataValidator instance;

    private DublinCoreMetadataValidator()
    {

    }

    @Override
    public URL getSchemaURL(String version)
    {
        return this.getClass().getResource(SCHEMA_LOCATION);
    }

    public static DublinCoreMetadataValidator instance()
    {
        if (instance == null)
        {
            instance = new DublinCoreMetadataValidator();
        }
        return instance;
    }

}
