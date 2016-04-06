<html>
<head>
<title>Update Artist Record</title>
<cfquery name="update" datasource="music" dbtype="ODBC">
update artist set Name='#artist_name#', YearsActive='#years_active#', Genres = '#genres#' where Name='#artist_name#'
</cfquery>
<Body>
<h1> Artist information has been updated</h1><br>
<P align=center></p>

<P align=center><A href="http://localhost:8500/CSC570WebDB/SampleWebSite.html">Back to Home</A></P>


</Body>
</html>
