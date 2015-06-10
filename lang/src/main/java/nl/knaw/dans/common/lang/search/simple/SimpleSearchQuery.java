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

import nl.knaw.dans.common.lang.search.SearchQuery;

public class SimpleSearchQuery implements SearchQuery
{
    private static final long serialVersionUID = 2826106086319493869L;

    private String queryString;

    public SimpleSearchQuery(String queryString)
    {
        this.queryString = queryString;
    }

    public String getQueryString()
    {
        return queryString;
    }

    /**
     * Puts an OR operator between the values.  
     * @param values
     * @return
     */
    public static String OrValues(Object... values)
    {
        if (values.length == 0)
            return "";

        String q = values[0].toString();
        if (values.length > 1)
        {
            q = "(";
            for (int i = 0; i < values.length; i++)
            {
                q += values[i].toString();
                if (i + 1 < values.length)
                    q += " OR ";
            }
            q += ")";
        }

        return q;
    }

}
