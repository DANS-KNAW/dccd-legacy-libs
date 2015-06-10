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

import nl.knaw.dans.common.lang.RepositoryException;
import nl.knaw.dans.common.lang.repo.exception.ObjectDeserializationException;

import org.dom4j.Element;

public interface DmoFactory<T extends DataModelObject>
{

    /**
     * Get the namespace of the object this DmoFactory is instantiating.
     * 
     * @return namespace
     */
    DmoNamespace getNamespace();

    /**
     * Create an new instance of T with a new storeId. The storeId may be <code>null</code> if no
     * SidDispenser is associated with this DmoFactory.
     * 
     * @return new instance of T with a new storeId
     * @throws RepositoryException
     *         for exceptions while obtaining a new storeId
     */
    T newDmo() throws RepositoryException;

    /**
     * Create a new instance of T with the given storeId.
     * 
     * @param storeId
     *        storeId for returned T
     * @return new instance of T with the given storeId
     */
    T createDmo(String storeId);

    /**
     * Set the metadata unit represented by <code>element</code> on the given <code>dmo</code>. The
     * metadata unit is identified with the given <code>unitId</code>.
     * 
     * @param dmo
     *        DataModelObject to handle
     * @param unitId
     *        unitId of the metadata unit represented by <code>element</code>.
     * @param element
     *        represents the metadata unit
     * @throws ObjectDeserializationException
     *         if the element cannot be deserialized.
     */
    void setMetadataUnit(DataModelObject dmo, String unitId, Element element) throws ObjectDeserializationException;
}
