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

import nl.knaw.dans.common.lang.repo.relations.RelationConstraint;

/**
 * This object describes the relation between two collection members.
 * 
 * The cardinality stuph is not in use yet, mostly because checking 
 * those constraints would mean that a lost of relationship queries
 * would have to be fired on the store which would slow things down.
 * Currently we have also no requirement for it, so we just store that
 * information, but do nothing with it.
 * 
 * @author lobo
 */
public class DmoCollectionMemberConstraint implements RelationConstraint
{
    private Class<? extends DmoCollectionMember> object;
    private int oCardinality;
    private Class<? extends DmoCollectionMember> subject;
    private int sCardinality;

    public DmoCollectionMemberConstraint(int sCardinality, Class<? extends DmoCollectionMember> subject, int oCardinality,
            Class<? extends DmoCollectionMember> object)
    {
        this.sCardinality = sCardinality;
        this.subject = subject;
        this.oCardinality = oCardinality;
        this.object = object;
    }

    /* (non-Javadoc)
     * @see nl.knaw.dans.easy.domain.dataset.RelationConstraint#getSubject()
     */
    public Class<? extends DmoCollectionMember> getSubject()
    {
        return subject;
    }

    /* (non-Javadoc)
     * @see nl.knaw.dans.easy.domain.dataset.RelationConstraint#getObject()
     */
    public Class<? extends DmoCollectionMember> getObject()
    {
        return object;
    }

    /* (non-Javadoc)
     * @see nl.knaw.dans.easy.domain.dataset.RelationConstraint#getObjectCardinality()
     */
    public int getObjectCardinality()
    {
        return oCardinality;
    }

    /* (non-Javadoc)
     * @see nl.knaw.dans.easy.domain.dataset.RelationConstraint#getSubjectCardinality()
     */
    public int getSubjectCardinality()
    {
        return sCardinality;
    }

}
