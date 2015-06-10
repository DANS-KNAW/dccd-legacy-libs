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
package nl.knaw.dans.common.lang.repo;

import nl.knaw.dans.common.lang.repo.exception.InvalidSidException;

/**
 * Repository util class.
 *
 * @author lobo
 */
public class RepoUtil
{
    public static String getNamespaceFromSid(String sid) throws InvalidSidException
    {
        int ns = sid.indexOf(':');
        if (ns <= 0)
            throw new InvalidSidException("Store ID " + sid + " is not a valid store ID");
        return sid.substring(0, ns);
    }
}
