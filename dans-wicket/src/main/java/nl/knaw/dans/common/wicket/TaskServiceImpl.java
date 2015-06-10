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
package nl.knaw.dans.common.wicket;

import java.util.concurrent.Executor;

import org.wicketstuff.progressbar.spring.TaskService;

/**
 * Should be registered as SESSION scoped bean to prevent memory leaks with
 * unfinished tasks.
 *
 */
public class TaskServiceImpl extends TaskService
{
    /**
     * ** NO PUBLIC CONSTRUCTOR ** 
     * 
     * Spring proxy instantiation needs a no-argument constructor.
     */
    public TaskServiceImpl()
    {
        super(null);
    }

    /**
     * ** NO PUBLIC CONSTRUCTOR ** 
     * 
     * Used by Spring framework.
     * 
     * @param executor
     *        the executor
     */
    public TaskServiceImpl(Executor executor)
    {
        super(executor);
    }

}
