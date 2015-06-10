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

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

public class LogBackConfigLoader
{
    private Logger logger = LoggerFactory.getLogger(LogBackConfigLoader.class);

    public LogBackConfigLoader(File externalConfigFile) throws IOException, JoranException
    {
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();

        if (!externalConfigFile.exists())
        {
            throw new IOException("Logback External Config File Parameter does not reference a file that exists");
        }
        else
        {
            if (!externalConfigFile.isFile())
            {
                throw new IOException("Logback External Config File Parameter exists, but does not reference a file");
            }
            else
            {
                if (!externalConfigFile.canRead())
                {
                    throw new IOException("Logback External Config File exists and is a file, but cannot be read.");
                }
                else
                {
                    JoranConfigurator configurator = new JoranConfigurator();
                    configurator.setContext(lc);
                    lc.reset();
                    configurator.doConfigure(externalConfigFile);

                    logger.info("Configured Logback with config file from: {}", externalConfigFile.getAbsolutePath());
                }
            }
        }
    }
}
