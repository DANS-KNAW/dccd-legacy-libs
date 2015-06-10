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
package nl.knaw.dans.common.wicket.components.jumpoff;

import nl.knaw.dans.common.lang.repo.jumpoff.JumpoffDmo;
import nl.knaw.dans.common.lang.repo.jumpoff.MarkupUnit;
import nl.knaw.dans.common.wicket.components.UnescapedLabel;
import nl.knaw.dans.common.wicket.model.DMOModel;

import org.apache.wicket.markup.html.panel.Panel;

public class JumpoffViewPanel extends Panel
{
    private static final long serialVersionUID = 6905841265646369464L;

    public JumpoffViewPanel(String id, DMOModel<JumpoffDmo> model)
    {
        super(id, model);
        JumpoffDmo jumpoffDmo = (JumpoffDmo) getDefaultModelObject();
        MarkupUnit markupUnit = jumpoffDmo.getMarkupUnit();

        add(new UnescapedLabel("jumpoffMarkup", markupUnit.getHtml()));
        add(new JumpoffMetadataPanel("jumpoffMetadataPanel", model));

    }

}
