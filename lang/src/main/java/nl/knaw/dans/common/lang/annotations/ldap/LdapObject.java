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
package nl.knaw.dans.common.lang.annotations.ldap;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Optional annotation for ldap-mapped classes and their super classes that sums the ldap objectClasses to use when
 * marshaling.
 *
 * @author ecco Feb 16, 2009
 */
@Retention(RetentionPolicy.RUNTIME)
@Target( {ElementType.TYPE})
public @interface LdapObject
{
    /**
     * An array of strings, indicating ldap objectClasses in reverse hierarchical order.
     *
     * @return array of strings, indicating ldap objectClasses
     */
    String[] objectClasses();
}
