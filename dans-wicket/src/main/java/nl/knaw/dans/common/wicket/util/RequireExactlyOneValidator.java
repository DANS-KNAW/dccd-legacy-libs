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
/**
 * 
 */
package nl.knaw.dans.common.wicket.util;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.validation.AbstractFormValidator;

/**
 * Validator to require that exactly one of the fields is filled in.
 * 
 * @author Vesa Åkerman
 */
public class RequireExactlyOneValidator extends AbstractRelatedFormFieldsValidator
{
    /**
     * Serial version uid.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor
     * @param components FormComponents of which just one must be filled.
     */
    public RequireExactlyOneValidator(final FormComponent... components)
    {
        super(components);
    }

    /**
     * Validate the form.
     * 
     * @param form The form to validate.
     * @see org.apache.wicket.markup.html.form.validation.IFormValidator#validate(org.apache.wicket.markup.html.form.Form)
     */
    public void validate(Form form)
    {
        int nrFilledFields = 0;

        for (FormComponent component : this.dependentComponents)
        {
            if (component.getValue().trim().length() > 0)
            {
                nrFilledFields++;
            }
        }

        if (nrFilledFields != 1)
        {
            error(this.dependentComponents[0]);
        }
    }
}
