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

import org.apache.axis.types.NonNegativeInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fedora.server.types.gen.FieldSearchQuery;
import fedora.server.types.gen.FieldSearchResult;

public class ObjectAccessor
{

    private static final Logger logger = LoggerFactory.getLogger(ObjectAccessor.class);

    private final Repository repository;

    /**
     * Constructs a new ObjectAccessor with the given Repository as base.
     * 
     * @param repository
     *        Repository to access
     */
    public ObjectAccessor(Repository repository)
    {
        this.repository = repository;
    }

    public FieldSearchResult findObjects(String[] resultfields, int maxResults, FieldSearchQuery query) throws RepositoryException
    {
        FieldSearchResult result = null;
        try
        {
            result = repository.getFedoraAPIA().findObjects(resultfields, new NonNegativeInteger("" + maxResults), query);
        }
        catch (RemoteException e)
        {
            String msg = "Unable to find objects: ";
            logger.debug(msg, e);
            Repository.mapRemoteException(msg, e);
        }
        return result;
    }

    public FieldSearchResult resumeFindObjects(String token) throws RepositoryException
    {
        FieldSearchResult result = null;
        try
        {
            result = repository.getFedoraAPIA().resumeFindObjects(token);
        }
        catch (RemoteException e)
        {
            String msg = "Unable to resume find objects: ";
            logger.debug(msg, e);
            Repository.mapRemoteException(msg, e);
        }
        return result;
    }

}
