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

import static org.junit.Assert.assertEquals;
import nl.knaw.dans.common.lang.repo.AbstractDataModelObject;
import nl.knaw.dans.common.lang.repo.DataModelObject;
import nl.knaw.dans.common.lang.repo.DmoNamespace;

import org.junit.Test;

public class AbstractRelationsTest
{

    @Test
    public void addRemove() throws Exception
    {
        DataModelObject dmo = new AbstractDataModelObject("foo:test")
        {

            private static final long serialVersionUID = 1L;

            @Override
            public boolean isDeletable()
            {
                return false;
            }

            @Override
            public DmoNamespace getDmoNamespace()
            {
                return null;
            }
        };
        AbstractRelations<?> relations = new RelationsImpl(dmo);
        assertEquals(0, relations.getRelation(null, null).size());

        relations.addRelation("relationName1", "literal1");
        assertEquals(1, relations.getRelation(null, null).size());

        relations.removeRelation("relationName1", "literal1");
        assertEquals(0, relations.getRelation(null, null).size());

        relations.addRelation("relationName1", "literal1");
        relations.addRelation("relationName1", "literal1"); // equals previous
        relations.addRelation("relationName1", "literal2");
        relations.addRelation("relationName2", "literal1");
        relations.addRelation("relationName2", "literal2");
        assertEquals(4, relations.getRelation(null, null).size());
        relations.removeRelation("relationName1", "literal1");
        assertEquals(3, relations.getRelation(null, null).size());
        relations.removeRelation("relationName1", "literal2");
        assertEquals(2, relations.getRelation(null, null).size());
        relations.removeRelation("relationName2", "literal1");
        assertEquals(1, relations.getRelation(null, null).size());
        relations.removeRelation("relationName2", "literal2");
        assertEquals(0, relations.getRelation(null, null).size());

        relations.addRelation("relationName1", "literal1");
        relations.addRelation("relationName1", "literal2");
        relations.addRelation("relationName2", "literal1");
        relations.addRelation("relationName2", "literal2");
        assertEquals(4, relations.getRelation(null, null).size());
        relations.removeRelation("relationName1", null);
        assertEquals(2, relations.getRelation(null, null).size());

    }

    class RelationsImpl extends AbstractRelations<DataModelObject>
    {

        public RelationsImpl(DataModelObject subject)
        {
            super(subject);
        }

        private static final long serialVersionUID = 1L;

    }

}
