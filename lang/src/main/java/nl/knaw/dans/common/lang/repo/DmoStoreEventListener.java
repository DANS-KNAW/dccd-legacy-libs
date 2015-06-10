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

import nl.knaw.dans.common.lang.repo.exception.DmoStoreEventListenerException;

public interface DmoStoreEventListener
{

    /**
     * Called before the ingest of a DataModelObject. 
     * 
     * @param dmo
     *        ingested DataModelObject
     */
    void beforeIngest(DmoStore store, DataModelObject dmo) throws DmoStoreEventListenerException;

    /**
     * Called after the successful ingest of a DataModelObject.
     * 
     * @param dmo
     *        ingested DataModelObject
     */
    void afterIngest(DmoStore store, DataModelObject dmo) throws DmoStoreEventListenerException;

    /**
     * Called before the update of a DataModelObject.
     * 
     * @param dmo
     *        updated DataModelObject
     */
    void beforeUpdate(DmoStore store, DataModelObject dmo) throws DmoStoreEventListenerException;

    /**
     * Called after the successful update of a DataModelObject.
     * 
     * @param dmo
     *        updated DataModelObject
     */
    void afterUpdate(DmoStore store, DataModelObject dmo) throws DmoStoreEventListenerException;

    /**
     * Called after an erroneous, possibly partial update of a DataModelObject.
     * This means that some part of the update went right, but some part went 
     * wrong.
     * 
     * @param dmo the object that was partially updated. Beware: This object does
     * not reflect the current state of the object in the repository! 
     */
    void afterPartialUpdate(DmoStore store, DataModelObject dmo) throws DmoStoreEventListenerException;

    /**
     * Called before the permanent removal of an object.
     * 
     */
    void beforePurge(DmoStore store, DataModelObject dmo) throws DmoStoreEventListenerException;

    /**
     * Called after the permanent removal of an object.
     * 
     */
    void afterPurge(DmoStore store, DataModelObject dmo) throws DmoStoreEventListenerException;

}
