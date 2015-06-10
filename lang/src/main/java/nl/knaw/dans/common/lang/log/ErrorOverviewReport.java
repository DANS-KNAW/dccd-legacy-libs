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

public class ErrorOverviewReport extends OverviewReport
{

    public static final String DEFAULT_ERROR_FILENAME = "errors.csv";

    public ErrorOverviewReport()
    {
        super(DEFAULT_ERROR_FILENAME);
    }

    public ErrorOverviewReport(String fileName)
    {
        super(fileName);
    }

    public ErrorOverviewReport(EventPrinter eventPrinter)
    {
        super(DEFAULT_ERROR_FILENAME, eventPrinter);
    }

    public ErrorOverviewReport(String fileName, EventPrinter eventPrinter)
    {
        super(fileName, eventPrinter);
    }

    @Override
    public void info(Event event)
    {
        // we do not print info events
    }

    @Override
    public void warn(Event event)
    {
        // we do not print warning events
    }

}
