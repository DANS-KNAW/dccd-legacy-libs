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

import java.util.List;

import nl.knaw.dans.common.lang.search.Field;
import nl.knaw.dans.common.lang.search.simple.SimpleSearchRequest;

import org.apache.wicket.model.IModel;

/**
 * A search criterium that adds a filter query on one or more fields. This
 * comes in handy for an advanced search. 
 * 
 * 26-7-2010: Unfortantely Solr does not support hit highlighting for filter queries, but
 * only for field queries. But field queries are not allowed for the Dismax
 * handler. A highly recommended handler for user based searches. Apparently
 * Solr 1.5 will have a great solution for that, but by that time I am already in
 * Thailand drinking from a coconut.  
 * 
 * @author lobo
 */
public class MultiFilterCriterium extends AbstractSearchCriterium
{
    private static final long serialVersionUID = -4451822971051448512L;

    private final List<Field<?>> fields;

    private IModel<String> prefixLabelModel;

    public MultiFilterCriterium(List<Field<?>> fields, IModel<String> labelModel)
    {
        super(labelModel);
        this.fields = fields;
    }

    @Override
    public void apply(SimpleSearchRequest sr)
    {
        for (Field<?> field : fields)
            sr.addFilterQuery(field);
    }

    public List<Field<?>> getFields()
    {
        return fields;
    }

}
