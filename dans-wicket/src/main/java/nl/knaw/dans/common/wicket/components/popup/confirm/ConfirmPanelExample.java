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
package nl.knaw.dans.common.wicket.components.popup.confirm;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebPage;

public class ConfirmPanelExample extends WebPage
{
    private static final long serialVersionUID = 1L;

    private static final String PANEL_ID = "yesNoPanel";
    private static final String BUTTON_NAME = "Ajax Button";
    private static final String MESSAGE = "Do you really want to perform this action?";
    private static final String TITLE = "Are you sure?";

    public ConfirmPanelExample(final PageParameters parameters)
    {
        add(new ConfirmPanel(PANEL_ID, BUTTON_NAME, MESSAGE, TITLE)
        {
            private static final long serialVersionUID = -1747566620744071921L;

            @Override
            protected void onConfirm(AjaxRequestTarget target)
            {
                System.out.println("The User Confirmed the action by clicking on \"Yes\"!");
            }

            @Override
            protected void onCancel(AjaxRequestTarget target)
            {
                System.out.println("The User Cancelled the action by clicking on \"No\"!");
            }
        });
    }
}
