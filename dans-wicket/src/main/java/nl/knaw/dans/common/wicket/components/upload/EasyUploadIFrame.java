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

import org.apache.wicket.ResourceReference;
import org.apache.wicket.behavior.HeaderContributor;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.HiddenField;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.model.Model;

/**
 * @author lobo
 * The upload is submitted to an iframe, which is a trick for not holding up the whole
 * page while uploading.
 *
 */
public class EasyUploadIFrame extends WebPage
{
    private UploadForm form;

    private EasyUpload easyUpload = null;

    private static final ResourceReference JS = new ResourceReference(EasyUploadIFrame.class, "js/EasyUploadIFrame.js");

    public static final String UPLOAD_FORM_ID = "uploadForm";

    public EasyUploadIFrame(String componentId)
    {
        form = new UploadForm(UPLOAD_FORM_ID);
        add(form);
        add(HeaderContributor.forJavaScript(JS));
        form.setMarkupId(UPLOAD_FORM_ID + "_" + componentId);
    }

    public void setEasyUpload(EasyUpload easyUpload)
    {
        this.easyUpload = easyUpload;
    }

    public class UploadForm extends Form
    {
        private static final long serialVersionUID = 48321765505919523L;

        private FileUploadField uploadField;

        private HiddenField uploadIdField;

        public UploadForm(String id)
        {
            super(id);

            uploadIdField = new HiddenField("uploadId");
            add(uploadIdField);

            uploadField = new FileUploadField("file");
            add(uploadField);
        }

        public EasyUpload getEasyUpload()
        {
            return easyUpload;
        }

        /**
         * uploadId must be regenerated on each page load!
         */
        @Override
        protected void onBeforeRender()
        {
            Integer uploadId = EasyUploadProcesses.getInstance().generateUploadId();
            uploadIdField.setModel(new Model(uploadId));
            super.onBeforeRender();
        }

        public Integer getUploadId()
        {
            Object uploadId = uploadIdField.getModelObject();
            if (uploadId instanceof String)
                return Integer.valueOf((String) uploadId);
            else if (uploadId instanceof Integer)
                return (Integer) uploadId;
            else
                return -1;
        }

    }
}
