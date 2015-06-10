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

import nl.knaw.dans.common.lang.repo.AbstractUnitOfWork;
import nl.knaw.dans.common.lang.repo.DataModelObject;
import nl.knaw.dans.common.lang.repo.DmoStore;

public class DummyUnitOfWork extends AbstractUnitOfWork
{
    private static final long serialVersionUID = -2376953145049383061L;
    private transient DmoStore store;

    public DummyUnitOfWork(DmoStore store)
    {
        super("dummyOwnerId");
        this.store = store;
    }

    public DummyUnitOfWork()
    {
        super("dummyOwnerId");
        this.store = new DummyDmoStore();
    }

    @Override
    public DmoStore getStore()
    {
        return store;
    }

    @Override
    protected String getIngestLogMessage(DataModelObject dmo)
    {
        return "Ingest by dummy unit of work " + dmo.toString();
    }

    @Override
    protected String getPurgeLogMessage(DataModelObject dmo)
    {
        return "Purged by dummy unit of work " + dmo.toString();
    }

    @Override
    protected String getUpdateLogMessage(DataModelObject dmo)
    {
        return "Updated by dummy unit of work " + dmo.toString();
    }

}
