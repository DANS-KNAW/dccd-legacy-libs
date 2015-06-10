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

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lobo
 * This class contains the information concerning the upload process. It is being held
 * by an UploadProcess class.
 */
public class EasyUploadStatus extends UploadStatus
{
    /** Log. */
    private static final Logger LOG = LoggerFactory.getLogger(EasyUploadStatus.class);

    private Integer uploadId;

    public EasyUploadStatus(Integer uploadId, String message)
    {
        super(message);
        this.uploadId = uploadId;
    }

    public JSONObject toJSONObject()
    {
        JSONObject jobj = new JSONObject();
        try
        {
            jobj.put("uploadId", uploadId);
            jobj.put("message", getMessage());
            jobj.put("error", isError());
            jobj.put("finished", isFinished());
            jobj.put("percentComplete", getPercentComplete());
        }
        catch (JSONException e)
        {
            //TODO: send exception to general exception handler
            LOG.error("Caught error while serializing UploadStatus object to JSON.", e);
            return jobj;
        }
        return jobj;
    }

    public Integer getUploadId()
    {
        return uploadId;
    }
}
