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
 * ---------------
 * Statistics.java
 * ---------------
 * (C) Copyright 2000-2003, by Matthew Wright and Contributors.
 *
 * Original Author:  Matthew Wright;
 * Contributor(s):   David Gilbert (for Object Refinery Limited);
 *
 * $Id: Statistics.java,v 1.1 2004/08/31 15:32:24 mungady Exp $
 *
 * Changes (from 08-Nov-2001)
 * --------------------------
 * 08-Nov-2001 : Added standard header and tidied Javadoc comments (DG);
 *               Moved from JFreeChart to package com.jrefinery.data.* in JCommon class
 *               library (DG);
 * 24-Jun-2002 : Removed unnecessary local variable (DG);
 * 07-Oct-2002 : Fixed errors reported by Checkstyle (DG);
 * 26-May-2004 : Moved calculateMean() method from BoxAndWhiskerCalculator (DG);
 * 02-Jun-2004 : Fixed bug in calculateMedian() method (DG);
 *
 */

package org.jfree.data.statistics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * A utility class that provides some simple statistical functions.
 */
public abstract class Statistics {

    /**
     * Returns the mean of an array of numbers.
     *
     * @param values  the values (<code>null</code> permitted, returns <code>Double.NaN</code>).
     *
     * @return The mean.
     */
    public static double calculateMean(final Number[] values) {
        double result = Double.NaN;
        if (values != null && values.length > 0) {
            double sum = 0.0;
            int counter = 0;
            for (; counter < values.length; counter++) {
                sum = sum + values[counter].doubleValue();
            }
            result = (sum / counter);
        }
        return result;
    }

    /**
     * Returns the mean of a collection of <code>Number</code> objects.
     * 
     * @param values  the values (<code>null</code> permitted, returns <code>Double.NaN</code>).
     * 
     * @return The mean.
     */
    public static double calculateMean(final Collection values) {
        
        double result = Double.NaN;
        int count = 0;
        double total = 0.0;
        final Iterator iterator = values.iterator();
        while (iterator.hasNext()) {
            final Object object = iterator.next();
            if (object != null && object instanceof Number) {
                final Number number = (Number) object;
                total = total + number.doubleValue();
                count = count + 1;
            }
        }
        if (count > 0) {
            result = total / count;
        }        
        return result;
        
    }
    
    /**
     * Calculates the median for a list of values (<code>Number</code> objects).  The list
     * of values will be sorted first.
     * 
     * @param values  the values.
     * 
     * @return The median.
     */
    public static double calculateMedian(final List values) {
        return calculateMedian(values, true);
    }
    
    /**
     * Calculates the median for a list of values (<code>Number</code> objects) that are assumed
     * to be in ascending order.
     * 
     * @param values  the values.
     * @param copyAndSort  a flag that controls whether the list of values is copied and sorted.
     * 
     * @return The median.
     */
    public static double calculateMedian(List values, boolean copyAndSort) {
        
        double result = Double.NaN;
        if (values != null) {
            if (copyAndSort) {
                int itemCount = values.size();
                List copy = new ArrayList(itemCount);
                for (int i = 0; i < itemCount; i++) {
                    copy.add(i, values.get(i));   
                }
                Collections.sort(copy);
                values = copy;
            }
            final int count = values.size();
            if (count > 0) {
                if (count % 2 == 1) {
                    if (count > 1) {
                        final Number value = (Number) values.get((count - 1) / 2);
                        result = value.doubleValue();
                    }
                    else {
                        final Number value = (Number) values.get(0);
                        result = value.doubleValue();
                    }
                }
                else {
                    final Number value1 = (Number) values.get(count / 2 - 1);
                    final Number value2 = (Number) values.get(count / 2);
                    result = (value1.doubleValue() + value2.doubleValue()) / 2.0;
                }
            }
        }
        return result;
    }
    
    /**
     * Calculates the median for a sublist within a list of values (<code>Number</code> objects).
     * 
     * @param values  the values (in any order).
     * @param start  the start index.
     * @param end  the end index.
     * 
     * @return The median.
     */
    public static double calculateMedian(final List values, final int start, final int end) {
        return calculateMedian(values, start, end, true);
    }

    /**
     * Calculates the median for a sublist within a list of values (<code>Number</code> objects).
     * The entire list will be sorted if the <code>ascending</code< argument is <code>false</code>.
     * 
     * @param values  the values.
     * @param start  the start index.
     * @param end  the end index.
     * @param copyAndSort  a flag that that controls whether the list of values is copied and 
     *                     sorted.
     * 
     * @return The median.
     */
    public static double calculateMedian(final List values, final int start, final int end,
                                         boolean copyAndSort) {
        
        double result = Double.NaN;
        if (copyAndSort) {
            List working = new ArrayList(end - start + 1);
            for (int i = start; i <= end; i++) {
                working.add(values.get(i));  
            }
            Collections.sort(working); 
            result = calculateMedian(working, false);
        }
        else {
            final int count = end - start + 1;
            if (count > 0) {
                if (count % 2 == 1) {
                    if (count > 1) {
                        final Number value = (Number) values.get(start + (count - 1) / 2);
                        result = value.doubleValue();
                    }
                    else {
                        final Number value = (Number) values.get(start);
                        result = value.doubleValue();
                    }
                }
                else {
                    final Number value1 = (Number) values.get(start + count / 2 - 1);
                    final Number value2 = (Number) values.get(start + count / 2);
                    result = (value1.doubleValue() + value2.doubleValue()) / 2.0;
                }
            }
        }
        return result;    
        
    }
    
    /**
     * Returns the standard deviation of a set of numbers.
     *
     * @param data  the data.
     *
     * @return the standard deviation of a set of numbers.
     */
    public static double getStdDev(final Number[] data) {
        final double avg = getAverage(data);
        double sum = 0.0;

        for (int counter = 0; counter < data.length; counter++) {
            final double diff = data[counter].doubleValue() - avg;
            sum = sum + diff * diff;
        }
        return Math.sqrt(sum / (data.length - 1));
    }

    /**
     * Fits a straight line to a set of (x, y) data, returning the slope and
     * intercept.
     *
     * @param xData  the x-data.
     * @param yData  the y-data.
     *
     * @return a double array with the intercept in [0] and the slope in [1].
     */
    public static double[] getLinearFit(final Number[] xData, final Number[] yData) {

        // check arguments...
        if (xData.length != yData.length) {
            throw new IllegalArgumentException(
                "Statistics.getLinearFit(...): array lengths must be equal.");
        }

        final double[] result = new double[2];
        // slope
        result[1] = getSlope(xData, yData);
        // intercept
        result[0] = getAverage(yData) - result[1] * getAverage(xData);

        return result;

    }

    /**
     * Finds the slope of a regression line using least squares.
     *
     * @param xData  an array of Numbers (the x values).
     * @param yData  an array of Numbers (the y values).
     *
     * @return the slope.
     */
    public static double getSlope(final Number[] xData, final Number[] yData) {

        // check arguments...
        if (xData.length != yData.length) {
            throw new IllegalArgumentException(
                "Statistics.getSlope(...): array lengths must be equal.");
        }

        // ********* stat function for linear slope ********
        // y = a + bx
        // a = ybar - b * xbar
        //     sum(x * y) - (sum (x) * sum(y)) / n
        // b = ------------------------------------
        //     sum (x^2) - (sum(x)^2 / n
        // *************************************************

        // sum of x, x^2, x * y, y
        double sx = 0.0, sxx = 0.0, sxy = 0.0, sy = 0.0;
        int counter;
        for (counter = 0; counter < xData.length; counter++) {
            sx = sx + xData[counter].doubleValue();
            sxx = sxx + Math.pow(xData[counter].doubleValue(), 2);
            sxy = sxy + yData[counter].doubleValue() * xData[counter].doubleValue();
            sy = sy + yData[counter].doubleValue();
        }
        return (sxy - (sx * sy) / counter) / (sxx - (sx * sx) / counter);

    }

    /**
     * Calculates the correlation between two datasets.  Both arrays should contain the same number
     * of items.  Null values are treated as zero.
     * <P>
     * Information about the correlation calculation was obtained from:
     * 
     * http://trochim.human.cornell.edu/kb/statcorr.htm
     * 
     * @param data1  the first dataset.
     * @param data2  the second dataset.
     * 
     * @return The correlation.
     */
    public static double getCorrelation(final Number[] data1, final Number[] data2) {
        if (data1 == null) {
            throw new IllegalArgumentException("Null 'data1' argument.");
        }
        if (data2 == null) {
            throw new IllegalArgumentException("Null 'data2' argument.");
        }
        if (data1.length != data2.length) {
            throw new IllegalArgumentException(
                "'data1' and 'data2' arrays must have same length."
            );   
        }
        final int n = data1.length;
        double sumX = 0.0;
        double sumY = 0.0;
        double sumX2 = 0.0;
        double sumY2 = 0.0;
        double sumXY = 0.0;
        for (int i = 0; i < n; i++) {
            double x = 0.0;
            if (data1[i] != null) {
                x = data1[i].doubleValue();   
            }
            double y = 0.0;
            if (data2[i] != null) {
                y = data2[i].doubleValue();   
            }
            sumX = sumX + x;
            sumY = sumY + y;
            sumXY = sumXY + (x * y);
            sumX2 = sumX2 + (x * x);
            sumY2 = sumY2 + (y * y);
        }
        return (n * sumXY - sumX * sumY) 
            / Math.pow((n * sumX2 - sumX * sumX) * (n * sumY2 - sumY * sumY), 0.5);      
    }

    /**
     * Returns a data set for a moving average on the data set passed in.
     *
     * @param xData  an array of the x data.
     * @param yData  an array of the y data.
     * @param period  the number of data points to average
     *
     * @return a double[][] the length of the data set in the first dimension,
     *         with two doubles for x and y in the second dimension
     */
    public static double[][] getMovingAverage(final Number[] xData, 
                                              final Number[] yData, 
                                              final int period) {

        // check arguments...
        if (xData.length != yData.length) {
            throw new IllegalArgumentException(
                "Statistics.getMovingAverage(...): array lengths must be equal.");
        }

        if (period > xData.length) {
            throw new IllegalArgumentException(
                "Statistics.getMovingAverage(...): period can't be longer than dataset.");
        }

        final double[][] result = new double[xData.length - period][2];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = xData[i + period].doubleValue();
            // holds the moving average sum
            double sum = 0.0;
            for (int j = 0; j < period; j++) {
                sum += yData[i + j].doubleValue();
            }
            sum = sum / period;
            result[i][1] = sum;
        }
        return result;

    }
    
    //// DEPRECATED CODE /////////////////////////////////////////////////////////////////////////
    
    /**
     * Returns the average of a set of numbers.
     *
     * @param data  the data.
     *
     * @return The average of a set of numbers.
     * 
     * @deprecated Renamed calculateMean().
     */
    public static double getAverage(final Number[] data) {
        double sum = 0.0;
        int counter = 0;
        for (; counter < data.length; counter++) {
            sum = sum + data[counter].doubleValue();
        }
        return (sum / counter);
    }


}
