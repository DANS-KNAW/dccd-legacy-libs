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
package nl.knaw.dans.common.lang;

/**
 * Wrapper class for exceptions that take place during sustaining, updating, or clearing a cache.
 * 
 * @author ecco Apr 30, 2009
 */
public class CacheException extends Exception
{

    private static final long serialVersionUID = -6007198469837665263L;

    // ecco (Sep 29, 2009): CHECKSTYLE: OFF 

    public CacheException()
    {
    }

    public CacheException(final String message)
    {
        super(message);
    }

    public CacheException(final Throwable cause)
    {
        super(cause);
    }

    public CacheException(final String message, final Throwable cause)
    {
        super(message, cause);
    }

}
