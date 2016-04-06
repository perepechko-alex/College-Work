<html>
<head>
<title>Delete Artist</title>
<cfquery name="delete" datasource="music" dbtype="ODBC">
delete from artist where Name='#artist_name#'
</cfquery>
<Body>
<h1> Artist has been deleted</h1><br>
<P align=center></p>

<P align=center><A href="http://localhost:8500/CSC570WebDB/SampleWebSite.html">Back to Home</A></P>


</Body>
</html>
