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
package nl.knaw.dans.common.wicket.components.explorer;

import java.util.LinkedList;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;

public class BreadcrumbPanel extends Panel
{
    private static final long serialVersionUID = 1L;

    private ListView<String> breadcrumbs;

    public BreadcrumbPanel(String id, ITreeItem selected)
    {
        super(id);

        breadcrumbs = new ListView<String>("path", getBreadcrumbs(selected))
        {
            private static final long serialVersionUID = 1L;

            protected void populateItem(ListItem item)
            {
                item.add(new Label("breadcrumb", item.getModel()));
            }
        };
        breadcrumbs.setOutputMarkupId(true);
        add(breadcrumbs);

        this.setOutputMarkupId(true);
    }

    public void update(AjaxRequestTarget target, ITreeItem selected)
    {
        breadcrumbs.setList(getBreadcrumbs(selected));
        target.addComponent(this);
    }

    // get breadcrumb path to current select folder
    private LinkedList<String> getBreadcrumbs(ITreeItem selected)
    {
        LinkedList<String> path = new LinkedList<String>();
        ITreeItem breadcrumb = selected;
        while (breadcrumb != null)
        {
            path.addFirst(breadcrumb.getName());
            breadcrumb = breadcrumb.getParent();
        }

        return path;
    }
}
