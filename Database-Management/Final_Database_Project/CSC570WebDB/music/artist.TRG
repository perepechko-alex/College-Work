TYPE=TRIGGERS
triggers='CREATE DEFINER=`root`@`localhost` TRIGGER `artist_AINS` AFTER INSERT ON `artist` FOR EACH ROW\nbegin\ninsert into Log values(concat(\'artist has been added by \' ,current_user(),\n\'on \',current_date()));\nend'
sql_modes=1073741824
definers='root@localhost'
client_cs_names='utf8'
connection_cl_names='utf8_general_ci'
db_cl_names='latin1_swedish_ci'
