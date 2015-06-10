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
package nl.knaw.dans.common.wicket.components.search;

import nl.knaw.dans.common.lang.search.SearchRequest;
import nl.knaw.dans.common.lang.search.SearchResult;
import nl.knaw.dans.common.wicket.components.CommonPanel;
import nl.knaw.dans.common.wicket.components.search.model.SearchData;
import nl.knaw.dans.common.wicket.components.search.model.SearchModel;
import nl.knaw.dans.common.wicket.components.search.model.SearchRequestBuilder;

/**
 * Panels that work with the SearchModel and SearchResources extend 
 * this class. The extending panel should be used by a SearchPanel
 * or any other component that has the power to provide an updated
 * SearchModel.
 * 
 * @see SearchPanel
 * @see SearchModel
 *
 * @author lobo
 */
public class BaseSearchPanel extends CommonPanel implements SearchResources
{
    private static final long serialVersionUID = -1388009453526753597L;

    public BaseSearchPanel(String wicketId)
    {
        super(wicketId);
    }

    public BaseSearchPanel(String wicketId, SearchModel searchModel)
    {
        super(wicketId, searchModel);
    }

    public SearchModel getSearchModel()
    {
        return (SearchModel) getDefaultModel();
    }

    protected SearchData getSearchData()
    {
        return getSearchModel().getObject();
    }

    protected SearchResult<?> getSearchResult()
    {
        return getSearchData().getResult();
    }

    protected SearchRequest getSearchRequest()
    {
        return getRequestBuilder().getRequest();
    }

    protected SearchRequestBuilder getRequestBuilder()
    {
        return getSearchData().getRequestBuilder();
    }

    protected void setSearchModel(SearchModel searchModel)
    {
        setDefaultModel(searchModel);
    }
}
