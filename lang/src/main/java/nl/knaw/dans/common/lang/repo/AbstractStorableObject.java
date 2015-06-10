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
package nl.knaw.dans.common.lang.repo;

import org.joda.time.DateTime;

public abstract class AbstractStorableObject extends AbstractTimestampedObject implements StorableObject
{

    private static final long serialVersionUID = 6450677170978355198L;

    private String storeId;
    private String label;
    private String ownerId;
    private String state;
    private DateTime dateCreated;
    private DateTime lastModified;

    private boolean loaded;

    private long loadTime;

    public AbstractStorableObject()
    {

    }

    public AbstractStorableObject(String storeId)
    {
        this.storeId = storeId;
    }

    public String getStoreId()
    {
        return storeId;
    }

    public void setStoreId(String storeId)
    {
        this.storeId = storeId;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        evaluateDirty(this.label, label);
        this.label = label;
    }

    public String getOwnerId()
    {
        return ownerId;
    }

    public void setOwnerId(String ownerId)
    {
        evaluateDirty(this.ownerId, ownerId);
        this.ownerId = ownerId;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        evaluateDirty(this.state, state);
        this.state = state;
    }

    public DateTime getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(DateTime dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    public DateTime getLastModified()
    {
        return lastModified;
    }

    public void setlastModified(DateTime lastModified)
    {
        this.lastModified = lastModified;
    }

    public boolean isLoaded()
    {
        return loaded;
    }

    public void setLoaded(boolean loaded)
    {
        this.loaded = loaded;
        if (loaded)
            this.loadTime = System.nanoTime();
        else
            this.loadTime = 0;
    }

    public long getloadTime()
    {
        return loadTime;
    }

}
