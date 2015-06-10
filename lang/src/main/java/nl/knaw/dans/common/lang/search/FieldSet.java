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
import java.util.Set;

/**
 * A set of fields. The set is kept unique by the field name. Inherits
 * from the Set interface, so it can be used as a collection.
 *
 * @param <T> the type of the field value (might be mixed)
 * 
 * @author lobo
 */
public interface FieldSet<T> extends Set<Field<T>>, Serializable
{

    /**
     * Gets a field by its name. If it cannot be found it returns null.
     * @param name the name of the field
     * @return the field
     */
    Field<T> getByFieldName(String name);
}
