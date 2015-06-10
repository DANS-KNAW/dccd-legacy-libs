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
package nl.knaw.dans.common.lang.reposearch;

import nl.knaw.dans.common.lang.repo.DmoStoreId;

public class ReindexError
{
    private final Throwable exception;

    private final DmoStoreId sid;

    private final String operation;

    public ReindexError(Throwable e, DmoStoreId s, String o)
    {
        this.exception = e;
        this.sid = s;
        this.operation = o;
    }

    public String getOperation()
    {
        return operation;
    }

    public DmoStoreId getSid()
    {
        return sid;
    }

    public Throwable getException()
    {
        return exception;
    }

}
