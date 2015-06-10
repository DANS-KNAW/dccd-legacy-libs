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
package nl.knaw.dans.common.lang.exception;

/**
 * Indicates an attempt has been made to modify a value that is read only.
 *
 */
public class ReadOnlyException extends RuntimeException
{

    private static final long serialVersionUID = -1400434570706805802L;

    public ReadOnlyException()
    {

    }

    public ReadOnlyException(String msg)
    {
        super(msg);
    }

    public ReadOnlyException(Throwable cause)
    {
        super(cause);
    }

    public ReadOnlyException(String msg, Throwable cause)
    {
        super(msg, cause);
    }

}
