TYPE=TRIGGERS
triggers='CREATE DEFINER=`root`@`localhost` TRIGGER `album_ADEL` AFTER DELETE ON `album` \nFOR EACH ROW\nbegin\ndelete from song where AlbumName = old.AlbumName;\nend' 'CREATE DEFINER=`root`@`localhost` TRIGGER `album_BINS` BEFORE INSERT ON `album` \nFOR EACH ROW\nbegin\n	if(new.TotalSales < 0) then\n	insert into log values(\'Invalid sales data\');\n	end if;\nend'
sql_modes=1073741824 1073741824
definers='root@localhost' 'root@localhost'
client_cs_names='utf8' 'utf8'
connection_cl_names='utf8_general_ci' 'utf8_general_ci'
db_cl_names='latin1_swedish_ci' 'latin1_swedish_ci'
