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

import org.apache.wicket.Page;
import org.apache.wicket.Request;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;

public class CommonSession extends WebSession
{
    private static final long serialVersionUID = -7886316129048405422L;

    private String currentPageURL;

    private Class<? extends Page> currentPageClass;

    private String lastVisitedPageURL;

    private Class<? extends Page> lastVisitedPageClass;

    public CommonSession(Request request)
    {
        super(request);
    }

    public static CommonSession get()
    {
        return (CommonSession) Session.get();
    }

    public String getLastVisitedPageURL()
    {
        return lastVisitedPageURL;
    }

    public Class<? extends Page> getLastVisitedPageClass()
    {
        return lastVisitedPageClass;
    }

    public Class<? extends Page> getCurrentPageClass()
    {
        return currentPageClass;
    }

    public String getCurrentPageURL()
    {
        return currentPageURL;
    }

    public void setCurrentPage(String URL, Class<? extends CommonPage> pageClass)
    {
        if (!pageClass.equals(currentPageClass))
        {
            this.lastVisitedPageURL = this.currentPageURL;
            this.currentPageURL = URL;
            this.lastVisitedPageClass = currentPageClass;
            this.currentPageClass = pageClass;
        }
    }
}
