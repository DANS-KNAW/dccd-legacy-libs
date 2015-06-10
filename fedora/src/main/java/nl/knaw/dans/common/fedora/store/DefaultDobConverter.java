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
package nl.knaw.dans.common.fedora.store;

import nl.knaw.dans.common.fedora.fox.Datastream;
import nl.knaw.dans.common.fedora.fox.DatastreamVersion;
import nl.knaw.dans.common.fedora.fox.DigitalObject;
import nl.knaw.dans.common.lang.repo.AbstractDmoFactory;
import nl.knaw.dans.common.lang.repo.DataModelObject;
import nl.knaw.dans.common.lang.repo.DmoFactory;
import nl.knaw.dans.common.lang.repo.DmoNamespace;
import nl.knaw.dans.common.lang.repo.exception.ObjectDeserializationException;

import org.dom4j.Element;

public class DefaultDobConverter extends AbstractDobConverter<DataModelObject>
{

    public static String NO_NAMESPACE = "no-namespace";

    public DefaultDobConverter()
    {
        super(new DmoNamespace(NO_NAMESPACE));
    }

    @Override
    public void deserialize(DigitalObject dob, DataModelObject dmo) throws ObjectDeserializationException
    {
        super.deserialize(dob, dmo);
        DmoFactory<?> factory = AbstractDmoFactory.factoryFor(dmo.getDmoNamespace());
        for (Datastream datastream : dob.getDatastreams())
        {
            String mdUnitId = datastream.getStreamId();
            DatastreamVersion version = datastream.getLatestVersion();
            Element element = version.getXmlContentElement();
            factory.setMetadataUnit(dmo, mdUnitId, element);
        }
    }

}
