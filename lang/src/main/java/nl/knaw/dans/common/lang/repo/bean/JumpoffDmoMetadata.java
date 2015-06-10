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
package nl.knaw.dans.common.lang.repo.bean;

import java.net.URI;

import nl.knaw.dans.common.lang.repo.MetadataUnitXMLBean;

public interface JumpoffDmoMetadata extends MetadataUnitXMLBean
{

    public enum MarkupVersionID
    {
        HTML_MU, TEXT_MU
    }

    String UNIT_ID = "JOMD";

    String UNIT_LABEL = "Descriptive metadata for this markup";

    String UNIT_FORMAT = "http://easy.dans.knaw.nl/easy/jumpoff-metadata/";

    URI UNIT_FORMAT_URI = URI.create(UNIT_FORMAT);

    MarkupMetadata getDefaultMarkupMetadata();

    MarkupMetadata getHtmlMarkupMetadata();

    MarkupMetadata getTextMarkupMetadata();

    MarkupVersionID getDefaultMarkupVersionID();

    void setDefaultMarkupVersionID(MarkupVersionID mvId);

    void toggleEditorMode();

    boolean isInHtmlMode();

}
