<xsl:stylesheet version="1.0" 
		xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
            xmlns:mns="http://www.example.com/mns">
    <xsl:output method="html" indent="yes" />

    <xsl:template match="/">
	<html>
            <head>
                <title>Pavilion</title>
            </head>

            <body>
                <xsl:apply-templates />
                <xsl:apply-templates select="/gem/visualParametrs"/>

            </body>
        </html>
    </xsl:template>

    <xsl:template match="gems" >
        <table border="1">
            <tr>
                <th rowspan="2">Id</th>
                <th rowspan="2">Name</th>
                <th rowspan="2">Preciousness</th>
                <th rowspan="2">Origin</th>
                <th rowspan="2">Color</th>
                <th rowspan="2">Transparency</th>
                <th rowspan="2">Gem. cutting</th>
                <th rowspan="2">Value</th>
            </tr>

            <xsl:for-each select="gem">
                <tr>
                    <tr>
                        <td><xsl:value-of select="@id"/></td>
                        <td><xsl:value-of select="name"/></td>
                        <td><xsl:value-of select="preciousness"/></td>
                        <td><xsl:value-of select="origin"/></td>
                        <td><xsl:value-of select="visualParameters/color"/></td>
                        <td><xsl:value-of select="visualParameters/transparency"/></td>
                        <td><xsl:value-of select="visualParameters/gemCutting"/></td>
                        <td><xsl:value-of select="value"/></td>
                    </tr>
                </tr>
            </xsl:for-each>
        </table>

    </xsl:template>

</xsl:stylesheet>
