<?xml version="1.0" encoding="US-ASCII"?>
<!--This file was created automatically by html2xhtml-->
<!--from the HTML stylesheets. Do not edit this file.-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<!-- ********************************************************************
     $Id: //depot/dev/bt-open-source/3rdparty/docbookxsl1641/xhtml/keywords.xsl#1 $
     ********************************************************************

     This file is part of the XSL DocBook Stylesheet distribution.
     See ../README or http://nwalsh.com/docbook/xsl/ for copyright
     and other information.

     ******************************************************************** -->

<xsl:template match="keywordset"/>
<xsl:template match="subjectset"/>

<!-- ==================================================================== -->

<xsl:template match="keywordset" mode="html.header">
  <meta xmlns="http://www.w3.org/1999/xhtml" name="keywords">
    <xsl:attribute name="content">
      <xsl:apply-templates select="keyword" mode="html.header"/>
    </xsl:attribute>
  </meta>
</xsl:template>

<xsl:template match="keyword" mode="html.header">
  <xsl:apply-templates/>
  <xsl:if test="following-sibling::keyword">, </xsl:if>
</xsl:template>

<!-- ==================================================================== -->

</xsl:stylesheet>
