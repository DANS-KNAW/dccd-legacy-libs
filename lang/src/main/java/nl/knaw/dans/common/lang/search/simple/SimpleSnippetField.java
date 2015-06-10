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
package nl.knaw.dans.common.lang.search.simple;

import java.util.List;

import nl.knaw.dans.common.lang.search.SnippetField;

public class SimpleSnippetField extends SimpleField<List<String>> implements SnippetField
{
    private static final long serialVersionUID = 119742473860268656L;

    public SimpleSnippetField(String name, List<String> value)
    {
        super(name, value);
    }
}
