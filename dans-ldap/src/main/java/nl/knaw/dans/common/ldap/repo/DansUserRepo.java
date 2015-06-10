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
package nl.knaw.dans.common.ldap.repo;

import javax.naming.directory.Attributes;

import nl.knaw.dans.common.lang.user.User;
import nl.knaw.dans.common.lang.user.UserImpl;
import nl.knaw.dans.common.ldap.ds.LdapClient;

public class DansUserRepo extends AbstractLdapUserRepo<User>
{

    public DansUserRepo(LdapClient client, String context)
    {
        super(client, context, new LdapMapper<User>(UserImpl.class));
    }

    @Override
    protected User unmarshal(Attributes attrs) throws LdapMappingException
    {
        return getLdapMapper().unmarshal(new UserImpl(), attrs);
    }

}
