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

import nl.knaw.dans.common.wicket.WicketUtil;

import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.Link;

public class CancelLink extends Link<Void>
{
    private static final long serialVersionUID = -6430995496157454477L;

    private Class<? extends Page> alternativePage;

    public CancelLink(String id)
    {
        super(id);
        this.alternativePage = Application.get().getHomePage();
    }

    public CancelLink(String id, Class<? extends Page> alternativePage)
    {
        super(id);
        this.alternativePage = alternativePage;
    }

    @Override
    public void onClick()
    {
        if (!WicketUtil.redirectToLastVisitedPage())
        {
            setResponsePage(alternativePage);
        }
    }

}
