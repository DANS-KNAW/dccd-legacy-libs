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
package nl.knaw.dans.common.lang.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetUtil
{
    private static final Logger logger = LoggerFactory.getLogger(NetUtil.class);

    private static String CANONICAL_HOST_NAME;
    private static String HOST_ADDRESS;
    private static String HOST_NAME;

    static
    {
        try
        {
            InetAddress ia = InetAddress.getLocalHost();
            CANONICAL_HOST_NAME = ia.getCanonicalHostName();
            HOST_ADDRESS = ia.getHostAddress();
            HOST_NAME = ia.getHostName();
        }
        catch (UnknownHostException e)
        {
            logger.error("Could not get local host: ", e);
        }
    }

    public static String getCanonicalHostName()
    {
        return CANONICAL_HOST_NAME;
    }

    public static String getHostAddress()
    {
        return HOST_ADDRESS;
    }

    public static String getHostName()
    {
        return HOST_NAME;
    }

}
