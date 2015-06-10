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
package nl.knaw.dans.common.solr.converter;

import java.util.ArrayList;
import java.util.Collection;

import nl.knaw.dans.common.lang.search.Field;
import nl.knaw.dans.common.lang.search.IndexDocument;
import nl.knaw.dans.common.solr.SolrUtil;

import org.apache.solr.common.SolrInputDocument;

public class SolrDocumentConverter
{

    static public SolrInputDocument convert(IndexDocument doc)
    {
        SolrInputDocument result = new SolrInputDocument();
        for (Field<?> field : doc.getFields())
        {
            result.addField(field.getName(), SolrUtil.prepareObjectForSolrJ(field.getValue()), 1);
        }

        return result;
    }

    static public Collection<SolrInputDocument> convert(Collection<IndexDocument> indexDocuments)
    {
        Collection<SolrInputDocument> result = new ArrayList<SolrInputDocument>(indexDocuments.size());
        for (IndexDocument indexDoc : indexDocuments)
        {
            result.add(convert(indexDoc));
        }
        return result;
    }

}
