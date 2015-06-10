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
package nl.knaw.dans.common.fedora.fox;

import nl.knaw.dans.common.jibx.AbstractJiBXObject;

import org.joda.time.DateTime;

public class AuditRecord extends AbstractJiBXObject<AuditRecord>
{
    private static final long serialVersionUID = 8189909610042140432L;

    private String id;
    private String processType;
    private String action;
    private String componentId;
    private String responsibility;
    private DateTime dateTime;
    private String justification;

    public String getId()
    {
        return id;
    }

    public String getProcessType()
    {
        return processType;
    }

    public String getAction()
    {
        return action;
    }

    public String getComponentId()
    {
        return componentId;
    }

    public String getResponsibility()
    {
        return responsibility;
    }

    public DateTime getDateTime()
    {
        return dateTime;
    }

    public String getJustification()
    {
        return justification;
    }

}
