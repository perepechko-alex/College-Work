TYPE=TRIGGERS
triggers='CREATE DEFINER=`root`@`localhost` TRIGGER `retailstore_AINS` AFTER INSERT ON `retailstore` \nFOR EACH ROW\nbegin\ndelete from AmountInStockSummary;\n\ninsert AmountInStockSummary\nselect AlbumName, min(AmountInStock), max(AmountInStock), avg(AmountInStock)\nfrom retailstore group by AlbumName;\nend'
sql_modes=1073741824
definers='root@localhost'
client_cs_names='utf8'
connection_cl_names='utf8_general_ci'
db_cl_names='latin1_swedish_ci'
