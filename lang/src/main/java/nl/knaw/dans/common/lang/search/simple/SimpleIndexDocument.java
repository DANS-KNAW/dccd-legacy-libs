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

import nl.knaw.dans.common.lang.search.Field;
import nl.knaw.dans.common.lang.search.Index;
import nl.knaw.dans.common.lang.search.IndexDocument;

public class SimpleIndexDocument extends SimpleDocument implements IndexDocument
{
    private static final long serialVersionUID = -3562470874746650080L;

    private Index index;

    public SimpleIndexDocument(Index index)
    {
        setIndex(index);
    }

    public SimpleIndexDocument(IndexDocument doc)
    {
        super(doc);
        setIndex(doc.getIndex());
    }

    public Index getIndex()
    {
        return index;
    }

    public void setIndex(Index index)
    {
        this.index = index;
    }

    public Field getPrimaryKey()
    {
        return getFieldByName(index.getPrimaryKey());
    }

}
