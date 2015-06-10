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

import org.apache.wicket.model.IModel;

/**
 * Extending this class gives the extender access to common Wicket
 * methods. It is recommended that users of the Dans Commons wicket
 * use the CommonPanel or the CommonGPanel as a base class for all
 * Wicket panels. 
 *  
 * @author lobo
 */
public abstract class CommonPanel extends CommonBasePanel
{
    private static final long serialVersionUID = 3906988013645820611L;

    public CommonPanel(String id)
    {
        super(id);
    }

    public CommonPanel(String id, IModel<?> model)
    {
        super(id, model);
    }
}
