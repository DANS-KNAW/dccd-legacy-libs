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
package nl.knaw.dans.common.search.simple;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import nl.knaw.dans.common.lang.search.Index;
import nl.knaw.dans.common.lang.search.SortOrder;
import nl.knaw.dans.common.lang.search.simple.SimpleField;
import nl.knaw.dans.common.lang.search.simple.SimpleSearchRequest;
import nl.knaw.dans.common.lang.search.simple.SimpleSortField;

import org.junit.Test;

public class SimpleSearchRequestTest
{

    @Test
    public void testProperties()
    {
        SimpleSearchRequest r = new SimpleSearchRequest();

        assertFalse(r.isHighlightingEnabled());
        assertNull(r.getIndex());
        assertEquals(0, r.getFacetFields().size());
        assertEquals(0, r.getFieldQueries().size());
        assertEquals(0, r.getFilterQueries().size());
        assertEquals(0, r.getSortFields().size());

        r.setIndex(new Index()
        {
            private static final long serialVersionUID = -8303451350218041805L;

            public String getName()
            {
                return "index1";
            }

            public String getPrimaryKey()
            {
                return "pkey";
            }

        });

        assertEquals("index1", r.getIndex().getName());
        assertEquals("pkey", r.getIndex().getPrimaryKey());

        r.addFieldQuery(new SimpleField<String>("hello", "world"));
        r.addFieldQuery(new SimpleField<String>("hello", "world2"));
        r.addFilterQuery(new SimpleField<String>("foo", "bar"));
        r.addFilterQuery(new SimpleField<String>("foo", "bar2"));
        r.addFilterBean(Object.class);
        r.addSortField(new SimpleSortField("bla", SortOrder.ASC));

        assertEquals("world2", r.getFieldQueries().getByFieldName("hello").getValue());
        assertEquals("bar2", r.getFilterQueries().getByFieldName("foo").getValue());
        assertEquals(1, r.getFieldQueries().size());
        assertEquals(1, r.getFilterQueries().size());
        assertEquals(1, r.getFilterBeans().size());
        assertEquals(1, r.getSortFields().size());

        r.clearFieldQueries();
        r.clearFilterBeans();
        r.clearFilterQueries();
        r.clearSortFields();

        assertEquals(0, r.getFacetFields().size());
        assertEquals(0, r.getFieldQueries().size());
        assertEquals(0, r.getFilterQueries().size());
        assertEquals(0, r.getSortFields().size());
    }
}
