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
package nl.knaw.dans.common.lang.repo.jumpoff;

import java.util.Set;

import nl.knaw.dans.common.lang.repo.relations.AbstractRelations;
import nl.knaw.dans.common.lang.repo.relations.Relation;
import nl.knaw.dans.common.lang.repo.relations.RelsConstants;

public class JumpoffDmoRelations extends AbstractRelations<JumpoffDmo>
{

    private static final long serialVersionUID = 878966138861721900L;

    private String objectId;

    public JumpoffDmoRelations(JumpoffDmo subject)
    {
        super(subject);
    }

    public JumpoffDmoRelations(JumpoffDmo subject, String objectId)
    {
        super(subject);
        this.objectId = objectId;
        addRelation(RelsConstants.DANS_NS.IS_JUMPOFF_PAGE_FOR.stringValue(), this.objectId);
        addRelation(RelsConstants.DANS_NS.IS_SUBORDINATE_TO.stringValue(), this.objectId);
    }

    public String getObjectId()
    {
        if (objectId == null)
        {
            Set<Relation> relations = getRelation(RelsConstants.DANS_NS.IS_JUMPOFF_PAGE_FOR.stringValue(), null);
            objectId = (String) relations.iterator().next().object;
        }
        return objectId;
    }

}
