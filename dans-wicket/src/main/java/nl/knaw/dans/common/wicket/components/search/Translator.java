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
package nl.knaw.dans.common.wicket.components.search;

import java.io.Serializable;
import java.util.Locale;

import org.apache.wicket.model.IModel;

/**
 * Simple interface to translate an original value according to a locale. A translator
 * model might also do the trick and may be more elegant, but I've already done it 
 * like this..
 * 
 * @author lobo
 *
 * @param <T> the type of the original value
 */
public interface Translator<T> extends Serializable
{
    IModel<String> getTranslation(T originalValue, Locale locale, boolean fullName);
}
