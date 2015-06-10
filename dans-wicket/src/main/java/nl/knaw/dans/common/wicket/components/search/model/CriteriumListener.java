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
import java.util.List;

import nl.knaw.dans.common.wicket.components.search.facets.FacetConfig;

/**
 * A CriteriumListener is notified of updates in searchCriteria and when an initial list of
 * {@link FacetConfig}s is set on the {@link SearchRequestBuilder}.
 */
public interface CriteriumListener extends Serializable
{

    /**
     * A searchCriterium was added to the requestBuilder.
     * 
     * @param searchCriterium
     *        criterium added.
     * @param searchRequestBuilder
     *        the active requestBuilder.
     */
    void onCriteriumAdded(SearchCriterium searchCriterium, SearchRequestBuilder searchRequestBuilder);

    void onCriteriumRemoved(SearchCriterium searchCriterium, SearchRequestBuilder searchRequestBuilder);

    void addFacets(List<FacetConfig> refineFacets, SearchRequestBuilder searchRequestBuilder);

}
