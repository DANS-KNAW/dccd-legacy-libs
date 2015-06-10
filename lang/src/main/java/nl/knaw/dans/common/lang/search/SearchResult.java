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
package nl.knaw.dans.common.lang.search;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import nl.knaw.dans.common.lang.search.exceptions.FieldNotFoundException;

/**
 * A search result is basically a list of search hits with some 
 * additional metadata. It is the direct result of a search operation.
 *
 * @param <T> the type of the found documents  
 * 
 * @author lobo
 */
public interface SearchResult<T> extends Serializable
{
    /**
     * @return a list of search hits
     */
    List<SearchHit<T>> getHits();

    /**
     * The total number of hits found. Note this might not the same
     * as the number of hits returned (i.e. getHits().size()) as a
     * limit might have been set by the SearchRequest.  
     * @return
     */
    int getTotalHits();

    /**
     * @return a list of facets if faceting was enabled on the SearchRequest
     */
    Collection<FacetField> getFacets();

    /**
     * A convenience method for getting a specific facet field by its name.
     * @param facetFieldName the name of the facet field
     * @return the facet field
     * @throws FieldNotFoundException thrown if the facet field was not found
     */
    FacetField getFacetByName(String facetFieldName) throws FieldNotFoundException;

    /**
     * Whether or not the relevance score is of any use. If all search hits
     * are of the same relevance score the relevance score is not very
     * relevant, is it? :)
     * @return whether to use the relevance scores or not
     */
    boolean useRelevanceScore();
}
