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
package nl.knaw.dans.common.lang.service.exceptions;

public class FileSizeException extends ServiceException
{
    private static final long serialVersionUID = 8483469299362768976L;

    protected int amount;
    protected int limit;

    public FileSizeException(String message)
    {
        super(message);
    }

    public FileSizeException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public FileSizeException(Throwable cause)
    {
        super(cause);
    }

    /*
     * Note that sizes in MegaBytes
     */
    public FileSizeException(int amount, int limit)
    {
        super("The file(s) exceeds the max size limit of " + limit + "megabytes");
        this.amount = amount;
        this.limit = limit;
    }

    public int getAmount()
    {
        return amount;
    }

    public int getLimit()
    {
        return limit;
    }

}
