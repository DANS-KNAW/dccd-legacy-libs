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
package nl.knaw.dans.common.lang.service.exceptions;

import java.util.List;

public class TemporaryUnAvailableException extends CommonSecurityException
{

    private static final long serialVersionUID = -3983666001841428586L;

    public TemporaryUnAvailableException(String message)
    {
        super(message);
    }

    public TemporaryUnAvailableException(String message, List<Object> hints)
    {
        super(message, hints);
    }

    public TemporaryUnAvailableException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public TemporaryUnAvailableException(Throwable cause)
    {
        super(cause);
    }

}
