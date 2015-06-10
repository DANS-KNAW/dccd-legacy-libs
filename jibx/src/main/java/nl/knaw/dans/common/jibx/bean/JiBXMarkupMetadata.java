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

import nl.knaw.dans.common.jibx.AbstractJiBXObject;
import nl.knaw.dans.common.lang.repo.bean.JumpoffDmoMetadata.MarkupVersionID;
import nl.knaw.dans.common.lang.repo.bean.MarkupMetadata;

import org.joda.time.DateTime;

public class JiBXMarkupMetadata extends AbstractJiBXObject<MarkupMetadata> implements MarkupMetadata
{

    private static final long serialVersionUID = -1156624217408639919L;

    private String lastEditedBy;

    private DateTime lastEdited;

    private MarkupVersionID markupVersionID;

    /* used by JiBX */
    protected JiBXMarkupMetadata()
    {

    }

    protected JiBXMarkupMetadata(MarkupVersionID markupVersionID)
    {
        this.markupVersionID = markupVersionID;
    }

    public MarkupVersionID getMarkupVersionID()
    {
        return markupVersionID;
    }

    public String getLastEditedBy()
    {
        return lastEditedBy;
    }

    public void setLastEditedBy(String lastEditedBy)
    {
        this.lastEditedBy = lastEditedBy;
        setLastEdited(new DateTime());
    }

    public DateTime getLastEdited()
    {
        return lastEdited;
    }

    public void setLastEdited(DateTime lastEdited)
    {
        this.lastEdited = lastEdited;
    }

}
