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
package nl.knaw.dans.common.wicket.components.markup;

import java.io.Serializable;

import nl.knaw.dans.common.lang.xml.HtmlValidator;
import nl.knaw.dans.common.wicket.components.CommonForm;
import nl.knaw.dans.common.wicket.components.CommonPanel;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class MarkupEditorPanel extends CommonPanel
{

    private static final long serialVersionUID = 4723045676949760270L;

    private boolean initiated;
    private final IModel<Serializable> model;
    private Label outputFeed;

    public MarkupEditorPanel(String id)
    {
        super(id);
        model = new Model<Serializable>("");
    }

    public MarkupEditorPanel(String id, IModel<Serializable> model)
    {
        super(id, model);
        this.model = model;
    }

    @Override
    protected void onBeforeRender()
    {
        if (!initiated)
        {
            init();
            initiated = true;
        }
        super.onBeforeRender();
    }

    private void init()
    {
        add(new MarkupEditorForm("markupEditorForm", model));
        addCommonFeedbackPanel();
        outputFeed = new Label("outputFeed", new Model<Serializable>(""));
        outputFeed.setEscapeModelStrings(false);
        add(outputFeed);
    }

    private void setOutPut(String output)
    {
        outputFeed.setDefaultModelObject(output);
    }

    class MarkupEditorForm extends CommonForm<Serializable>
    {

        private static final long serialVersionUID = 892200475584026808L;

        private boolean initiated;
        private TextArea<Serializable> markupTextArea;
        private transient HtmlValidator htmlValidator;
        private final IModel<Serializable> model;

        public MarkupEditorForm(String id)
        {
            super(id);
            model = new Model<Serializable>("");
        }

        public MarkupEditorForm(String id, IModel<Serializable> model)
        {
            super(id, model);
            this.model = model;
        }

        @Override
        protected void onBeforeRender()
        {
            if (!initiated)
            {
                init();
                initiated = true;
            }
            super.onBeforeRender();
        }

        private void init()
        {
            markupTextArea = new TextArea<Serializable>("markupTextArea", model);
            markupTextArea.setEscapeModelStrings(false);

            add(markupTextArea);
            add(new SubmitLink("submit.link"));
        }

        @Override
        protected void onSubmit()
        {
            HtmlValidator validator = getHtmlValidator();
            String markup = markupTextArea.getDefaultModelObjectAsString();
            String tidied = validator.tidyPartialHtml(markup);
            String escapedTidied = tidied.replaceAll("&", "&amp;");
            markupTextArea.getModel().setObject(escapedTidied);
            if (validator.hasErrors() || validator.hasWarnings())
            {
                for (String error : validator.getErrorMessages())
                {
                    error(error);
                }
                for (String warning : validator.getWarningMessages())
                {
                    warn(warning);
                }
            }
            setOutPut(tidied);
        }

        private HtmlValidator getHtmlValidator()
        {
            if (htmlValidator == null)
            {
                htmlValidator = new HtmlValidator();
            }
            return htmlValidator;
        }

    }

}
