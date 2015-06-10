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

import java.io.File;
import java.io.IOException;

import javax.naming.NamingException;

import nl.knaw.dans.common.ldap.ds.Constants;

public class OpenLdapServerBuilder extends LdapServerBuilder
{

    private String providerUrl;
    private String securityPrincipal;

    public OpenLdapServerBuilder() throws NamingException
    {
        super();
    }

    public OpenLdapServerBuilder(String providerUrl, String securityPrincipal, String securityCredentials) throws NamingException
    {
        super();
        this.providerUrl = providerUrl;
        this.securityPrincipal = securityPrincipal;
        setSecurityCredentials(securityCredentials);
        System.out.println("Starting OpenLsapServerBuilder");
        System.out.println("providerUrl=" + getProviderUrl());
        System.out.println("securityPrincipal=" + getSecurityPrincipal());
        System.out.println("securityCredentials=" + getSecurityCredentials());
    }

    @Override
    public String getProviderUrl()
    {
        if (providerUrl == null)
        {
            providerUrl = Constants.OPENLDAP_DEFAULT_PROVIDERURL;
        }
        return providerUrl;
    }

    @Override
    public String getSecurityPrincipal()
    {
        if (securityPrincipal == null)
        {
            securityPrincipal = Constants.OPENLDAP_DEFAULT_SECURITY_PRINCIPAL;
        }
        return securityPrincipal;
    }

    @Override
    public void buildSchemas() throws NamingException, IOException
    {
        System.out.println("Cannot programmatically create schemas in openLdap.");
        File schemaDir = new File("schema");
        schemaDir.mkdir();
        for (AbstractSchema schema : getSchemas())
        {
            schema.exportForOpenLdap();
        }
        System.out.println("Schemas are in " + schemaDir.getAbsolutePath());
    }

    public static void main(String[] args) throws NamingException, IOException
    {
        String providerUrl = args.length > 0 ? args[0] : null;
        String securityPrincipal = args.length > 1 ? args[1] : null;
        String securityCredentials = args.length > 2 ? args[2] : null;

        OpenLdapServerBuilder builder = new OpenLdapServerBuilder(providerUrl, securityPrincipal, securityCredentials);
        builder.buildServer();
    }

}
