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
package nl.knaw.dans.common.lang.xml;

/**
 * General exception signaling an exception while handling xml.
 * 
 * @author ecco Sep 27, 2009
 */
public class XMLException extends Exception
{

    private static final long serialVersionUID = 8380352169698292747L;

    // CHECKSTYLE: OFF 

    public XMLException()
    {
    }

    public XMLException(String message)
    {
        super(message);
    }

    public XMLException(Throwable cause)
    {
        super(cause);
    }

    public XMLException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
