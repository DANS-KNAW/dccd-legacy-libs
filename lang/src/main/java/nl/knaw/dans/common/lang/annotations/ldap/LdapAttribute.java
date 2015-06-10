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
 * Mappes a field or method to an ldap attribute.
 *
 * @author ecco Feb 14, 2009
 */
@Retention(RetentionPolicy.RUNTIME)
@Target( {ElementType.FIELD, ElementType.METHOD})
public @interface LdapAttribute
{
    /**
     * The attrID of the mapped attribute.
     *
     * @return the attrID of the mapped attribute
     */
    String id();

    /**
     * Sets whether the attribute is required (must) by the ldap objectClass or not (may). The default is
     * <code>false</code>.
     *
     * @return <code>true</code> for required fields (must), <code>false</code> otherwise
     */
    boolean required() default false;

    boolean readOnly() default false;

    /**
     * Sets whether the field or method value should be one-way-encrypted to the attribute value. The default is
     * <code>false</code>.
     *
     * @return <code>true</code> if the value should be one-way-encrypted, <code>false</code> otherwise
     */
    boolean oneWayEncrypted() default false;

    /**
     * Sets whether the field or method value is encrypted to the attribute value. The default is
     * <code>""</code>.
     *
     * @return the encryption method
     */
    String encrypted() default "";

    /**
     * Specify the implementation class of the valueTranslator to use when mapping from/to Ldap
     * @return The implementation class of the valueTranslator
     */
    Class<? extends LdapAttributeValueTranslator<? extends Object>> valueTranslator() default PassthroughLdapAttributeValueTranslator.class;
}
