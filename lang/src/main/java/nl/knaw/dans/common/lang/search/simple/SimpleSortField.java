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
package nl.knaw.dans.common.lang.search.simple;

import nl.knaw.dans.common.lang.search.SortField;
import nl.knaw.dans.common.lang.search.SortOrder;
import nl.knaw.dans.common.lang.search.SortType;

public class SimpleSortField extends SimpleField<SortOrder> implements SortField
{
    private static final long serialVersionUID = -1932854592158278674L;

    /**
     *  default sort type is BY_VALUE
     */
    private SortType sortType = SortType.BY_VALUE;

    public SimpleSortField(String name, SortOrder value)
    {
        super(name, value);
    }

    public SimpleSortField(String name, SortOrder value, SortType type)
    {
        super(name, value);
        setSortType(type);
    }

    public SortType getSortType()
    {
        return sortType;
    }

    public void setSortType(SortType sortType)
    {
        this.sortType = sortType;
    }

    @Override
    public String toString()
    {
        return super.toString() + "[sortType = '" + sortType.toString() + "']";
    }
}
