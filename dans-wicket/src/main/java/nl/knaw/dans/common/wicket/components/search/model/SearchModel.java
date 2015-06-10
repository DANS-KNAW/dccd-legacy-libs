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

import java.util.List;

import nl.knaw.dans.common.wicket.exceptions.InternalWebError;

import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The model for the search related components. This model contains SearchData
 * and a few convenience methods for working with SearchData. See the javadoc 
 * of SearchData for more info. 
 *
 * @see SearchData
 * @author lobo
 */
public class SearchModel implements IModel<SearchData>
{
    private static final long serialVersionUID = 2540244607992268707L;
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchModel.class);

    private final SearchData searchData;

    public SearchModel()
    {
        this(null);
    }

    public SearchModel(SearchCriterium searchCriterium)
    {
        searchData = new SearchData();
        if (searchCriterium != null)
        {
            searchData.getRequestBuilder().addCriterium(searchCriterium);
        }
    }

    public SearchData getObject()
    {
        return searchData;
    }

    public void setObject(SearchData object)
    {
        LOGGER.error("SearchModel.setObject() not allowed.");
        throw new InternalWebError();
    }

    public void detach()
    {
    }

    List<SearchCriterium> getCriteria()
    {
        return getRequestBuilder().getCriteria();
    }

    public SearchRequestBuilder getRequestBuilder()
    {
        return getObject().getRequestBuilder();
    }

    public void addCriterium(SearchCriterium criterium)
    {
        getRequestBuilder().addCriterium(criterium);
    }

    public void removeCriterium(SearchCriterium criterium)
    {
        getRequestBuilder().removeCriterium(criterium);
    }

}
