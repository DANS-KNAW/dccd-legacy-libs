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

import nl.knaw.dans.common.lang.repo.collections.DmoCollectionMember;

/**
 * Describes the constraints between relations subject /object. The
 * predicate is currently not stored in here, because it is assumed
 * the relation constraints are used for specific kinds of relations.
 * Thus the predicate should be clear. Maybe lateron it might proof
 * useful to store the predicate in here as well.
 *  
 * @author lobo
 */
public interface RelationConstraint
{

    public abstract Class<? extends DmoCollectionMember> getSubject();

    public abstract Class<? extends DmoCollectionMember> getObject();

    public abstract int getObjectCardinality();

    public abstract int getSubjectCardinality();

}
