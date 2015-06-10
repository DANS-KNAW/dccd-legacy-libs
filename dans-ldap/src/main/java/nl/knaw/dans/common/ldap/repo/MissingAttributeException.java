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

/**
 * Thrown when a required attribute is null or blank when marshaling an object.
 * 
 * @author ecco Feb 16, 2009
 */
public class MissingAttributeException extends LdapMappingException
{

    /**
     * 
     */
    private static final long serialVersionUID = 9158334870250287440L;

    public MissingAttributeException()
    {
    }

    public MissingAttributeException(String message)
    {
        super(message);
    }

    public MissingAttributeException(Throwable cause)
    {
        super(cause);
    }

    public MissingAttributeException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
