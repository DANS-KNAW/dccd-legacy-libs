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

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import nl.knaw.dans.common.lang.repo.DataModelObject;
import nl.knaw.dans.common.lang.repo.DmoStoreId;
import nl.knaw.dans.common.lang.repo.relations.AbstractRelations;
import nl.knaw.dans.common.lang.repo.relations.Relation;
import nl.knaw.dans.common.lang.repo.relations.RelsConstants;

/**
 * The relations object that is keeps track of the parents of 
 * a DmoContainerItem. 
 * 
 * @author lobo
 */
public class DmoContainerItemRelations<T extends DataModelObject> extends AbstractRelations<T>
{
    private static final long serialVersionUID = 1045588410694179932L;

    public DmoContainerItemRelations(T containerItem)
    {
        super(containerItem);
    }

    public Set<DmoStoreId> getParents()
    {
        Set<Relation> parents = getRelation(RelsConstants.DANS_NS.IS_MEMBER_OF.toString(), null);
        HashSet<DmoStoreId> result = new HashSet<DmoStoreId>(parents.size());
        for (Relation parent : parents)
            result.add(new DmoStoreId((String) parent.object));
        return result;
    }

    public void setParents(Collection<DmoStoreId> parentSids)
    {
        removeRelation(RelsConstants.DANS_NS.IS_MEMBER_OF.toString(), null);
        for (DmoStoreId parentSid : parentSids)
        {
            addParent(parentSid);
        }
    }

    public void addParent(DmoStoreId parentSid)
    {
        addRelation(RelsConstants.DANS_NS.IS_MEMBER_OF.toString(), parentSid.getStoreId());
    }

    public void removeParent(DmoStoreId parentSid)
    {
        removeRelation(RelsConstants.DANS_NS.IS_MEMBER_OF.toString(), parentSid.getStoreId());
    }

    public void clearParents()
    {
        removeRelation(RelsConstants.DANS_NS.IS_MEMBER_OF.toString(), null);
    }

    /**
     * Express single relation: this subject is under the authority or control of the object denoted by superiorId.
     * 
     * @param superiorId id of authority or control object
     */
    public void setSubordinateTo(DmoStoreId superiorId)
    {
        removeRelation(RelsConstants.DANS_NS.IS_SUBORDINATE_TO.toString(), null);
        if (superiorId != null)
        {
            addRelation(RelsConstants.DANS_NS.IS_SUBORDINATE_TO.toString(), superiorId.getStoreId());
        }
    }
}
