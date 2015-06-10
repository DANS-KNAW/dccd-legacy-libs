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

import nl.knaw.dans.common.lang.search.exceptions.SearchBeanConverterException;

/**
 * A search field converter converts from and to a field value. The field value
 * is gotten from and saved into the search index. It currently depends on the
 * search engine implementation how the object will come out of the index.  
 * 
 * @param <T> the type of the search field
 * 
 * @author lobo
 */
public interface SearchFieldConverter<T>
{
    T fromFieldValue(Object in) throws SearchBeanConverterException;

    Object toFieldValue(T in) throws SearchBeanConverterException;
}
