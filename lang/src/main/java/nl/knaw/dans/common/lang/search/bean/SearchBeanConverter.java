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
package nl.knaw.dans.common.lang.search.bean;

import nl.knaw.dans.common.lang.search.IndexDocument;
import nl.knaw.dans.common.lang.search.exceptions.SearchBeanConverterException;
import nl.knaw.dans.common.lang.search.exceptions.SearchBeanException;

/**
 * A search bean converter is responsible for converting a search bean to an 
 * index document that can be written to the search engine.
 *
 * @param <T> the search bean type
 *  
 * @author lobo
 */
public interface SearchBeanConverter<T>
{
    IndexDocument toIndexDocument(T searchBean) throws SearchBeanConverterException, SearchBeanException;
}
