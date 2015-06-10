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
package nl.knaw.dans.common.ldap.repo;

// import nl.knaw.dans.easy.domain.exceptions.DataAccessException;
import nl.knaw.dans.common.lang.RepositoryException;

/**
 * Signals an exception while marshaling/unmarshaling an object to/from attributes.
 *
 * @author ecco Feb 16, 2009
 */
public class LdapMappingException extends RepositoryException
{

    /**
     *
     */
    private static final long serialVersionUID = -4092636710840744437L;

    public LdapMappingException()
    {
    }

    public LdapMappingException(String message)
    {
        super(message);
    }

    public LdapMappingException(Throwable cause)
    {
        super(cause);
    }

    public LdapMappingException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
