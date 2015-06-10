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
package nl.knaw.dans.common.wicket.components.pagebrowse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PageBrowseDataTest
{

    @Test
    public void testCurrent()
    {
        int pageSize = 10;
        int[] pageStart = {0, 1, 4, 10, 11, 20, 77};
        int[] expected = {1, 1, 1, 1, 2, 2, 8};
        for (int i = 0; i < expected.length; i++)
        {
            doCurrent(pageStart[i], pageSize, expected[i]);
        }
    }

    private void doCurrent(int pageStart, int pageSize, int expected)
    {
        PageBrowseData pu = new PageBrowseData(pageStart, pageSize, 0, 2);
        assertEquals(expected, pu.getCurrentPage());
    }

    @Test
    public void last()
    {
        int pageSize = 10;
        int[] totalHits = {0, 1, 4, 10, 11, 20, 77};
        int[] expected = {0, 1, 1, 1, 2, 2, 8};
        for (int i = 0; i < expected.length; i++)
        {
            testLast(pageSize, totalHits[i], expected[i]);
        }
    }

    private void testLast(int pageSize, int totalHits, int expected)
    {
        PageBrowseData pu = new PageBrowseData(1, pageSize, totalHits, 2);
        assertEquals(expected, pu.getLastPage());
    }

    @Test
    public void windowStart()
    {
        int pageSize = 10;
        int totalHits = 100;
        int[] pageStart = {0, 1, 4, 10, 11, 20, 25, 35, 45, 55, 65, 77, 81, 91, 100};
        int[] expected = {1, 1, 1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 6, 6, 6};
        for (int i = 0; i < expected.length; i++)
        {
            testWindowStart(pageStart[i], pageSize, totalHits, expected[i]);
        }
    }

    private void testWindowStart(int pageStart, int pageSize, int totalHits, int expected)
    {
        PageBrowseData pu = new PageBrowseData(pageStart, pageSize, totalHits, 2);
        assertEquals(expected, pu.getWindowStart());
    }

    @Test
    public void windowEnd()
    {
        int pageSize = 10;
        int totalHits = 100;
        int[] pageStart = {1, 4, 10, 11, 20, 25, 35, 45, 55, 65, 77, 88, 99, 100};
        int[] expected = {5, 5, 5, 5, 5, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        for (int i = 0; i < expected.length; i++)
        {
            testWindowEnd(pageStart[i], pageSize, totalHits, expected[i]);
        }
    }

    @Test
    public void windowEnd_2()
    {
        int pageSize = 10;
        int[] totalHits = {1, 15, 15, 15};
        int[] pageStart = {1, 1, 10, 14};
        int[] expected = {1, 2, 2, 2};
        for (int i = 0; i < expected.length; i++)
        {
            testWindowEnd(pageStart[i], pageSize, totalHits[i], expected[i]);
        }
    }

    private void testWindowEnd(int pageStart, int pageSize, int totalHits, int expected)
    {
        PageBrowseData pu = new PageBrowseData(pageStart, pageSize, totalHits, 2);
        assertEquals(expected, pu.getWindowEnd());
    }

}
