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
package nl.knaw.dans.common.wicket.components.search.model;

import java.io.Serializable;

import nl.knaw.dans.common.lang.search.SearchResult;
import nl.knaw.dans.common.lang.search.simple.EmptySearchResult;

/**
 * Contains all data properties needed for creating search requests
 * and storing the search results. 
 * 
 * The search request is created by the SearchRequestBuilder. The
 * SearchRequestBuilder holds the information on how the search request
 * should be configured. If the search request has been issued to
 * the search engine and the search results are written back to this
 * object then SearchData is not in a dirty state. If the object is in
 * a dirty state then that means a new search needs to be executed and
 * the search result needs to be updated.
 * 
 * @see SearchRequestBuilder
 */
public class SearchData implements Serializable
{
    private static final long serialVersionUID = -5084263718210205998L;

    private SearchResult<?> result = null;

    private final SearchRequestBuilder requestBuilder = new SearchRequestBuilder();

    /**
     * This object is dirty when the search request builder is dirty or 
     * this property has been set to dirty. If this object is dirty it
     * means the current search request does not lead to the current
     * search results.
     */
    private boolean dirty = true;

    public SearchData()
    {
    }

    public SearchRequestBuilder getRequestBuilder()
    {
        return requestBuilder;
    }

    public SearchResult<?> getResult()
    {
        return result == null ? new EmptySearchResult() : result;
    }

    public void setResult(SearchResult<?> result)
    {
        this.result = result;

        this.requestBuilder.setDirty(false);
        dirty = false;
    }

    public boolean isDirty()
    {
        return dirty || getRequestBuilder().isDirty();
    }

    public void setDirty(boolean dirty)
    {
        this.dirty = dirty;
    }

}
