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
package nl.knaw.dans.common.fedora.store;

import nl.knaw.dans.common.lang.repo.DataModelObject;
import nl.knaw.dans.common.lang.repo.DmoNamespace;
import nl.knaw.dans.common.lang.repo.dummy.DummyDmoCollection;
import nl.knaw.dans.common.lang.repo.dummy.DummyDmoContainer;
import nl.knaw.dans.common.lang.repo.dummy.DummyDmoContainerItem;
import nl.knaw.dans.common.lang.repo.dummy.DummyDmoRecursiveItem;

public class DummyConverter<T extends DataModelObject> extends AbstractDobConverter<T>
{
    private Class<T> clazz;

    public DummyConverter(Class<T> clazz)
    {
        super(new DmoNamespace("dummyConverter"));
        this.clazz = clazz;
    }

    @Override
    public DmoNamespace getObjectNamespace()
    {
        if (clazz.equals(DummyDmoContainer.class))
            return DummyDmoContainer.NAMESPACE;
        else if (clazz.equals(DummyDmoContainerItem.class))
            return DummyDmoContainerItem.NAMESPACE;
        else if (clazz.equals(DummyDmoRecursiveItem.class))
            return DummyDmoRecursiveItem.NAMESPACE;
        else if (clazz.equals(DummyDmoCollection.class))
            return DummyDmoCollection.NAMESPACE;
        else
            throw new RuntimeException("dummy container does not recognize class input");
    }
}
