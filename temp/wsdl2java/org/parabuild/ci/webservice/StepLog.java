/**
 * StepLog.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package org.parabuild.ci.webservice;

public class StepLog  implements java.io.Serializable {
    private int ID;
    private java.lang.String archiveFileName;
    private java.lang.String description;
    private byte found;
    private java.lang.String path;
    private byte pathType;
    private int stepRunID;
    private long timeStamp;
    private byte type;

    public StepLog() {
    }

    public StepLog(
           int ID,
           java.lang.String archiveFileName,
           java.lang.String description,
           byte found,
           java.lang.String path,
           byte pathType,
           int stepRunID,
           long timeStamp,
           byte type) {
           this.ID = ID;
           this.archiveFileName = archiveFileName;
           this.description = description;
           this.found = found;
           this.path = path;
           this.pathType = pathType;
           this.stepRunID = stepRunID;
           this.timeStamp = timeStamp;
           this.type = type;
    }


    /**
     * Gets the ID value for this StepLog.
     * 
     * @return ID
     */
    public int getID() {
        return ID;
    }


    /**
     * Sets the ID value for this StepLog.
     * 
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }


    /**
     * Gets the archiveFileName value for this StepLog.
     * 
     * @return archiveFileName
     */
    public java.lang.String getArchiveFileName() {
        return archiveFileName;
    }


    /**
     * Sets the archiveFileName value for this StepLog.
     * 
     * @param archiveFileName
     */
    public void setArchiveFileName(java.lang.String archiveFileName) {
        this.archiveFileName = archiveFileName;
    }


    /**
     * Gets the description value for this StepLog.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this StepLog.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the found value for this StepLog.
     * 
     * @return found
     */
    public byte getFound() {
        return found;
    }


    /**
     * Sets the found value for this StepLog.
     * 
     * @param found
     */
    public void setFound(byte found) {
        this.found = found;
    }


    /**
     * Gets the path value for this StepLog.
     * 
     * @return path
     */
    public java.lang.String getPath() {
        return path;
    }


    /**
     * Sets the path value for this StepLog.
     * 
     * @param path
     */
    public void setPath(java.lang.String path) {
        this.path = path;
    }


    /**
     * Gets the pathType value for this StepLog.
     * 
     * @return pathType
     */
    public byte getPathType() {
        return pathType;
    }


    /**
     * Sets the pathType value for this StepLog.
     * 
     * @param pathType
     */
    public void setPathType(byte pathType) {
        this.pathType = pathType;
    }


    /**
     * Gets the stepRunID value for this StepLog.
     * 
     * @return stepRunID
     */
    public int getStepRunID() {
        return stepRunID;
    }


    /**
     * Sets the stepRunID value for this StepLog.
     * 
     * @param stepRunID
     */
    public void setStepRunID(int stepRunID) {
        this.stepRunID = stepRunID;
    }


    /**
     * Gets the timeStamp value for this StepLog.
     * 
     * @return timeStamp
     */
    public long getTimeStamp() {
        return timeStamp;
    }


    /**
     * Sets the timeStamp value for this StepLog.
     * 
     * @param timeStamp
     */
    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }


    /**
     * Gets the type value for this StepLog.
     * 
     * @return type
     */
    public byte getType() {
        return type;
    }


    /**
     * Sets the type value for this StepLog.
     * 
     * @param type
     */
    public void setType(byte type) {
        this.type = type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof StepLog)) return false;
        StepLog other = (StepLog) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ID == other.getID() &&
            ((this.archiveFileName==null && other.getArchiveFileName()==null) || 
             (this.archiveFileName!=null &&
              this.archiveFileName.equals(other.getArchiveFileName()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            this.found == other.getFound() &&
            ((this.path==null && other.getPath()==null) || 
             (this.path!=null &&
              this.path.equals(other.getPath()))) &&
            this.pathType == other.getPathType() &&
            this.stepRunID == other.getStepRunID() &&
            this.timeStamp == other.getTimeStamp() &&
            this.type == other.getType();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getID();
        if (getArchiveFileName() != null) {
            _hashCode += getArchiveFileName().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        _hashCode += getFound();
        if (getPath() != null) {
            _hashCode += getPath().hashCode();
        }
        _hashCode += getPathType();
        _hashCode += getStepRunID();
        _hashCode += new Long(getTimeStamp()).hashCode();
        _hashCode += getType();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(StepLog.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.parabuildci.org/products/parabuild/webservice/parabuild", "StepLog"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("archiveFileName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "archiveFileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("found");
        elemField.setXmlName(new javax.xml.namespace.QName("", "found"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("path");
        elemField.setXmlName(new javax.xml.namespace.QName("", "path"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pathType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pathType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stepRunID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stepRunID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeStamp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timeStamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
