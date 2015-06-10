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
import nl.knaw.dans.common.lang.repo.collections.AbstractDmoContainer;
import nl.knaw.dans.common.lang.repo.collections.DmoCollection;

public class DummyDmoContainer extends AbstractDmoContainer
{
    private static final long serialVersionUID = -7282653435250070438L;
    public static final DmoNamespace NAMESPACE = new DmoNamespace("dummy-container");

    public DummyDmoContainer(String storeId)
    {
        super(storeId);
    }

    public DmoNamespace getDmoNamespace()
    {
        return NAMESPACE;
    }

    public boolean isDeletable()
    {
        return true;
    }

    public Set<DmoCollection> getCollections()
    {
        Set<DmoCollection> c = new HashSet<DmoCollection>();
        c.add(DummyDmoCollection.getInstance());
        return c;
    }

}
