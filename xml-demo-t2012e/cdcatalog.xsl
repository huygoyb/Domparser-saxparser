<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <link rel="stylesheet"
                        herf="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
            </head>
            <body>
                <h1>My CD</h1>
                <table border="1">
                    <tr bgcolor="red">
                        <th>title</th>
                        <th>artist</th>
                        <th>country</th>
                        <th>company</th>
                        <th>price</th>
                        <th>year</th>
                        <th>icon</th>
                    </tr>
                    <xsl:for-each select="catalogg/cd">
                        <xsl:apply-templates select="."/>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="cd">
        <tr>
            <td>
                <xsl:value-of select="title"/>
            </td>
            <td>
                <xsl:value-of select="artist"/>
            </td>
            <td>
                <xsl:apply-templates select="price"/>
            </td>
            <td>
                <xsl:apply-templates select="year"/>
            </td>
        </tr>
    </xsl:template>
    <xsl:template match="price">
        <xsl:value-of select="."/>
        <xsl:if test=". &lt; 9">
            <xsl:text></xsl:text>
            <i class="fas fa-arrow-down" style="color:red"></i>
        </xsl:if>
    </xsl:template>
    <xsl:template match="year">
        <xsl:value-of select="."/>
        <xsl:if test=". &gt;1995">
            <xsl:text></xsl:text>
            <i class="fab fa-hotjar" style="color:red"></i>
        </xsl:if>
    </xsl:template>
</xsl:stylesheet>