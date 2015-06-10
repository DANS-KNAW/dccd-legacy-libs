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
package nl.knaw.dans.common.lang.mail;

import java.util.HashMap;
import java.util.Map;

import nl.knaw.dans.common.lang.ResourceLocator;
import nl.knaw.dans.common.lang.ResourceNotFoundException;
import nl.knaw.dans.common.lang.mail.Mailer.MailerException;
import nl.knaw.dans.common.lang.test.Tester;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class ApplicationMailerOnlineTest
{

    private static final String GUINEA_PIG = Tester.getString("mail.guineapig");
    private static Mailer mailer;

    @BeforeClass
    public static void beforeClass() throws MailerException
    {
        MailerConfiguration configuration = new ApplicationMailerConfiguration();
        configuration.setSmtpHost(Tester.getString("mail.smtp.host"));
        configuration.setSenderName("Guinea Pig");
        configuration.setFromAddress(GUINEA_PIG);

        Map<String, String> imageMap = new HashMap<String, String>();
        imageMap.put("easy-logo", "test-files/mail/easy_logo.gif");
        configuration.setImageMap(imageMap);

        mailer = new ApplicationMailer(configuration);
    }

    @Ignore
    @Test
    public void sendSimpelMail() throws MailerException
    {
        mailer.sendSimpleMail("simple mail", "text content", GUINEA_PIG);
    }

    @Ignore
    @Test
    public void sendSimpleAttachments() throws MailerException, ResourceNotFoundException
    {
        String location = "test-files/mail/easy_logo.gif";
        Attachement att = new Attachement("bla.xls", ResourceLocator.getFile(location));
        Attachement[] attachments = {att};
        mailer.sendSimpleMail("simple attachments", "textContent", attachments, GUINEA_PIG);
    }

    @Ignore
    @Test
    public void sendHtml() throws MailerException
    {
        String htmlContent = "<html><body><img src='cid:easy-logo'><h1>Hello</h1><br/>text content</body></html>";
        mailer.sendMail("html", "text content", htmlContent, GUINEA_PIG);
    }

    @Ignore
    @Test
    public void sendMail() throws ResourceNotFoundException, MailerException
    {
        String htmlContent = "<html><body><img src='cid:easy-logo'><h1>Hello dudes</h1><br/>How are you today?</body></html>";

        String location = "test-files/mail/easy_logo.gif";
        Attachement att = new Attachement("bla.xls", ResourceLocator.getFile(location));
        Attachement[] attachments = {att};

        mailer.sendMail("mail", "Hello etc", htmlContent, attachments, GUINEA_PIG);
    }

}
