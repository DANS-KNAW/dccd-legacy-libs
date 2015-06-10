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

import java.net.URI;

import nl.knaw.dans.common.jibx.AbstractTimestampedJiBXObject;
import nl.knaw.dans.common.lang.repo.bean.JumpoffDmoMetadata;
import nl.knaw.dans.common.lang.repo.bean.MarkupMetadata;

public class JiBXJumpoffDmoMetadata extends AbstractTimestampedJiBXObject<JumpoffDmoMetadata> implements JumpoffDmoMetadata
{

    private static final long serialVersionUID = -7458319186128032871L;

    private boolean versionable;

    private MarkupVersionID markupVersionId;
    private JiBXMarkupMetadata htmlMarkupMetadata;
    private JiBXMarkupMetadata textMarkupMetadata;

    public JiBXJumpoffDmoMetadata()
    {

    }

    @Override
    public MarkupMetadata getDefaultMarkupMetadata()
    {
        if (MarkupVersionID.HTML_MU.equals(getDefaultMarkupVersionID()))
        {
            return getHtmlMarkupMetadata();
        }
        else
        {
            return getTextMarkupMetadata();
        }
    }

    @Override
    public MarkupMetadata getHtmlMarkupMetadata()
    {
        if (htmlMarkupMetadata == null)
        {
            htmlMarkupMetadata = new JiBXMarkupMetadata(MarkupVersionID.HTML_MU);
        }
        return htmlMarkupMetadata;
    }

    @Override
    public MarkupMetadata getTextMarkupMetadata()
    {
        if (textMarkupMetadata == null)
        {
            textMarkupMetadata = new JiBXMarkupMetadata(MarkupVersionID.TEXT_MU);
        }
        return textMarkupMetadata;
    }

    @Override
    public MarkupVersionID getDefaultMarkupVersionID()
    {
        if (markupVersionId == null)
        {
            markupVersionId = MarkupVersionID.HTML_MU;
        }
        return markupVersionId;
    }

    @Override
    public void setDefaultMarkupVersionID(MarkupVersionID mvId)
    {
        this.markupVersionId = mvId;
    }

    @Override
    public void toggleEditorMode()
    {
        if (MarkupVersionID.HTML_MU.equals(getDefaultMarkupVersionID()))
        {
            setDefaultMarkupVersionID(MarkupVersionID.TEXT_MU);
        }
        else
        {
            setDefaultMarkupVersionID(MarkupVersionID.HTML_MU);
        }
    }

    @Override
    public boolean isInHtmlMode()
    {
        return MarkupVersionID.HTML_MU.equals(getDefaultMarkupVersionID());
    }

    @Override
    public String getUnitFormat()
    {
        return UNIT_FORMAT;
    }

    @Override
    public URI getUnitFormatURI()
    {
        return UNIT_FORMAT_URI;
    }

    @Override
    public String getUnitId()
    {
        return UNIT_ID;
    }

    @Override
    public String getUnitLabel()
    {
        return UNIT_LABEL;
    }

    @Override
    public boolean isVersionable()
    {
        return versionable;
    }

    @Override
    public void setVersionable(boolean versionable)
    {
        this.versionable = versionable;
    }

}
