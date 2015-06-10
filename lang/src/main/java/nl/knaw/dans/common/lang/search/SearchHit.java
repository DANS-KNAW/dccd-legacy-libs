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
package nl.knaw.dans.common.lang.search;

import java.io.Serializable;
import java.util.List;

/**
 * A search hit is one of the results of a search request on the search engine. 
 * It contains a document (in either the form of a document or the form of a 
 * search bean) and some metadata about how the document was found. A search hit
 * is immutable.
 *
 * @param <T> the type of the document that was found
 *
 * @author lobo
 */
public interface SearchHit<T> extends Serializable
{
    T getData();

    /**
     * @return  a list of snippet fields that highlight the reason why this
     * hit was found. Snippets are currently only available if the SearchRequest
     * had highlighting enabled. 
     */
    List<SnippetField> getSnippets();

    /**
     * A convenience method for retrieving a snippet field by its name.
     * Snippets are currently only available if the SearchRequest
     * had highlighting enabled.
     * @param fieldName the name of the snippet field
     * @return a snippet field
     */
    SnippetField getSnippetByName(String fieldName);

    /**
     * @return the relevance score the search engine returned for the
     * this hit. Use the SearchResult.getMaxRelevanceScore() to calculate
     * a relevance percentage.
     */
    float getRelevanceScore();
}
