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
package nl.knaw.dans.common.lang.security.authz;

import java.io.Serializable;

import org.joda.time.DateTime;

public class AuthzMessage implements Serializable
{

    private static final long serialVersionUID = 7393025669154646819L;
    private final String messageCode;
    private final DateTime date;

    public AuthzMessage(String messageCode)
    {
        this.messageCode = messageCode;
        this.date = null;
    }

    public AuthzMessage(String messageCode, DateTime date)
    {
        this.messageCode = messageCode;
        this.date = date;
    }

    public boolean hasDate()
    {
        return date != null;
    }

    public String getMessageCode()
    {
        return messageCode;
    }

    public DateTime getDate()
    {
        return date;
    }

    @Override
    public String toString()
    {
        return super.toString() + " messageCode=" + messageCode + " date=" + date;
    }

}
