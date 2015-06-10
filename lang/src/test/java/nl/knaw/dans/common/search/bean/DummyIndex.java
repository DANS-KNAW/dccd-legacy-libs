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
package nl.knaw.dans.common.search.bean;

import nl.knaw.dans.common.lang.search.Index;

public class DummyIndex implements Index
{
    private static final long serialVersionUID = 8694020343426156561L;

    public String getName()
    {
        return "dummyIndex";
    }

    public String getPrimaryKey()
    {
        return DummySB.ID_NAME;
    }

}
