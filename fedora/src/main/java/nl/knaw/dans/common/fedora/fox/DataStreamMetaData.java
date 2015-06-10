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

import nl.knaw.dans.common.lang.repo.UnitMetadata;

import org.joda.time.DateTime;

import fedora.server.types.gen.Datastream;

public class DataStreamMetaData implements UnitMetadata
{
    private static final long serialVersionUID = -313702526178798982L;
    private final DateTime creationDate;
    private final String id;
    private final String versionId;
    private final long size;
    private final String label;
    private final String mimeType;
    private final String location;

    private final String containerId;

    public DataStreamMetaData(Datastream dataStream, String containerId)
    {
        creationDate = new DateTime(dataStream.getCreateDate());
        id = dataStream.getID();
        size = dataStream.getSize();
        versionId = dataStream.getVersionID();
        label = dataStream.getLabel();
        mimeType = dataStream.getMIMEType();
        location = dataStream.getLocation();
        this.containerId = containerId;

    }

    /* (non-Javadoc)
     * @see nl.knaw.dans.common.fedora.fox.UnitMetaData#getCreationDate()
     */
    public DateTime getCreationDate()
    {
        return creationDate;
    }

    /* (non-Javadoc)
     * @see nl.knaw.dans.common.fedora.fox.UnitMetaData#getId()
     */
    public String getId()
    {
        return id;
    }

    /* (non-Javadoc)
     * @see nl.knaw.dans.common.fedora.fox.UnitMetaData#getVersionId()
     */
    public String getVersionId()
    {
        return versionId;
    }

    /* (non-Javadoc)
     * @see nl.knaw.dans.common.fedora.fox.UnitMetaData#getSize()
     */
    public long getSize()
    {
        return size;
    }

    /* (non-Javadoc)
     * @see nl.knaw.dans.common.fedora.fox.UnitMetaData#getLabel()
     */
    public String getLabel()
    {
        return label;
    }

    /* (non-Javadoc)
     * @see nl.knaw.dans.common.fedora.fox.UnitMetaData#getMimeType()
     */
    public String getMimeType()
    {
        return mimeType;
    }

    /* (non-Javadoc)
     * @see nl.knaw.dans.common.fedora.fox.UnitMetaData#getLocation()
     */
    public String getLocation()
    {
        return location;
    }

    public String getContainerId()
    {
        return containerId;
    }

}
