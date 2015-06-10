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
/**
 *
 */
package nl.knaw.dans.common.fedora.fox;

/**
 * Indicates the state of a Digital Object.
 *
 * @author ecco
 */
public enum DobState
{
    /**
     * Indicates a Digital Object is <i>Active</i>.
     */
    Active("A"),
    /**
     * Indicates a Digital Object is <i>Inactive</i>.
     */
    Inactive("I"),
    /**
     * Indicates a Digital Object is <i>Deleted</i>.
     */
    Deleted("D");

    public final String fedoraQuirck;

    private DobState(String fedoraQuirck)
    {
        this.fedoraQuirck = fedoraQuirck;
    }

    // Fedora uses 'Active' and 'A' in unpredictable ways.
    public static DobState valueFor(String s)
    {
        if ("Active".equalsIgnoreCase(s) || "A".equalsIgnoreCase(s))
        {
            return Active;
        }
        else if ("Inactive".equalsIgnoreCase(s) || "I".equalsIgnoreCase(s))
        {
            return Inactive;
        }
        else if ("Deleted".equalsIgnoreCase(s) || "D".equalsIgnoreCase(s))
        {
            return Deleted;
        }
        else
        {
            return null;
        }
    }
}
