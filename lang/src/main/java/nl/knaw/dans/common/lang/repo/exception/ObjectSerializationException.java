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

/**
 * Signals an exception while serializing an object.
 * 
 * @author ecco Sep 24, 2009
 */
public class ObjectSerializationException extends ConverterException
{

    private static final long serialVersionUID = -2486810834396468739L;

    // CHECKSTYLE: OFF 
    public ObjectSerializationException()
    {
    }

    public ObjectSerializationException(final String message)
    {
        super(message);
    }

    public ObjectSerializationException(final Throwable cause)
    {
        super(cause);
    }

    public ObjectSerializationException(final String message, final Throwable cause)
    {
        super(message, cause);
    }

}
