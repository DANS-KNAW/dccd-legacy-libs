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
package nl.knaw.dans.common.lang.search.bean.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import nl.knaw.dans.common.lang.search.bean.DefaultSearchFieldConverter;
import nl.knaw.dans.common.lang.search.bean.SearchFieldConverter;

/**
 * The search field annotation is used to annotate properties. The search field
 * is a mapping between an object property and a field inside an indexed search document.
 * It is assumed that for these properties public getters and setters are available.
 *  
 * @author lobo
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SearchField
{
    /**
     * The name of the field in the search index
     * @see nl.knaw.dans.common.lang.search.Field#getName()  
     */
    String name();

    /**
     * whether or not this property has to be required. If it is required,
     * but not returned from the search index or entered during conversion to
     * an index document an exception will be thrown
     * @return
     */
    boolean required() default false;

    /**
     * A converter class can be specified that is called when the search field
     * is converted from or to a document.
     * @return
     */
    Class<? extends SearchFieldConverter<?>> converter() default DefaultSearchFieldConverter.class;
}
