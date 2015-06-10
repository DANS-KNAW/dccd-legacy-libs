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
 * Documents form the basis of the the content of the search index.
 * They are stored as a collection of fields. An index can be likened
 * to a single table of a database, whereas the rows would be documents.
 * 
 * @author lobo
 *
 */
public interface Document extends Serializable
{
    /**
     * @return the fields contained by the document
     */
    FieldSet<?> getFields();

    /**
     * Convenience method for retrieving a specific field
     * by name
     * @param fieldName
     * @return
     */
    Field<?> getFieldByName(String fieldName);
}
