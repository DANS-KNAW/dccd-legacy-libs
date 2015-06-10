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

import java.net.URL;

import nl.knaw.dans.common.fedora.fox.DatastreamVersion;
import nl.knaw.dans.common.fedora.fox.DigitalObject;
import nl.knaw.dans.common.jibx.JiBXObjectFactory;
import nl.knaw.dans.common.jibx.bean.JiBXJumpoffDmoMetadata;
import nl.knaw.dans.common.lang.repo.DsUnitId;
import nl.knaw.dans.common.lang.repo.bean.JumpoffDmoMetadata;
import nl.knaw.dans.common.lang.repo.exception.ObjectDeserializationException;
import nl.knaw.dans.common.lang.repo.jumpoff.JumpoffDmo;
import nl.knaw.dans.common.lang.xml.XMLDeserializationException;

import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JumpoffDmoConverter extends AbstractDobConverter<JumpoffDmo>
{

    private static final Logger logger = LoggerFactory.getLogger(JumpoffDmoConverter.class);

    private final FedoraDmoStore store;

    public JumpoffDmoConverter(FedoraDmoStore store)
    {
        super(JumpoffDmo.NAMESPACE);
        this.store = store;
    }

    @Override
    public void deserialize(DigitalObject dob, JumpoffDmo jod) throws ObjectDeserializationException
    {
        checkNamespace(dob, jod);
        dob.writeObjectProperties(jod);

        try
        {
            DatastreamVersion jomdVersion = dob.getLatestVersion(JumpoffDmoMetadata.UNIT_ID);
            if (jomdVersion != null)
            {
                Element element = jomdVersion.getXmlContentElement();
                JumpoffDmoMetadata jomd = (JumpoffDmoMetadata) JiBXObjectFactory.unmarshal(JiBXJumpoffDmoMetadata.class, element);
                jomd.setTimestamp(jomdVersion.getTimestamp());
                jomd.setDirty(false);
                jod.setJumpoffDmoMetadata(jomd);
            }
            else
            {
                logger.warn("No jumpoffDmoMetadata found on retrieved digital object. sid=" + dob.getSid());
            }
        }
        catch (XMLDeserializationException e)
        {
            throw new ObjectDeserializationException(e);
        }

        DatastreamVersion htmlMarkupVersion = dob.getLatestVersion(JumpoffDmo.UNIT_ID_HTML);
        if (htmlMarkupVersion != null && store != null)
        {
            URL fileURL = store.getFileURL(jod.getDmoStoreId(), new DsUnitId(JumpoffDmo.UNIT_ID_HTML));
            jod.getHtmlMarkup().setFileURL(fileURL);
        }

        DatastreamVersion textMarkupVersion = dob.getLatestVersion(JumpoffDmo.UNIT_ID_TEXT);
        if (textMarkupVersion != null && store != null)
        {
            URL fileURL = store.getFileURL(jod.getDmoStoreId(), new DsUnitId(JumpoffDmo.UNIT_ID_TEXT));
            jod.getTextMarkup().setFileURL(fileURL);
        }

        deserializeRelationships(dob, jod);
    }

}
