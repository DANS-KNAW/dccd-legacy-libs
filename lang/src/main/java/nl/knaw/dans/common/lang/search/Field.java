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
 * Search index documents contain fields which are basically named values
 * (key value pairs). The value can be of different types (T).
 *
 * @author lobo
 *
 * @param <T> the value type.
 */
public interface Field<T> extends Serializable
{
    T getValue();

    void setValue(T value);

    /**
     * @return the name of the field as specified by the search index schema.
     * The name of a field must be unique in an index.
     */
    String getName();

    /**
     * Sets the name of the field.
     * @see #getName()
     */
    void setName(String name);

}
