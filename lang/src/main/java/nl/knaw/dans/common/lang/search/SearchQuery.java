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

/**
 * A search query is usually what the user wants to search for 
 * 
 * The result of the search query object is a string that contains the
 * query. This string might however be the result of some fancy 
 * query builder instead of directly working with a string.
 *  
 * @author lobo
 */
public interface SearchQuery extends Serializable
{

    /**
     * Gets the query string. 
     */
    String getQueryString();
}
