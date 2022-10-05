insert into genero (id, descripcion) values('1', 'Terror');
insert into genero (id, descripcion) values('2', 'Aventura');
insert into genero (id, descripcion) values('3', 'Accion');

insert into plataforma (id, descripcion) values('1', 'Steam');
insert into plataforma (id, descripcion) values('2', 'Playstation');
insert into plataforma (id, descripcion) values('3', 'Nintendo');
insert into plataforma (id, descripcion) values('4', 'Xbox');
insert into plataforma (id, descripcion) values('5', 'Windows');
insert into plataforma (id, descripcion) values('6', 'Mac OS');

insert into usuario (email, password, nombre, foto, biografia) values ('admin@gmail.com','123','admin','perfil.jpg', 'soy admin');

insert into videojuego (poster, nombre, desarrollador, duracion, cantidadJugadores, sinopsis) values ('zeldabotw.jpg', 'The Legend Of Zelda', 'Nintendo', '55', '1','In this 3D open-world entry in the Zelda series, Link is awakened from a deep slumber without his past memories in the post-apocalyptic Kingdom of Hyrule, and sets off on a journey to defeat the ancient evil Calamity Ganon. Link treks, climbs and glides through fields, forests and mountain ranges while meeting and helping friendly folk and defeating enemies in order to gather up the strength to face Ganon.')
insert into videojuego_genero(videojuego_id, genero_id) values ('1','2')

insert into videojuego (poster, nombre, duracion) values ('godofwar.jpg', 'God Of War', '2')
insert into videojuego (poster, nombre, duracion) values ('revillage.jpg', 'Resident Evil Village', '3')
insert into videojuego (poster, nombre, duracion) values ('cyberpunk.jpg', 'Cyberpunk 2077', '4')

insert into pelicula (poster, nombre, duracion) values ('pelicula1.jpg', 'American Psycho', '2')
insert into pelicula (poster, nombre, duracion) values ('pelicula2.jpg', 'Nightcrawler', '3')
insert into pelicula (poster, nombre, duracion) values ('pelicula3.jpg', 'Lord of the Rings', '4')
insert into pelicula (poster, nombre, duracion) values ('pelicula4.jpg', 'Fight Club', '1')