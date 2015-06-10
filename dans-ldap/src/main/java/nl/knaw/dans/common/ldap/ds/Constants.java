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
package nl.knaw.dans.common.ldap.ds;

public class Constants
{

    public static final String CONTEXT_FACTORY = "com.sun.jndi.ldap.LdapCtxFactory";
    public static final String SIMPLE_AUTHENTICATION = "simple";

    // apacheds
    public static final String APACHEDS_DEFAULT_PROVIDERURL = "ldap://localhost:10389";
    public static final String APACHEDS_DEFAULT_SECURITY_PRINCIPAL = "uid=admin,ou=system";

    // openldap
    public static final String OPENLDAP_DEFAULT_PROVIDERURL = "ldap://localhost:389";
    public static final String OPENLDAP_DEFAULT_SECURITY_PRINCIPAL = "cn=Manager,dc=dans,dc=knaw,dc=nl";

    public static final String DEFAULT_SECURITY_CREDENTIALS = "secret";

    public static final String dcDANS = "dans";
    public static final String dcKNAW = "knaw";
    public static final String dcNL = "nl";
    public static final String DANS_CONTEXT = "dc=" + dcDANS + ",dc=" + dcKNAW + ",dc=" + dcNL;

    public static final String ouTEST = "test";
    public static final String TEST_CONTEXT = "ou=" + ouTEST + "," + DANS_CONTEXT;

    public static final String ouUSERS = "users";
    public static final String TEST_USERS_CONTEXT = "ou=" + ouUSERS + "," + TEST_CONTEXT;

    public static final String ouMIGRATION = "migration";
    public static final String TEST_MIGRATION_CONTEXT = "ou=" + ouMIGRATION + "," + TEST_CONTEXT;

    public static final String ouFEDERATION = "federation";
    public static final String TEST_FEDERATION_CONTEXT = "ou=" + ouFEDERATION + "," + TEST_CONTEXT;

}
