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

/** Translate Attribute Values from and to LDAP
 *
 * Use this when your methods values don't correspond one-to-one
 * with the attribute values in LDAP.
 * Add your implementation of the translator to the annotation and then
 * the LdapMapper can use it to do the translation while mapping.
 *
 * annotation parameter: valueTranslator
 *
 * @author paulboon
 *
 */
public interface LdapAttributeValueTranslator<T>
{

    T fromLdap(Object value);

    Object toLdap(T value);
}
