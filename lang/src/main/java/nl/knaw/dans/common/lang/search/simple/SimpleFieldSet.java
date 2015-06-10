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

import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import nl.knaw.dans.common.lang.search.Field;
import nl.knaw.dans.common.lang.search.FieldSet;

public class SimpleFieldSet<T> extends AbstractSet<Field<T>> implements FieldSet<T>
{
    private static final long serialVersionUID = 2297645031181185382L;

    private Map<String, Field<T>> map = new HashMap<String, Field<T>>();

    @Override
    public Iterator<Field<T>> iterator()
    {
        return map.values().iterator();
    }

    @Override
    public int size()
    {
        return map.size();
    }

    @Override
    public boolean isEmpty()
    {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o)
    {
        return map.containsValue(o);
    }

    @Override
    public boolean remove(Object o)
    {
        if (!(o instanceof Field))
            return false;
        return map.remove(((Field<?>) o).getName()) != null;
    }

    @Override
    public void clear()
    {
        map.clear();
    }

    @Override
    public boolean add(Field<T> o)
    {
        return map.put(o.getName(), o) == null;
    }

    public Field<T> getByFieldName(String name)
    {
        return map.get(name);
    }
}
