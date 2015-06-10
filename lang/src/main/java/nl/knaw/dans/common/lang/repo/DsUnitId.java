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
package nl.knaw.dans.common.lang.repo;

import java.util.regex.Pattern;

public class DsUnitId
{

    private static final String REG_EX = "[a-zA-Z0-9-\\._~$()+\\[\\]]*";
    private static final Pattern PATTERN = Pattern.compile(REG_EX);

    private final String unitId;

    public static boolean isValidId(String value)
    {
        if (value == null || "".equals(value))
        {
            return false;
        }
        return PATTERN.matcher(value).matches();
    }

    public DsUnitId(String unitId)
    {
        if (isValidId(unitId))
        {
            this.unitId = unitId;
        }
        else
        {
            throw new IllegalArgumentException("Not a valid unitId: " + unitId);
        }
    }

    public String getUnitId()
    {
        return unitId;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof DsUnitId)
        {
            DsUnitId other = (DsUnitId) obj;
            return this.unitId.equals(other.unitId);
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return unitId.length() + unitId.hashCode();
    }

    @Override
    public String toString()
    {
        return unitId;
    }

}
