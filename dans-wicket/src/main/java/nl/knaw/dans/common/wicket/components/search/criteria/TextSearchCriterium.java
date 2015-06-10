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
package nl.knaw.dans.common.wicket.components.search.criteria;

import nl.knaw.dans.common.lang.search.simple.SimpleSearchQuery;
import nl.knaw.dans.common.lang.search.simple.SimpleSearchRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.wicket.model.IModel;

/**
 * A simple search criterium based on a text based search query. 
 * 
 * @author lobo
 */
public class TextSearchCriterium extends AbstractSearchCriterium
{
    private static final long serialVersionUID = 8932075173626854009L;

    private final String searchText;

    public TextSearchCriterium(String searchText, IModel<String> labelModel)
    {
        super(labelModel);
        this.searchText = searchText;
    }

    @Override
    public void apply(SimpleSearchRequest sr)
    {
        String q = sr.getQuery().getQueryString();
        if (StringUtils.isEmpty(q))
            q = searchText;
        else
            q = q + " " + searchText;
        sr.setQuery(new SimpleSearchQuery(q));
    }

    public String getSearchText()
    {
        return searchText;
    }

}
