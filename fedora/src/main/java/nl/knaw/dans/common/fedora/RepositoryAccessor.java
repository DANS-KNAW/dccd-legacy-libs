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
package nl.knaw.dans.common.fedora;

import java.rmi.RemoteException;

import nl.knaw.dans.common.lang.RepositoryException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RepositoryAccessor
{
    private static final Logger logger = LoggerFactory.getLogger(RepositoryAccessor.class);

    private final Repository repository;

    public RepositoryAccessor(Repository repository)
    {
        this.repository = repository;
    }

    public fedora.server.types.gen.RepositoryInfo getRepositoryInfo() throws RepositoryException
    {
        fedora.server.types.gen.RepositoryInfo repositoryInfo = null;
        try
        {
            repositoryInfo = repository.getFedoraAPIA().describeRepository();
        }
        catch (RemoteException e)
        {
            final String msg = "Unable to get repository info: ";
            logger.debug(msg, e);
            Repository.mapRemoteException(msg, e);
        }
        return repositoryInfo;
    }

    public RepositoryInfo describeRepository() throws RepositoryException
    {
        return new RepositoryInfo(getRepositoryInfo());
    }

}
