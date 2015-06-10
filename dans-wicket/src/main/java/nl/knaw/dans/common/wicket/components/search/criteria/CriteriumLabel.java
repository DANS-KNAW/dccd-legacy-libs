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

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

/**
 * A label used for a criteria
 * 
 * @author lobo
 */
public class CriteriumLabel extends Label
{
    public static final String FILTER_SEPARATOR = ": ";

    private static final long serialVersionUID = -690179496317797759L;

    public CriteriumLabel(String id, IModel<String> model)
    {
        super(id, model);
    }

    /**
     * Creates a label text using a standard layout
     * @param filter what are we filtering for?
     * @param filterBy what are we filtering on?
     * @return a label text using a standard layout
     */
    public static String createFilterText(String filter, String filterBy)
    {
        return filter + FILTER_SEPARATOR + filterBy;
    }

}
