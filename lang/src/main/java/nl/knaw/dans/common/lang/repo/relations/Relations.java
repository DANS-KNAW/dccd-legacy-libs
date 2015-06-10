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
package nl.knaw.dans.common.lang.repo.relations;

import java.util.Set;

import nl.knaw.dans.common.lang.TimestampedObject;
import nl.knaw.dans.common.lang.repo.exception.ObjectSerializationException;

/**
 * A relations object is part of a DataModelObject and contains references
 * to other DataModelObjects. This object is based on Fedora's Relationships object
 * which is RDF that is stored and loaded from the rels-ext datastream.
 * 
 * This interface is read-only as it an implementor
 * might want to make sure that the relations that are returned by this interface
 * are regulated and standardized. 
 * 
 * @author lobo
 *
 */
public interface Relations extends TimestampedObject
{
    /**
     * Determine if the object contains the given relationship.
     * <p>
     * Returns results that are accurate for the current state of the object at
     * the time of invocation. Thus, if there is some change to the object that
     * changes the set of relationships contained within, the next call to
     * hasRelationship will reflect those changes.
     * </p>
     * 
     * @param predicate
     *        Predicate of the relationship, or null if unspecified (will match
     *        any).
     * @param object
     *        Object (target) of the relationship, or null if unspecified (will
     *        match any).
     * @return true if the object
     */
    boolean hasRelation(String predicate, String object);

    int size();

    /**
     * Get all matching relationships in the object.
     * <p>
     * Returns results that are accurate for the current state of the object at
     * the time of invocation. Thus, if there is some change to the object that
     * changes the set of relationships contained within, the next call to
     * getRelationships will reflect those changes.
     * </p>
     * 
     * @param predicate
     *        Predicate of the relationship, or null if unspecified (will match
     *        any).
     * @param object
     *        Object (target) of the relationship, or null if unspecified (will
     *        match any).
     * @return All matching relationships in the object
     */
    Set<Relation> getRelation(String predicate, String object);

    String getRdf() throws ObjectSerializationException;

}
