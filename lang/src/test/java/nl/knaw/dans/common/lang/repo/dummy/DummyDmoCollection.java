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
package nl.knaw.dans.common.lang.repo.dummy;

import java.util.HashSet;
import java.util.Set;

import nl.knaw.dans.common.lang.repo.DmoNamespace;
import nl.knaw.dans.common.lang.repo.collections.AbstractDmoCollection;
import nl.knaw.dans.common.lang.repo.collections.DmoCollection;
import nl.knaw.dans.common.lang.repo.collections.DmoCollectionMember;

public class DummyDmoCollection extends AbstractDmoCollection implements DmoCollection
{
    public static final DmoNamespace NAMESPACE = new DmoNamespace("dummy-collection");

    private static final long serialVersionUID = -3829949809753365029L;

    private static final String DATASET_ITEM_COLLECTION_SID = "dataset-item-collection:1";

    private static Set<Class<? extends DmoCollectionMember>> classes;

    private static final DummyDmoCollection INSTANCE = new DummyDmoCollection();

    public static DummyDmoCollection getInstance()
    {
        return INSTANCE;
    }

    public DummyDmoCollection()
    {
        super(DATASET_ITEM_COLLECTION_SID);
        classes = new HashSet<Class<? extends DmoCollectionMember>>();
        classes.add(DummyDmoContainer.class);
        classes.add(DummyDmoContainerItem.class);
        classes.add(DummyDmoRecursiveItem.class);
    }

    public Set<Class<? extends DmoCollectionMember>> getMemberClasses()
    {
        return classes;
    }

    public DmoNamespace getDmoNamespace()
    {
        return NAMESPACE;
    }

    @Override
    public String getStoreId()
    {
        return DATASET_ITEM_COLLECTION_SID;
    }

    public boolean isDeletable()
    {
        return false;
    }

}
