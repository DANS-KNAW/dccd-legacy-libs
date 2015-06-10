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
package nl.knaw.dans.common.wicket.components.search;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;

import nl.knaw.dans.common.wicket.WicketCommonTestBase;

import org.junit.Ignore;
import org.junit.Test;

public class SearchResourcesTest extends WicketCommonTestBase
{
    private static final long serialVersionUID = -1685338433015730235L;

    @Ignore("test in error ")
    @Test
    public void testResourceReferences() throws IllegalArgumentException, IllegalAccessException
    {
        Field[] fields = SearchResources.class.getDeclaredFields();
        BaseSearchPanel sp = new BaseSearchPanel("test");
        for (Field field : fields)
        {
            Class<?> fieldType = field.getType();
            if (fieldType.equals(String.class))
            {
                String key = (String) field.get(null);
                assertNotNull(sp.getString(key));
            }
        }
    }

}
