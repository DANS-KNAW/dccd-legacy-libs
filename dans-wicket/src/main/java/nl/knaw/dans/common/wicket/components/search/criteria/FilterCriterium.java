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

import nl.knaw.dans.common.lang.search.Field;
import nl.knaw.dans.common.lang.search.simple.SimpleSearchRequest;

import org.apache.wicket.model.IModel;

public class FilterCriterium extends AbstractSearchCriterium
{

    private static final long serialVersionUID = 1795048166011045297L;

    private final Field<?> field;

    public FilterCriterium(Field<?> field, IModel<String> labelModel)
    {
        super(labelModel);
        this.field = field;
    }

    @Override
    public void apply(SimpleSearchRequest searchRequest)
    {
        searchRequest.addFilterQuery(field);
    }

    public Field<?> getField()
    {
        return field;
    }

}
