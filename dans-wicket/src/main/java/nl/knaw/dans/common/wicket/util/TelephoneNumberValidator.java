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
package nl.knaw.dans.common.wicket.util;

import org.apache.wicket.validation.validator.PatternValidator;

public class TelephoneNumberValidator extends PatternValidator
{

    public static final String PATTERN_TELEPHONE = "[+]?((\\([0-9- ]+\\))|[0-9- ]+)+";

    private static final long serialVersionUID = 8803635130499334848L;

    private static TelephoneNumberValidator instance;

    public static TelephoneNumberValidator instance()
    {
        if (instance == null)
        {
            instance = new TelephoneNumberValidator();
        }
        return instance;
    }

    private TelephoneNumberValidator()
    {
        super(PATTERN_TELEPHONE);
    }

}
