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

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reports to {@link Logger}.
 *
 */
public class LoggerReport implements Report
{

    private static final Logger logger = LoggerFactory.getLogger(LoggerReport.class);

    private EventPrinter printer;

    public LoggerReport()
    {

    }

    public LoggerReport(EventPrinter eventPrinter)
    {
        this.printer = eventPrinter;
    }

    protected EventPrinter getPrinter()
    {
        if (printer == null)
        {
            printer = new Printer();
        }
        return printer;
    }

    @Override
    public void info(Event event)
    {
        logger.info(getPrinter().print(event));
    }

    @Override
    public void warn(Event event)
    {
        if (event.hasCause())
        {
            logger.warn(getPrinter().print(event), event.getCause());
        }
        else
        {
            logger.warn(getPrinter().print(event));
        }
    }

    @Override
    public void error(Event event)
    {
        if (event.hasCause())
        {
            logger.error(getPrinter().print(event), event.getCause());
        }
        else
        {
            logger.error(getPrinter().print(event));
        }
    }

    /**
     * Does nothing.
     */
    @Override
    public void close()
    {
        // nothing to close
    }

    /**
     * Does nothing.
     */
    @Override
    public void setReportLocation(File reportLocation, boolean allRW)
    {
        // nothing to set. this is not a file report
    }

    public static class Printer implements EventPrinter
    {

        @Override
        public String printHeader(Event event)
        {
            return "no header";
        }

        @Override
        public String print(Event event)
        {
            StringBuilder sb = new StringBuilder(event.getLevel()).append(SPACE); //
            sb.append(event.getEventName()).append(SEPARATOR).append(SPACE);
            for (String message : event.getMessages())
            {
                sb.append(message).append(SEPARATOR).append(SPACE);
            }
            sb.append(event.getSourceLink()).append(SPACE);
            if (event.hasCause())
            {
                sb.append(event.getCause().toString());
            }
            return sb.toString();
        }

    }

}
