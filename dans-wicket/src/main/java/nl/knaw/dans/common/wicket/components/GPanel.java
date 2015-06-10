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

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * A panel that works with a generic model. The normal panel of Wicket does not
 * have a generic model object, but a default model object that needs casting.
 * Apparently the Wicket community voted against making Panel generic.
 * 
 * @author lobo
 */
public abstract class GPanel<T> extends Panel
{
    private static final long serialVersionUID = 1522105023988180614L;

    public GPanel(final String id)
    {
        super(id);
    }

    public GPanel(final String id, final IModel<T> model)
    {
        super(id, model);
    }

    @SuppressWarnings("unchecked")
    public final T getModelObject()
    {
        return (T) getDefaultModelObject();
    }

    public final void setModelObject(final T modelObject)
    {
        setDefaultModelObject(modelObject);
    }

    @SuppressWarnings("unchecked")
    public final IModel<T> getModel()
    {
        return (IModel<T>) getDefaultModel();
    }

    public final void setModel(final IModel<T> model)
    {
        setDefaultModel(model);
    }
}
