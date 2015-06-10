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
 * Refers to a single index in a search engine by name. This object is
 * a container for additional descriptive metadata on the search index.
 * 
 * @author lobo
 */
public interface Index extends Serializable
{
    /**
     * @return the name of the index
     */
    String getName();

    /**
     * @return the name of the primary key (a.k.a unique field) field of 
     * the documents in this index.  
     */
    String getPrimaryKey();
}
