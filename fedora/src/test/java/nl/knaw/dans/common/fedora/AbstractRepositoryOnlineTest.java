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
package nl.knaw.dans.common.fedora;

import nl.knaw.dans.common.lang.test.Tester;

/**
 * Abstract class for testing repository client classes online.
 * 
 * @author dev
 */
public abstract class AbstractRepositoryOnlineTest
{

    private static final String KEY_FEDORA_BASE_URL = "fedora.base.url";
    private static final String KEY_FEDORA_ADMIN_NAME = "fedora.admin.username";
    private static final String KEY_FEDORA_ADMIN_PASS = "fedora.admin.userpass";

    private static Repository REPOSITORY;

    public static String getBaseUrl()
    {
        return Tester.getString(KEY_FEDORA_BASE_URL);
    }

    public static String getAdminName()
    {
        return Tester.getString(KEY_FEDORA_ADMIN_NAME);
    }

    public static String getAdminPass()
    {
        return Tester.getString(KEY_FEDORA_ADMIN_PASS);
    }

    public static Repository getRepository()
    {
        if (REPOSITORY == null)
        {
            REPOSITORY = new Repository(getBaseUrl(), getAdminName(), getAdminPass());
        }
        return REPOSITORY;
    }

}
