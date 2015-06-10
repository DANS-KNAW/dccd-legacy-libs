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
package nl.knaw.dans.common.lang.repo.collections;

import java.util.Set;

import nl.knaw.dans.common.lang.repo.DataModelObject;

/**
 * An object that is member of a collection. This object stores it's relations
 * through the relations object of the DataModelObject
 * 
 * @author lobo
 */
public interface DmoCollectionMember extends DataModelObject
{
    /**
     * @return a list of the collections that this object is part of 
     */
    public Set<DmoCollection> getCollections(); // wrong method name

    /**
     * A convenience method that may be called to check whether this object
     * is part of a collection 
     * @param collection the collection to check for
     */
    public boolean isPartOfCollection(DmoCollection collection);
}
