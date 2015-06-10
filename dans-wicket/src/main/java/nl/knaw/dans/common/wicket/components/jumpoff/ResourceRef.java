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
package nl.knaw.dans.common.wicket.components.jumpoff;

import java.io.Serializable;

import nl.knaw.dans.common.lang.repo.UnitMetadata;

import org.apache.wicket.Application;

public class ResourceRef implements Serializable
{

    public static final String CONTEXT_PATH = "/ui";

    private static final long serialVersionUID = -3112109550712445609L;

    private final String containerId;
    private final String unitId;
    private final String filename;
    private final String mimeType;
    private boolean referenced;
    private final String resourceAlias;

    public ResourceRef(String containerId, UnitMetadata unitMetadata, String resourceAlias)
    {
        this.containerId = containerId;
        unitId = unitMetadata.getId();
        filename = unitMetadata.getLabel();
        mimeType = unitMetadata.getMimeType();
        this.resourceAlias = resourceAlias;
    }

    public String getHref()
    {
        String alias = resourceAlias == null ? Application.class.getName() : resourceAlias;
        return CONTEXT_PATH + "/resources/" + alias + "/content?sid=" + containerId + "&did=" + unitId;
    }

    public String getContainerId()
    {
        return containerId;
    }

    public String getUnitId()
    {
        return unitId;
    }

    public String getFilename()
    {
        return filename;
    }

    public String getMimeType()
    {
        return mimeType;
    }

    public boolean isReferenced()
    {
        return referenced;
    }

    public void setReferenced(boolean referenced)
    {
        this.referenced = referenced;
    }

    public String getResourceAlias()
    {
        return resourceAlias;
    }

}
