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
package nl.knaw.dans.common.wicket;

import java.util.MissingResourceException;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.IChoiceRenderer;

/**
 * Renders one choice of an enum object. The 'id' values used for internal representation is the
 * name of the enum instance. This value is also (part of) the key to look up the 'display value' in
 * the resource. The 'display value' is the first non null value of the following list:
 * <ul>
 * <li>resourceProvider.getString(&lt;resourceId>.&lt;enum.value></li>
 * <li>resourceProvider.getString(&lt;enum.value>)</li>
 * <li>&lt;enum.value></li>
 * </ul>
 * example: <br>
 * <br>
 * Container.java
 * 
 * <pre>
 *   public class Container extends ...
 *   {
 *     class enum Foo {bar};
 *     ...() {
 *         final IChoiceRenderer renderer = new EnumChoiceRenderer(this,"qualifier");
 *         final List<String> choiceList = Arrays.asList(Foo.values());
 *         add(new DropDownChoice("selectFoo",model,choiceList,renderer));
 *     }
 *   }
 * </pre>
 * 
 * Container.properties
 * 
 * <pre>
 *     qualifier.null=-Choose one-
 *     qualifier.bar=Bar
 * </pre>
 * 
 * Container.html
 * 
 * <pre>
 *     &lt;select wicket:id="selectFoo">&lt;/select>
 * </pre>
 * 
 * generated html:
 * 
 * <pre>
 *     &lt;select name="...:selectFoo" wicket:id="selectFoo">&lt;/select>
 *     &lt;option value="" selected="selected">-Choose one-&lt;/option>
 *     &lt;option value="bar">Bar&lt;/option>
 *     &lt;/select>
 * </pre>
 * 
 * adapted from http://techblog.molindo.at/2008/01/wicket-choicerenderer-for-enums.html by Michael
 * Sparer
 */
public class EnumChoiceRenderer implements IChoiceRenderer
{

    private static final long serialVersionUID = 1L;

    private final Component resourceProvider;

    private final String qualifier;

    /**
     * @param resourceProvider resource provider for the display value of an enum instance.
     * @param qualifier optional qualification to look up the display value in the resourceProvider.
     *            This allows to use the same list (or overlapping lists) of enum values for
     *            different components, such as a filter and an update value.
     * 
     */
    public EnumChoiceRenderer(final Component resourceProvider, final String qualifier)
    {
        this.resourceProvider = resourceProvider;
        this.qualifier = qualifier;
    }

    public Object getDisplayValue(final Object object)
    {
        final Enum<?> v = (Enum<?>) object;
        final String key = v == null ? "null" : v.name();
        if (qualifier != null)
        {
            try
            {
                return resourceProvider.getString(qualifier + '.' + key);
            }

            catch (MissingResourceException exception)
            {
            }
        }
        try
        {
            return resourceProvider.getString(key);
        }
        catch (MissingResourceException exception)
        {
        }
        return key;

    }

    public String getIdValue(final Object object, final int index)
    {
        final Enum<?> v = (Enum<?>) object;
        return v == null ? null : v.name();
    }

}
