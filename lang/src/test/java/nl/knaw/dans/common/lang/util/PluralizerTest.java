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
package nl.knaw.dans.common.lang.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PluralizerTest
{

    @Test
    public void format()
    {
        String formatted = Pluralizer.format("There", "is", "are", 0, "bird", "birds", "in this cage.");
        assertEquals("There are 0 birds in this cage.", formatted);

        formatted = Pluralizer.format("There", "is", "are", 1, "bird", "birds", "in the air.");
        assertEquals("There is 1 bird in the air.", formatted);

        formatted = Pluralizer.format("There", "is", "are", 2, "bird", "birds", "on the ground.");
        assertEquals("There are 2 birds on the ground.", formatted);

        formatted = Pluralizer.format(null, "Is", "Are", 3, "bird", "birds", "enough?");
        assertEquals("Are 3 birds enough?", formatted);
    }

    @Test
    public void format2()
    {
        String formatted = Pluralizer.format("There will be", 3, "duck", "in the pool.");
        assertEquals("There will be 3 ducks in the pool.", formatted);
    }

    @Test
    public void formatToBe()
    {
        String formatted = Pluralizer.formatToBe("There", 3, "dataset", "to be purged.");
        assertEquals("There are 3 datasets to be purged.", formatted);
    }

}
