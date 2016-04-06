<Head>
	<title> View Artist Information </title>
</Head>
<font size="+8">ARTIST TABLE:</font> <br> <br>

<cfquery name="viewartist" datasource="music" dbtype="ODBC">
select * from artist;
</cfquery>

<Cfoutput query="viewartist">

Artist ID	: #idArtist# 
Artist Name	: #Name#
Years Active	: #YearsActive#
Genres	: #genres#<br>

<br>
</CFOutput>

<P align=center></p>

<P align=center><A href="http://localhost:8500/CSC570WebDB/SampleWebSite.html">Back to Home</A></P>






