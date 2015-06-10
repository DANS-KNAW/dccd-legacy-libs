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
package nl.knaw.dans.common.lang.user;

import java.io.Serializable;

public interface Person extends Serializable
{

    public static final String PATTERN_TELEPHONE = "[+]?((\\([0-9- ]+\\))|[0-9- ]+)+[^-][^ ]";

    void setTitle(String title);

    String getTitle();

    void setInitials(String initials);

    String getInitials();

    void setFirstname(String firstname);

    String getFirstname();

    void setPrefixes(String prefixes);

    String getPrefixes();

    /**
     * Setter for surname.
     *
     * @param surname
     *        lastname
     */
    void setSurname(String surname);

    /**
     * Get surname.
     *
     * @return lastname
     */
    String getSurname();

    /**
     * Gets the common name of this Person. Returns the concatenation:
     * <br/>
     * [surname, ][title ][initials ][prefixes] > Bruggen, Dr. Ir. PHT van
     *
     * @return commonName
     */
    String getCommonName();

    /**
     * Gets the displayname of this Person. Returns the concatenation:
     * <br/>
     * [firstname ][prefixes ][surname] > Peter van Bruggen
     *
     * @return name displayed in views
     */
    String getDisplayName();

    /**
     * Getter for e-mail (mail).
     *
     * @return the email
     */
    String getEmail();

    /**
     * Setter for e-mail (mail).
     *
     * @param email
     *        the email to set
     */
    void setEmail(final String email);

    String getOrganization();

    void setOrganization(String organization);

    String getDepartment();

    void setDepartment(String department);

    String getFunction();

    void setFunction(String function);

    String getAddress();

    void setAddress(String address);

    String getPostalCode();

    void setPostalCode(String postalCode);

    String getCity();

    void setCity(String city);

    String getCountry();

    void setCountry(String country);

    String getTelephone();

    void setTelephone(String telephone);

    String getAlternativeTelephone();

    void setAlternativeTelephone(String altTel);

    void synchronizeOn(Person otherPerson);

}
