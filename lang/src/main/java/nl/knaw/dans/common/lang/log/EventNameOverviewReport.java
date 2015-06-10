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
package nl.knaw.dans.common.lang.log;

public class EventNameOverviewReport extends OverviewReport
{

    public static final String DEFAULT_EVENT_NAME = RL.GLOBAL;

    private final String eventName;

    public EventNameOverviewReport()
    {
        this(DEFAULT_EVENT_NAME);
    }

    public EventNameOverviewReport(String eventName)
    {
        this(eventName, null);
    }

    public EventNameOverviewReport(String eventName, EventPrinter eventPrinter)
    {
        super(eventPrinter);
        this.eventName = eventName;
    }

    @Override
    public String getFileName()
    {
        return eventName + "-" + super.getFileName();
    }

    @Override
    public void info(Event event)
    {
        if (eventName.equals(event.getEventName()))
            super.info(event);
    }

    @Override
    public void warn(Event event)
    {
        if (eventName.equals(event.getEventName()))
            super.warn(event);
    }

    @Override
    public void error(Event event)
    {
        if (eventName.equals(event.getEventName()))
            super.error(event);
    }

}
