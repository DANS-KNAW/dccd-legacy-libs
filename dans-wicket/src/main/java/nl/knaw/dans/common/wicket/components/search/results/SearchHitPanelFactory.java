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
package nl.knaw.dans.common.wicket.components.search.results;

import java.io.Serializable;

import nl.knaw.dans.common.lang.search.SearchHit;
import nl.knaw.dans.common.wicket.components.search.model.SearchModel;

import org.apache.wicket.markup.html.panel.Panel;

/**
 * The search hit panel factory is responsible for creating the hit panels
 * that display one search hit. By implementing this factory one may choose
 * to use different panels for different search hit objects. 
 * 
 * @author lobo
 */
public interface SearchHitPanelFactory extends Serializable
{
    Panel createHitPanel(String wicketId, SearchHit<?> searchHit, SearchModel sModel);
}
