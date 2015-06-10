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

import java.util.Iterator;

import nl.knaw.dans.common.lang.search.Document;
import nl.knaw.dans.common.lang.search.Field;
import nl.knaw.dans.common.lang.search.FieldSet;

@SuppressWarnings("unchecked")
public class SimpleDocument implements Document
{
    private static final long serialVersionUID = 1069145763060657857L;

    private SimpleFieldSet fields = new SimpleFieldSet();

    public SimpleDocument()
    {
    }

    public SimpleDocument(Document doc)
    {
        this.setFields(doc.getFields());
    }

    public void addField(Field<?> field)
    {
        fields.add(field);
    }

    public void clear()
    {
        fields.clear();
    }

    public void setFields(FieldSet<?> fields)
    {
        clear();
        if (fields == null)
            return;

        this.fields = (SimpleFieldSet) fields;
    }

    public Field<?> getFieldByName(String fieldName)
    {
        if (fieldName == null)
            return null;
        return fields.getByFieldName(fieldName);
    }

    public FieldSet<?> getFields()
    {
        return fields;
    }

    @Override
    public String toString()
    {
        String t = super.toString() + "[fields = '";
        Iterator<Field<?>> it = fields.iterator();
        while (it.hasNext())
        {
            t += it.next().toString();
        }
        t += "']";
        return t;
    }

}
