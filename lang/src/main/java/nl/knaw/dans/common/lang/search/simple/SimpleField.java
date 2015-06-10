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

public class SimpleField<T> implements Field<T>
{
    private static final long serialVersionUID = -6244061070328879614L;

    private T value;

    private String name;

    public SimpleField(Field<T> copyMe)
    {
        this.name = copyMe.getName();
        this.value = copyMe.getValue();
    }

    public SimpleField(String name)
    {
        this.name = name;
    }

    public SimpleField(String name, T value)
    {
        this.name = name;
        this.value = value;
    }

    public void setValue(T value)
    {
        this.value = value;
    }

    public T getValue()
    {
        return this.value;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return super.toString() + "[name = '" + getName() + "' value = '" + getValue().toString() + "']";
    }
}
