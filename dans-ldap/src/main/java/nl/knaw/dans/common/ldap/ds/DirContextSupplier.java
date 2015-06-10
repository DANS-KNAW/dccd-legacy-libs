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
package nl.knaw.dans.common.ldap.ds;

import javax.naming.NamingException;
import javax.naming.directory.DirContext;

import nl.knaw.dans.common.lang.RepositoryException;

/**
 * Implementations of this interface are capable of supplying a javax.naming.directory.DirContext.
 * 
 * @author ecco
 */
public interface DirContextSupplier
{

    /**
     * Get the javax.naming.directory.DirContext.
     * 
     * @return DirContext
     * @throws RepositoryException
     *         as the root exception for everything that can go wrong and eventually, sooner or later, will go wrong.
     */
    DirContext getDirContext() throws NamingException;

}
