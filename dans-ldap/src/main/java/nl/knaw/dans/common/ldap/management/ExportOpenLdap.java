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
package nl.knaw.dans.common.ldap.management;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttributes;

public class ExportOpenLdap
{

    /**
     * @param args
     * @throws NamingException 
     */
    public static void main(String[] args) throws NamingException
    {
        Attributes attrs = new BasicAttributes(true);
        attrs.put("NUMERICOID", "1.3.6.1.4.1.33188.0.1.1");
        attrs.put("NAME", "dansState");
        attrs.put("DESC", "The state of an entity");
        attrs.put("EQUALITY", "caseIgnoreMatch");
        attrs.put("SYNTAX", "1.3.6.1.4.1.1466.115.121.1.15"); // DirectoryString
        attrs.put("SINGLE-VALUE", "TRUE");
        print(attrs);

    }

    /* 
    
    attributetype ( 1.3.6.1.4.1.18060.0.4.1.2.21 
    NAME 'fullyQualifiedJavaClassName' 
    DESC 'The fully qualified name for a (Java) class' 
    EQUALITY caseExactIA5Match 
    SYNTAX 1.3.6.1.4.1.1466.115.121.1.26 
    SINGLE-VALUE)
    
     */
    /*
     * Notice: for openldap 
     * the closing bracket *cannot* be on a new line.
     * each definition *must* be followed by a blank line.
     */

    private static void print(Attributes attrs) throws NamingException
    {
        StringBuilder sb = new StringBuilder().append("\n").append("attributetype ( ").append(attrs.get("NUMERICOID").get()).append("\n\t")

        .append("NAME '" + attrs.get("NAME").get() + "'").append("\n\t")

        .append("DESC '" + attrs.get("DESC").get() + "'").append("\n\t")

        .append("EQUALITY " + attrs.get("EQUALITY").get()).append("\n\t")

        .append("SYNTAX " + attrs.get("SYNTAX").get());
        if ("TRUE".equals(attrs.get("SINGLE-VALUE").get()))
        {
            sb.append("\n\t");
            sb.append("SINGLE-VALUE");
        }

        sb.append(")\n");
        System.err.println(sb.toString());
    }

}
