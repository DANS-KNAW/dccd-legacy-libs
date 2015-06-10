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
package nl.knaw.dans.common.wicket.components;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class DateTimeLabel extends Label
{
    //TODO alternative constructors with an enum with property keys for format styles,
    // such as date datetime time short and long versions /  locale?
    private static final DateTime UNKNOWN_DATE_TIME = new DateTime("0000-01-01");

    private static final long serialVersionUID = 155555555L;

    /**
     * @param id wicket id of the markup container
     * @param dateTime the value to be displayed.
     * @param format see {@link DateTimeFormat#forPattern(String)}
     */
    public DateTimeLabel(final String id, final DateTime dateTime, final String format)
    {
        this(id, dateTime, new Model<String>(format));
    }

    /**
     * @param id wicket id of the markup container
     * @param dateTime the value to be displayed.
     * @param formatModel a string model, see {@link DateTimeFormat#forPattern(String)}
     */
    public DateTimeLabel(final String id, final DateTime dateTime, final IModel<String> formatModel)
    {
        super(id, new Model<String>()
        {

            private static final long serialVersionUID = 1139426060975374951L;

            @Override
            public String getObject()
            {
                final DateTime dt = dateTime;
                if (dt == null || UNKNOWN_DATE_TIME.equals(dt))
                    return "";
                final String format = formatModel.getObject();
                return DateTimeFormat.forPattern(format).print(dt);
            }
        });
    }

    /**
     * @param id wicket id of the markup container
     * @param format see {@link DateTimeFormat#forPattern(String)}
     * @param dateTimeModel getObject returns the {@link DateTime} object to display.
     */
    public DateTimeLabel(final String id, final String format, final IModel<DateTime> dateTimeModel)
    {
        super(id, new Model<String>()
        {

            private static final long serialVersionUID = 1139426060975374951L;

            @Override
            public String getObject()
            {
                final DateTime dateTime = dateTimeModel.getObject();
                if (dateTime == null || UNKNOWN_DATE_TIME.equals(dateTime))
                    return "";
                return DateTimeFormat.forPattern(format).print(dateTime);
            }
        });
    }
}
