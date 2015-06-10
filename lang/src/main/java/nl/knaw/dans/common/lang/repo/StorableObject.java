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

import nl.knaw.dans.common.lang.TimestampedObject;

import org.joda.time.DateTime;

/**
 * 
 *
 */
public interface StorableObject extends TimestampedObject
{

    String getStoreId();

    void setStoreId(String storeId);

    String getLabel();

    void setLabel(String label);

    String getOwnerId();

    void setOwnerId(String ownerId);

    String getState();

    void setState(String state);

    DateTime getDateCreated();

    void setDateCreated(DateTime dateCreated);

    DateTime getLastModified();

    void setlastModified(DateTime lastModified);

    void setLoaded(boolean loaded);

    boolean isLoaded();

    /**
     * @return the time that the object was loaded in system nanotime
     */
    long getloadTime();
}
