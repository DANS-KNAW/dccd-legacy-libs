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
import nl.knaw.dans.common.lang.repo.relations.RelationConstraint;

/**
 * The Dmo Collection object maintains the relations between one type of container/container-item
 * relations. It is the context for one type of such relation. For example a folder/file type 
 * relationship are in the context of a filesystem, while nodes in a treeview are in the context
 * of a treeview. This object annotates this type of relations. Thus this object may be used to
 * store information on whether this relation is hierarchical, how many of a certain type of object
 * may contain other types of objects, etc.
 * 
 * Currently it implements just one feature that makes sure that container-items of
 * one type of collection cannot be inserted into the containers of another type of collection.
 * 
 * @author lobo
 *
 */
public interface DmoCollection extends DataModelObject
{
    /**
     * @return a list of collection members classes that are members of this collection 
     */
    Set<Class<? extends DmoCollectionMember>> getMemberClasses();

    /**
     * currently unimplemented!! 
     */
    RelationConstraint getRelationConstraint(Class<? extends DmoCollectionMember> subject, Class<? extends DmoCollectionMember> object);
}
