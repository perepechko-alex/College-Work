select * from artist;
select * from album;
select * from song;
select * from retailstore;
select * from Album_and_Song;
select * from log;
select * from onlinestore;
select * from criticalreception;
select * from publisher;
select * from tourschedule;
insert into artist values(4444, 'The Beatles', '1960-1970', 'Rock');
insert into album values(4444, 'Wish You Were Here', 'Pink Floyd', '55:17', 1975, -11);
select * from album where TotalSales > 10000000;
select AlbumName from album where TotalSales > 10000000;
select AlbumName, min(AmountInStock), max(AmountInStock), avg(AmountInStock)
from retailstore group by AlbumName;
create view Album_and_Song as
select idAlbum, SongName
from song
where YearReleased > 1990;
select artist.Name from artist union select song.SongName from song;
select artist.Name, album.ReleaseYear, COUNT(album.ReleaseYear) AS ReleaseYear
from (album INNER JOIN artist on album.Artist = artist.Name)
group by TotalSales HAVING COUNT(album.ReleaseYear) > 0;
select ReleaseYear from album where Artist in (select Artist from artist);
delete from artist where artist.idArtist = 4444;
delete from artist, song USING artist, song where artist.idArtist = 3333 and song.single='YES';
update album set TotalSales = 12000000 where album.idAlbum = 1111;
update album, criticalreception set album.TotalSales = album.TotalSales+1000, criticalreception.Rating = '4/5'
where album.idAlbum = '3333' AND criticalreception.idCriticalReception = 5555;
select * from tourschedule,artist where tourschedule.idArtist = artist.idArtist; 