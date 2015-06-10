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
package nl.knaw.dans.common.wicket.components.search.facets;

import java.io.Serializable;
import java.util.Comparator;

import nl.knaw.dans.common.lang.search.FacetValue;
import nl.knaw.dans.common.wicket.components.search.Translator;

public class FacetConfig implements Serializable
{
    private static final long serialVersionUID = 1177799470852129977L;

    public enum Order
    {
        NONE, BY_COUNT, BY_ALPHABET,
        /**
         * Assumes the facet value implements Comparable
         */
        BY_VALUE,
        /**
         * Provide a comparator with setCustomOrderComparator
         */
        CUSTOM,
    }

    private String facetName;

    private Order order = Order.NONE;

    private Comparator<FacetValue<?>> customOrderComparator;

    private int limit = -1;

    private boolean hideEmptyFacets = true;

    private boolean showParentFacet = true;

    private FacetValueCollapser<?> facetValueCollapser = null;

    /**
     * Optional translator for the facet field name.
     */
    private Translator<String> facetNameTranslator = null;

    /**
     * Optional translator for the facet field values.
     */
    private Translator<String> facetValueTranslator = null;

    /**
     * A column count of 0 or lower defaults to 1 column. Maximum supported
     * column count is 6.
     */
    private int columnCount = 1;

    public FacetConfig(String facetField)
    {
        setFacetName(facetField);
    }

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }

    public Comparator<FacetValue<?>> getCustomOrderComparator()
    {
        return customOrderComparator;
    }

    public void setCustomOrderComparator(Comparator<FacetValue<?>> customOrderComparator)
    {
        this.customOrderComparator = customOrderComparator;
    }

    public int getLimit()
    {
        return limit;
    }

    public void setLimit(int limit)
    {
        this.limit = limit;
    }

    public boolean hideEmptyFacets()
    {
        return hideEmptyFacets;
    }

    public void setHideEmptyFacets(boolean hideEmptyFacets)
    {
        this.hideEmptyFacets = hideEmptyFacets;
    }

    public Translator<String> getFacetValueTranslator()
    {
        return facetValueTranslator;
    }

    public void setFacetValueTranslator(Translator<String> facetValueTranslator)
    {
        this.facetValueTranslator = facetValueTranslator;
    }

    public FacetValueCollapser<?> getFacetValueCollapser()
    {
        return facetValueCollapser;
    }

    public void setFacetValueCollapser(FacetValueCollapser<?> facetValueCollapser)
    {
        this.facetValueCollapser = facetValueCollapser;
    }

    public void setFacetName(String facetName)
    {
        this.facetName = facetName;
    }

    public String getFacetName()
    {
        return facetName;
    }

    public void setColumnCount(int columnCount)
    {
        this.columnCount = columnCount;
    }

    public int getColumnCount()
    {
        return columnCount;
    }

    public Translator<String> getFacetNameTranslator()
    {
        return facetNameTranslator;
    }

    public void setFacetNameTranslator(Translator<String> facetNameTranslator)
    {
        this.facetNameTranslator = facetNameTranslator;
    }

    public boolean showParentFacet()
    {
        return showParentFacet;
    }

    public void setShowParentFacet(boolean showParentFacet)
    {
        this.showParentFacet = showParentFacet;
    }

}
