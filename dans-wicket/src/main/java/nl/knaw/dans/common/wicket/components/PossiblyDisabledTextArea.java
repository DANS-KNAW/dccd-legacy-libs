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

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.IModel;

public class PossiblyDisabledTextArea extends TextArea
{
    private static final long serialVersionUID = 1L;
    private boolean editMode;

    /**
     * @param id
     * @param model
     * @param editMode if true the following attributes are added: readonly="true" class="readonly".
     *            Add to your css something like:
     * 
     * <pre> 
     *  textarea.readonly  {
     *    border:0;
     *    color: #575756;
     *  } </pre>
     */
    public PossiblyDisabledTextArea(String id, IModel model, boolean editMode)
    {
        super(id, model);
        this.editMode = editMode;
        setEnabled(editMode);
    }

    @Override
    protected void onComponentTag(ComponentTag tag)
    {
        super.onComponentTag(tag);
        if (editMode)
            return;
        tag.put("readonly", editMode);
        tag.put("class", "readonly");
    }

}
