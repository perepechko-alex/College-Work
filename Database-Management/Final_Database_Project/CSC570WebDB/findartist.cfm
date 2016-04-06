<html>
<cfquery name="findartist" datasource="music" dbtype="ODBC">

select * from artist where Name='#artist_name#'


</cfquery>



<Head>
	<title> Artist Database </title>
</Head>
<Body>

<font size="+8">Find Artist's Record:</font> <br> <br>




<cfif findartist.Name gt 0>

<Cfoutput query="findartist">




Artist's Name:

<input name=artist_name type=text value=#Name#>


Artist ID:

<input name=artist_id type=text value=#idArtist#>


Years Active:

<input name=years_active type=text value=#YearsActive#>

<br><br>


</cfoutput>

<cfelse>


<font size="+6"> Artist Does not Exist </font>

</cfif>





<P align=center></p>

<P align=center><A href="http://localhost:8500/CSC570WebDB/SampleWebSite.html">Back to Home</A></P>



</Body>
</html>

