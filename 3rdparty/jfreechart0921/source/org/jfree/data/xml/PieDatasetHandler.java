/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-2004, by Object Refinery Limited and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation;
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * library; if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307, USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc. 
 * in the United States and other countries.]
 *
 * ----------------------
 * PieDatasetHandler.java
 * ----------------------
 * (C) Copyright 2003, by Object Refinery Limited and Contributors.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * $Id: PieDatasetHandler.java,v 1.1 2004/08/31 15:35:26 mungady Exp $
 *
 * Changes (from 21-Jun-2001)
 * --------------------------
 * 23-Jan-2003 : Version 1 (DG);
 *
 */

package org.jfree.data.xml;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * A SAX handler for reading a {@link PieDataset} from an XML file.
 *
 */
public class PieDatasetHandler extends RootHandler implements DatasetTags {

    /** The pie dataset under construction. */
    private DefaultPieDataset dataset;

    /**
     * Default constructor.
     */
    public PieDatasetHandler() {
        this.dataset = null;
    }

    /**
     * Returns the dataset.
     *
     * @return The dataset.
     */
    public PieDataset getDataset() {
        return this.dataset;
    }

    /**
     * Adds an item to the dataset under construction.
     *
     * @param key  the key.
     * @param value  the value.
     */
    public void addItem(final Comparable key, final Number value) {
        this.dataset.setValue(key, value);
    }

    /**
     * Starts an element.
     *
     * @param namespaceURI  the namespace.
     * @param localName  the element name.
     * @param qName  the element name.
     * @param atts  the element attributes.
     *
     * @throws SAXException for errors.
     */
    public void startElement(final String namespaceURI,
                             final String localName,
                             final String qName,
                             final Attributes atts) throws SAXException {

        final DefaultHandler current = getCurrentHandler();
        if (current != this) {
            current.startElement(namespaceURI, localName, qName, atts);
        }
        else if (qName.equals(PIEDATASET_TAG)) {
            this.dataset = new DefaultPieDataset();
        }
        else if (qName.equals(ITEM_TAG)) {
            final ItemHandler subhandler = new ItemHandler(this, this);
            getSubHandlers().push(subhandler);
            subhandler.startElement(namespaceURI, localName, qName, atts);
        }

    }

    /**
     * The end of an element.
     *
     * @param namespaceURI  the namespace.
     * @param localName  the element name.
     * @param qName  the element name.
     *
     * @throws SAXException for errors.
     */
    public void endElement(final String namespaceURI,
                           final String localName,
                           final String qName) throws SAXException {

        final DefaultHandler current = getCurrentHandler();
        if (current != this) {
            current.endElement(namespaceURI, localName, qName);
        }

    }

}
