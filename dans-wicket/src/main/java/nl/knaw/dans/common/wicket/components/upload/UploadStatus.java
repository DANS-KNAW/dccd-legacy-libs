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
package nl.knaw.dans.common.wicket.components.upload;

/**
 * @author lobo
 * This class contains the information concerning the upload process. It is being held
 * by an UploadProcess class.
 */
public class UploadStatus
{
    private Integer percentComplete = 0;

    private boolean error = false;

    private boolean finished = false;

    private String message;

    public UploadStatus(String message)
    {
        this.message = message;
        percentComplete = 0;
    }

    public boolean isError()
    {
        return error;
    }

    public void setError(boolean error)
    {
        this.error = error;
    }

    public void setError(String errorMessage)
    {
        this.error = true;
        this.message = errorMessage;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Integer getPercentComplete()
    {
        return percentComplete;
    }

    public void setPercentComplete(Integer percentComplete)
    {
        this.percentComplete = percentComplete;
    }

    public boolean isFinished()
    {
        return finished;
    }

    public void setFinished(boolean finished)
    {
        this.finished = finished;
    }
}
