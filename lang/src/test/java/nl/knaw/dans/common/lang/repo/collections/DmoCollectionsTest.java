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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import nl.knaw.dans.common.lang.repo.DmoNamespace;
import nl.knaw.dans.common.lang.repo.DmoStoreId;
import nl.knaw.dans.common.lang.repo.dummy.DummyDmoContainer;
import nl.knaw.dans.common.lang.repo.dummy.DummyDmoContainerItem;
import nl.knaw.dans.common.lang.repo.dummy.DummyDmoRecursiveItem;
import nl.knaw.dans.common.lang.repo.dummy.RepoTester;
import nl.knaw.dans.common.lang.repo.exception.ObjectIsNotPartOfCollection;
import nl.knaw.dans.common.lang.repo.relations.RelsConstants;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class DmoCollectionsTest
{
    private static RepoTester repoTester;

    @BeforeClass
    public static void beforeClass()
    {
        repoTester = new RepoTester();
    }

    @Test
    @Ignore("Dummy shit cannot be maintained")
    public void testRelationships() throws Exception
    {
        DummyDmoContainer c1 = (DummyDmoContainer) repoTester.retrieve(DummyDmoContainer.class);
        DummyDmoContainerItem i1 = (DummyDmoContainerItem) repoTester.retrieve(DummyDmoContainerItem.class);
        DummyDmoContainerItem i2 = (DummyDmoContainerItem) repoTester.retrieve(DummyDmoContainerItem.class);
        DummyDmoRecursiveItem r1 = (DummyDmoRecursiveItem) repoTester.retrieve(DummyDmoRecursiveItem.class);
        DummyDmoContainerItem i3 = (DummyDmoContainerItem) repoTester.retrieve(DummyDmoContainerItem.class);

        assertEquals(0, c1.getChildren().size());
        assertEquals(0, i1.getParents().size());
        assertEquals(0, r1.getParents().size());
        assertEquals(0, r1.getChildren().size());
        assertEquals(0, i1.getParents().size());

        c1.addChild(i1);
        c1.addChild(r1);
        r1.addChild(i2);
        // i3 has two parents
        r1.addChild(i3);
        c1.addChild(i3);

        // check child/parent cache
        assertEquals(3, c1.getChildren().size());
        assertEquals(1, i1.getParents().size());
        assertEquals(1, r1.getParents().size());
        assertEquals(2, r1.getChildren().size());
        assertEquals(2, i3.getParents().size());

        // check relations
        String predicate = RelsConstants.DANS_NS.IS_MEMBER_OF.toString();
        assertEquals(1, i1.getRelations().getRelation(predicate, null).size());
        assertEquals(1, r1.getRelations().getRelation(predicate, null).size());
        assertEquals(1, i2.getRelations().getRelation(predicate, null).size());
        assertEquals(2, i3.getRelations().getRelation(predicate, null).size());

        assertTrue(i1.getRelations().hasRelation(predicate, c1.getStoreId()));
        assertTrue(r1.getRelations().hasRelation(predicate, c1.getStoreId()));
        assertTrue(i2.getRelations().hasRelation(predicate, r1.getStoreId()));
        assertTrue(i3.getRelations().hasRelation(predicate, c1.getStoreId()));
        assertTrue(i3.getRelations().hasRelation(predicate, r1.getStoreId()));
    }

    @Ignore("Dummy shit will not be maintained")
    @Test(expected = ObjectIsNotPartOfCollection.class)
    public void testInvalidRelationships() throws Exception
    {
        DummyDmoContainer c1 = (DummyDmoContainer) repoTester.retrieve(DummyDmoContainer.class);
        InvalidDummyItem dmo = new InvalidDummyItem("invalid:1");
        c1.addChild(dmo);
    }

    class InvalidDummyItem extends AbstractDmoContainerItem
    {
        private static final long serialVersionUID = -7642181598352535316L;

        public InvalidDummyItem(String storeId)
        {
            super(storeId);
        }

        public Set<DmoCollection> getCollections()
        {
            return null;
        }

        public boolean isDeletable()
        {
            return true;
        }

        @Override
        public DmoNamespace getDmoNamespace()
        {
            return DmoStoreId.getDmoNamespace(getStoreId());
        }

    }

}
