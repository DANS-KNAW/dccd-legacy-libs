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
package nl.knaw.dans.common.search.bean;

import java.util.Date;
import java.util.List;

import nl.knaw.dans.common.lang.search.bean.annotation.CopyField;
import nl.knaw.dans.common.lang.search.bean.annotation.SearchBean;
import nl.knaw.dans.common.lang.search.bean.annotation.SearchField;

import org.joda.time.DateTime;

@SearchBean(defaultIndex = DummyIndex.class, typeIdentifier = "dummy")
public class DummySB
{

    public final static String ID_NAME = "id";
    @SearchField(name = ID_NAME)
    private Integer id;

    public static final String NAME_NAME = "name";
    public static final String COPYNAME_NAME = "name2";
    @SearchField(name = NAME_NAME, required = true)
    @CopyField(name = COPYNAME_NAME, getterPostfix = "2")
    private String name;

    public static final String ADDRESSES_NAME = "addresses";
    @SearchField(name = ADDRESSES_NAME)
    private List<String> addresses;

    public static final String CURDATE_NAME = "curdate";
    @SearchField(name = CURDATE_NAME)
    private Date currentDate;

    public static final String DATES_NAME = "dates";
    @SearchField(name = DATES_NAME)
    private List<DateTime> dates;

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public String getName2()
    {
        return name + "_copied";
    }

    public void setAddresses(List<String> addresses)
    {
        this.addresses = addresses;
    }

    public List<String> getAddresses()
    {
        return addresses;
    }

    public void setDates(List<DateTime> dates)
    {
        this.dates = dates;
    }

    public List<DateTime> getDates()
    {
        return dates;
    }

    public void setCurrentDate(Date currentDate)
    {
        this.currentDate = currentDate;
    }

    public Date getCurrentDate()
    {
        return currentDate;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
}
