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
package nl.knaw.dans.common.lang.spring;

import java.io.File;

import nl.knaw.dans.common.lang.HomeDirectory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

/**
 * A {@link PropertyPlaceholderConfigurer} based on the location of a {@link HomeDirectory}. The
 * properties are expected to be located in the location $HOME_DIRECTORY/cfg/application.properties,
 * where $HOME_DIRECTORY is the location of said directory. The implementation of {@link HomeDirectory}
 * determines the way to find out this location. This could be for instance through an environment
 * variable of system property.
 */
public class HomeDirectoryBasedPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer
{
    private static final Logger log = LoggerFactory.getLogger(HomeDirectoryBasedPropertyPlaceholderConfigurer.class);

    public HomeDirectoryBasedPropertyPlaceholderConfigurer(final HomeDirectory homedir)
    {
        final File file = new File(homedir.getHomeDirectory(), "cfg/application.properties");
        if (!file.exists())
        {
            String m = MessageFormatter.format("Cannot find application properties at {}", file).getMessage();
            log.error(m);
            throw new RuntimeException(m);
        }
        if (!file.isFile())
        {
            String m = MessageFormatter.format("Application properites file {} exists, but is not a regular file", file).getMessage();
            log.error(m);
            throw new RuntimeException(m);

        }
        setLocation(new FileSystemResource(file));
    }
}
