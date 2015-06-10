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
package nl.knaw.dans.common.wicket.components.buttons;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.model.IModel;

public class SubmitButtonLink extends SubmitLink
{
    private static final long serialVersionUID = -3191852018809169175L;

    public SubmitButtonLink(String id)
    {
        super(id);
    }

    public SubmitButtonLink(String id, Form<?> form)
    {
        super(id, form);
    }

    public SubmitButtonLink(String id, IModel<?> model)
    {
        super(id, model);
    }

    public SubmitButtonLink(String id, IModel<?> model, Form<?> form)
    {
        super(id, model, form);
    }

    @Override
    protected void onComponentTagBody(MarkupStream markupStream, ComponentTag openTag)
    {
        super.onComponentTagBody(markupStream, openTag);

        // Render the associated markup
        renderAssociatedMarkup("panel", "Markup for a panel component has to contain part '<wicket:panel>'");
    }
}
