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

import nl.knaw.dans.common.lang.repo.AbstractDataModelObject;
import nl.knaw.dans.common.lang.repo.DmoNamespace;

public class DummyDmo extends AbstractDataModelObject
{
    private static final long serialVersionUID = -3565807304612555180L;
    public static final DmoNamespace NAMESPACE = new DmoNamespace("dummy-object");
    private long loadTime = 0;

    public DummyDmo(String storeId)
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

    public void setLoadTime(long time)
    {
        loadTime = time;
    }

    @Override
    public long getloadTime()
    {
        if (loadTime != 0)
            return loadTime;
        else
            return super.getloadTime();
    }
}
