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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nl.knaw.dans.common.lang.search.FacetField;
import nl.knaw.dans.common.lang.search.SearchHit;
import nl.knaw.dans.common.lang.search.SearchResult;
import nl.knaw.dans.common.lang.search.exceptions.FieldNotFoundException;

/**
 * An empty result place holder.  
 *
 * @author lobo
 * @param <T> the type of the search hits
 */
public class EmptySearchResult<T> implements SearchResult<T>
{
    private static final long serialVersionUID = 6240442564596343488L;

    public int getTotalHits()
    {
        return 0;
    }

    public List<SearchHit<T>> getHits()
    {
        return new ArrayList<SearchHit<T>>(0);
    }

    public List<FacetField> getFacets()
    {
        return Collections.emptyList();
    }

    public FacetField getFacetByName(String facetFieldName) throws FieldNotFoundException
    {
        throw new FieldNotFoundException(facetFieldName);
    }

    public boolean useRelevanceScore()
    {
        return false;
    }

}
