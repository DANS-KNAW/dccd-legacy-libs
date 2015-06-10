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

import nl.knaw.dans.common.lang.search.Document;
import nl.knaw.dans.common.lang.search.exceptions.SearchBeanException;
import nl.knaw.dans.common.lang.search.exceptions.SearchBeanFactoryException;

/**
 * The search bean factory is responsible for the creation of search bean based
 * on an document coming from the search index. The factory also is able to
 * return the right search bean converter for a class for the reverse process. 
 * 
 * @author lobo
 */
public interface SearchBeanFactory
{
    Object createSearchBean(String typeIdentifier, Document document) throws SearchBeanFactoryException, SearchBeanException;

    SearchBeanConverter<?> getSearchBeanConverter(Class<?> clazz) throws SearchBeanFactoryException, SearchBeanException;
}
