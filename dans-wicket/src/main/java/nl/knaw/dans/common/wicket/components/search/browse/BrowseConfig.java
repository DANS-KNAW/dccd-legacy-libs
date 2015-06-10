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
package nl.knaw.dans.common.wicket.components.search.browse;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import nl.knaw.dans.common.wicket.components.search.facets.FacetConfig;

/**
 * Configuration object for the BrowsePanel. 
 * 
 * @see BrowsePanel
 * 
 * @author lobo
 */
public class BrowseConfig implements Serializable
{
    private static final long serialVersionUID = -718705695086035147L;

    /**
     * The facets that need to be visible
     * 
     * @see nl.knaw.dans.common.wicket.components.search.facets.FacetConfig
     */
    private List<FacetConfig> facets;

    public BrowseConfig()
    {
    }

    public BrowseConfig(List<FacetConfig> facets)
    {
        setFacets(facets);
    }

    public List<FacetConfig> getFacets()
    {
        return (List<FacetConfig>) (facets != null ? facets : Collections.emptyList());
    }

    public void setFacets(List<FacetConfig> facets)
    {
        this.facets = facets;
    }

    public FacetConfig getFacetConfig(String facet)
    {
        if (facets != null)
        {
            for (FacetConfig config : facets)
            {
                if (config.getFacetName().equals(facet))
                    return config;
            }
        }
        return null;
    }

}
