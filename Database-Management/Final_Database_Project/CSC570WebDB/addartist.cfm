<html>
<cfquery name="addartist" datasource="music" dbtype="ODBC" username="root">

insert into artist values('#artist_id#','#artist_name#','#years_active#', '#genres#')
</cfquery>


<head>
	<title> Add Artist</title>
</gead>
<body>
<h1> Artist has been added</h1><br>
<P align=center></p>

<P align=center><A href="http://localhost:8500/CSC570WebDB/SampleWebSite.html">Back to Home</A></P>


</body>
</html>