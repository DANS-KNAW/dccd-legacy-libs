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
package nl.knaw.dans.common.lang.test;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * from: http://forums.sun.com/thread.jspa?threadID=300557
 * 
 * @author Antony Miguel
 */
public class ClassPathHacker
{
    private static final Logger logger = LoggerFactory.getLogger(ClassPathHacker.class);

    private static final Class<?>[] parameters = new Class[] {URL.class};

    private ClassPathHacker()
    {
        // static class
    }

    public static void addFile(String s)
    {
        File f = new File(s);
        addFile(f);
    }

    public static void addFile(File f)
    {
        try
        {
            addURL(f.toURL());
        }
        catch (MalformedURLException e)
        {
            throw new IllegalArgumentException(e);
        }
    }

    public static void addURL(URL url)
    {

        URLClassLoader sysloader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        Class<URLClassLoader> sysclass = URLClassLoader.class;

        try
        {
            Method method = sysclass.getDeclaredMethod("addURL", parameters);
            method.setAccessible(true);
            method.invoke(sysloader, new Object[] {url});
            logger.info("Added to classpath: " + url.toString());
        }
        catch (Throwable t)
        {
            throw new IllegalArgumentException("Error, could not add URL to system classloader", t);
        }

    }

}
