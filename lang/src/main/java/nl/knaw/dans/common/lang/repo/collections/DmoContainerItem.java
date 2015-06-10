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

import java.util.List;
import java.util.Set;

import nl.knaw.dans.common.lang.RepositoryException;
import nl.knaw.dans.common.lang.repo.DmoStoreId;

/**
 * A container item may be child to one or more parent containers.  
 *
 * @author lobo
 */
public interface DmoContainerItem extends DmoCollectionMember
{
    DmoStoreId getParentSid() throws RepositoryException;

    Set<DmoStoreId> getParentSids() throws RepositoryException;

    DmoContainer getParent() throws RepositoryException;

    List<? extends DmoContainer> getParents() throws RepositoryException;

    void setParentSid(DmoStoreId dmoStoreId) throws RepositoryException;

    void setParentSids(Set<DmoStoreId> parentSids) throws RepositoryException;

    void setParent(DmoContainer container) throws RepositoryException;

    void setParents(List<? extends DmoContainer> container) throws RepositoryException;

    void addParent(DmoContainer container) throws RepositoryException;

    void addParentSid(DmoStoreId dmoStoreId) throws RepositoryException;

    void removeParent(DmoContainer container) throws RepositoryException;

    void removeParentSid(DmoStoreId parentDmoStoreId) throws RepositoryException;
}
