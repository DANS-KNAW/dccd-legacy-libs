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

import java.util.Locale;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;

/**
 * Translates a string using a property.
 * 
 * @author lobo
 */
public class ResourceTranslator implements Translator<String>
{
    private static final long serialVersionUID = -5288594668340132408L;

    private String prefix = "";

    private String postfix = "";

    public ResourceTranslator()
    {
    }

    public ResourceTranslator(String prefix)
    {
        this.prefix = prefix;
    }

    public ResourceTranslator(String prefix, String postfix)
    {
        this.prefix = prefix;
        this.postfix = postfix;
    }

    public IModel<String> getTranslation(String originalValue, Locale locale, boolean fullName)
    {
        return new ResourceModel(prefix + originalValue + postfix);
    }

}
