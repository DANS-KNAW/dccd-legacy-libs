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

import nl.knaw.dans.common.lang.search.simple.SimpleSearchRequest;

import org.apache.wicket.model.IModel;

/**
 * A search criterium is an object that can apply changes to a search request.
 * Search criteria are the primary way of updating the search request. 
 * 
 * The search criteria are made displayable by the SearchCriteriaPanel.
 * @see nl.knaw.dans.common.wicket.components.search.criteria.SearchCriteriaPanel
 *
 * @author lobo
 */
public interface SearchCriterium extends Serializable
{
    /**
     * @return a string model that is used by the CriteriaPanel for displaying
     * a link or label text belonging to this criterium.
     */
    IModel<String> getLabelModel();

    /**
     * Applies this criterium to a searchRequest 
     * @param searchRequest
     */
    void apply(SimpleSearchRequest searchRequest);
}
