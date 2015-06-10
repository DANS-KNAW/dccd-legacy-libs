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
package nl.knaw.dans.common.lang.repo.exception;

import nl.knaw.dans.common.lang.RepositoryException;

/**
 * Signals that the service, store, database or repository encountered an exception while fulfilling a request.
 * 
 * @author ecco Sep 24, 2009
 */
public class RemoteException extends RepositoryException
{

    private static final long serialVersionUID = -7795802327773517335L;

    // CHECKSTYLE: OFF 
    public RemoteException()
    {
    }

    public RemoteException(final String message)
    {
        super(message);
    }

    public RemoteException(final Throwable cause)
    {
        super(cause);
    }

    public RemoteException(final String message, final Throwable cause)
    {
        super(message, cause);
    }

}
