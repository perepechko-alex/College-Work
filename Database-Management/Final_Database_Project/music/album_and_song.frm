TYPE=VIEW
query=select `music`.`song`.`AlbumName` AS `AlbumName`,`music`.`song`.`SongName` AS `SongName` from `music`.`song` where (`music`.`song`.`YearReleased` > 1990)
md5=e0d63eb564cfe3608dca4ce23ee77bdf
updatable=1
algorithm=0
definer_user=root
definer_host=localhost
suid=2
with_check_option=0
timestamp=2014-12-02 18:38:16
create-version=1
source=select AlbumName, SongName\nfrom song\nwhere YearReleased > 1990
client_cs_name=utf8
connection_cl_name=utf8_general_ci
view_body_utf8=select `music`.`song`.`AlbumName` AS `AlbumName`,`music`.`song`.`SongName` AS `SongName` from `music`.`song` where (`music`.`song`.`YearReleased` > 1990)
