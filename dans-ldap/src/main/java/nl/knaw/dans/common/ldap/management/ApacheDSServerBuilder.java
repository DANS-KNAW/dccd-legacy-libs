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

import java.io.IOException;

import javax.naming.NamingException;

import nl.knaw.dans.common.ldap.ds.Constants;

public class ApacheDSServerBuilder extends LdapServerBuilder
{

    private String providerUrl;
    private String securityPrincipal;

    public ApacheDSServerBuilder() throws NamingException
    {
        super();
    }

    public ApacheDSServerBuilder(String providerUrl, String securityPrincipal, String securityCredentials) throws NamingException
    {
        super();
        this.providerUrl = providerUrl;
        this.securityPrincipal = securityPrincipal;
        setSecurityCredentials(securityCredentials);
    }

    @Override
    public String getProviderUrl()
    {
        if (providerUrl == null)
        {
            providerUrl = Constants.APACHEDS_DEFAULT_PROVIDERURL;
        }
        return providerUrl;
    }

    @Override
    public String getSecurityPrincipal()
    {
        if (securityPrincipal == null)
        {
            securityPrincipal = Constants.APACHEDS_DEFAULT_SECURITY_PRINCIPAL;
        }
        return securityPrincipal;
    }

    /**
     * @param args optional: providerUrl, securityPrincipal, securityCredentials
     * @throws NamingException 
     * @throws IOException 
     */
    public static void main(String[] args) throws NamingException, IOException
    {
        String providerUrl = args.length > 0 ? args[0] : null;
        String securityPrincipal = args.length > 1 ? args[1] : null;
        String securityCredentials = args.length > 2 ? args[2] : null;
        ApacheDSServerBuilder builder = new ApacheDSServerBuilder(providerUrl, securityPrincipal, securityCredentials);
        builder.buildServer();
    }

}
