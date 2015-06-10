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
 * The copy field annotation can be used in conjunction with the search field
 * annotation to create a secondary value of some kind. The copy field is
 * not read from the search index; it is only written to the search index.
 *  
 * @author lobo
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CopyField
{
    /**
     * the name of the field in the search index
     */
    String name();

    /**
     * the postfix added to the getter of this field. For example: if 
     * the property name is "foo" and the getterPostfix is "bar" then
     * the getter called for this copyfield is getFoobar() 
     */
    String getterPostfix();

    /**
     * Whether or not the copyfield getter may return null or not. 
     */
    boolean required() default false;

    /** 
     * A converter class for converting to and from a copy field. Since copyfields
     * are only used for converting to something and never from only that function
     * will be called. 
     */
    Class<? extends SearchFieldConverter<?>> converter() default DefaultSearchFieldConverter.class;
}
