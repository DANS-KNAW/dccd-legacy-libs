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
package nl.knaw.dans.common.ldap.repo;

import nl.knaw.dans.common.lang.ldap.DateTimeTranslator;
import nl.knaw.dans.common.lang.ldap.OperationalAttributes;

import org.joda.time.DateTime;

public class LdapOperationalAttributes implements OperationalAttributes
{

    private static DateTimeTranslator TRANSLATOR = new DateTimeTranslator();

    private DateTime createTimestamp;

    private DateTime modifyTimestamp;

    protected LdapOperationalAttributes()
    {

    }

    public DateTime getCreateTimestamp()
    {
        return createTimestamp;
    }

    public DateTime getModifyTimestamp()
    {
        return modifyTimestamp;
    }

    protected void setCreateTime(String creationTime)
    {
        createTimestamp = parseDateTime(creationTime);
    }

    protected void setModifyTime(String modifyTime)
    {
        modifyTimestamp = parseDateTime(modifyTime);
    }

    protected static DateTime parseDateTime(String s)
    {
        return TRANSLATOR.fromLdap(s);
    }

}
