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
package nl.knaw.dans.common.wicket.components;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * A label that does not escape HTML 
 * 
 * @author lobo
 */
public class UnescapedLabel extends Label
{
    private static final long serialVersionUID = 4653914433944688751L;

    public UnescapedLabel(final String id, String label)
    {
        this(id, new Model(label));
    }

    public UnescapedLabel(final String id, IModel model)
    {
        super(id, model);

        setEscapeModelStrings(false);
    }
}
