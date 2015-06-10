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
package nl.knaw.dans.common.wicket.behavior;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.behavior.AbstractBehavior;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;

/**
 * <p>
 * Behavior that adds an included css or JS resource to component (e.g., a page). The scope is a class in
 * the same package as where the resource resides. Typically, the scope is the class object of a wicket
 * page or panel and the resource is CSS- or JavaScript file that is included in the source code in the
 * same package as the class. The HTML-template of the class can then refer to the resource without a
 * prefixed path.
 * </p>
 * <p>
 * Example:
 * 
 * <pre>
 *      JAVA FILE:
 *      
 *      public class MyPage extends Page {
 *      
 *         public MyPage() {
 *           add(new IncludeResourceBehavior(MyPage.class, "myjavascript.js");
 *           // ... etc
 *           
 *      HTML-TEMPLATE MyPage.html:
 *      
 *      &lt;html&gt;
 *      &lt;head&gt;
 *         &lt;script type="text/javascript" src="myjavascript.js"&gt;
 *         
 *      &lt;-- etc --&gt;
 * </pre>
 */
public class IncludeJsOrCssBehavior extends AbstractBehavior
{
    private static final long serialVersionUID = 5261628952131156563L;
    private final Class<?> scope;
    private final String resource;

    public IncludeJsOrCssBehavior(Class<?> scope, String resource)
    {
        if (!resource.endsWith(".js") && !resource.endsWith(".css"))
        {
            throw new IllegalArgumentException("Only JavaScript or CSS resources can be rendered");
        }

        this.scope = scope;
        this.resource = resource;
    }

    @Override
    public void renderHead(IHeaderResponse response)
    {
        final ResourceReference ref = new CompressedResourceReference(scope, resource);
        if (resource.endsWith(".js"))
        {
            response.renderJavascriptReference(ref);
        }
        else if (resource.endsWith(".css"))
        {
            response.renderCSSReference(ref);
        }
        else
        {
            throw new RuntimeException("Only know how to render JavaScript or CSS references");
        }
    }
}
