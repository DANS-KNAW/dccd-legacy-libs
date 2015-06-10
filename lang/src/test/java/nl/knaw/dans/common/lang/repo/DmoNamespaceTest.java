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
package nl.knaw.dans.common.lang.repo;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class DmoNamespaceTest
{

    @Test(expected = IllegalArgumentException.class)
    public void newNull()
    {
        new DmoNamespace(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newEmpty()
    {
        new DmoNamespace("");
    }

    @Test
    public void newMatch()
    {
        new DmoNamespace("foo");
        new DmoNamespace("foo-bar");
        new DmoNamespace("foo-123");
        new DmoNamespace("foo-bar123-9-D-Y");
    }

    @Test
    public void nonMatch()
    {
        assertFalse(isPassingMatch(" "));
        assertFalse(isPassingMatch("abc#"));
        assertFalse(isPassingMatch("\""));
        assertFalse(isPassingMatch("."));
        assertFalse(isPassingMatch("{}"));
        assertFalse(isPassingMatch(";"));
        assertFalse(isPassingMatch("@"));
    }

    private boolean isPassingMatch(String value)
    {
        try
        {
            new DmoNamespace(value);
        }
        catch (IllegalArgumentException e)
        {
            return false;
        }
        return true;
    }

}
