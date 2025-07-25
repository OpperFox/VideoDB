-- Crear base de datos
CREATE DATABASE VideoDB;
USE VideoDB;

-- ========================
-- Tabla principal de usuarios
-- ========================
CREATE TABLE Usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    password VARCHAR(255)
);

-- ========================
-- Registro del contenido multimedia de un usuario
-- ========================
CREATE TABLE UserMediaRegistry (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    rating ENUM('SIN_CALIFICACION', 'HORRIBLE', 'MALO', 'REGULAR', 'BUENO', 'MUY_BUENO', 'SUBLIME'),
    status ENUM('VIENDO', 'COMPLETADO', 'PENDIENTE', 'ABANDONADO', 'PLANIFICADO', 'REVISTO', 'NO_VISTO'),
    favorito BOOLEAN,
    fecha_comienzo DATE,
    reference_url TEXT,
    usuario_id INT,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);

-- ========================
-- Tabla de contenidos multimedia genéricos
-- Puede representar serie, temporada, playlist o saga
-- ========================
CREATE TABLE MediaContent (
    id_glob INT,
    id_loc INT,
    nombre VARCHAR(100),
    tipo ENUM('SERIE', 'TEMPORADA', 'PLAYLIST', 'SAGA'),
    PRIMARY KEY (id_glob, id_loc)
);

-- ========================
-- Relación muchos a muchos entre UserMediaRegistry y MediaContent
-- ========================
CREATE TABLE UserMediaRegistry_MediaContent (
    registry_id INT,
    id_glob INT,
    id_loc INT,
    PRIMARY KEY (registry_id, id_glob, id_loc),
    FOREIGN KEY (registry_id) REFERENCES UserMediaRegistry(id),
    FOREIGN KEY (id_glob, id_loc) REFERENCES MediaContent(id_glob, id_loc)
);

-- ========================
-- Tabla de videos individuales
-- ========================
CREATE TABLE Video (
    id_glob INT,
    id_loc INT,
    nombre VARCHAR(100),
    PRIMARY KEY (id_glob, id_loc)
);

-- ========================
-- URLs asociadas a cada video
-- ========================
CREATE TABLE VideoURL (
    id INT PRIMARY KEY AUTO_INCREMENT,
    video_id_glob INT,
    video_id_loc INT,
    enlace TEXT,
    FOREIGN KEY (video_id_glob, video_id_loc) REFERENCES Video(id_glob, id_loc)
);

-- ========================
-- Información del usuario sobre un video específico
-- ========================
CREATE TABLE UserVideoInfo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    favorito BOOLEAN,
    rating ENUM('SIN_CALIFICACION', 'HORRIBLE', 'MALO', 'REGULAR', 'BUENO', 'MUY_BUENO', 'SUBLIME'),
    status ENUM('VIENDO', 'COMPLETADO', 'PENDIENTE', 'ABANDONADO', 'PLANIFICADO', 'REVISTO', 'NO_VISTO'),
    video_id_glob INT,
    video_id_loc INT,
    usuario_id INT,
    FOREIGN KEY (video_id_glob, video_id_loc) REFERENCES Video(id_glob, id_loc),
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);

-- ========================
-- Historial de visualización de un usuario para un video
-- ========================
CREATE TABLE UserVideoHistory (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE,
    user_video_info_id INT,
    FOREIGN KEY (user_video_info_id) REFERENCES UserVideoInfo(id)
);

-- ========================
-- Tabla de series
-- ========================
CREATE TABLE Serie (
    id INT PRIMARY KEY AUTO_INCREMENT
);

-- ========================
-- Tabla de temporadas, asociadas a series
-- ========================
CREATE TABLE Temporada (
    id INT PRIMARY KEY AUTO_INCREMENT,
    serie_id INT,
    FOREIGN KEY (serie_id) REFERENCES Serie(id)
);

-- ========================
-- Relación Temporada - Video (una temporada tiene muchos episodios)
-- ========================
CREATE TABLE Temporada_Video (
    temporada_id INT,
    video_id_glob INT,
    video_id_loc INT,
    PRIMARY KEY (temporada_id, video_id_glob, video_id_loc),
    FOREIGN KEY (temporada_id) REFERENCES Temporada(id),
    FOREIGN KEY (video_id_glob, video_id_loc) REFERENCES Video(id_glob, id_loc)
);

-- ========================
-- Tabla de playlists
-- ========================
CREATE TABLE Playlist (
    id INT PRIMARY KEY AUTO_INCREMENT
);

-- ========================
-- Relación Playlist - Video (una playlist tiene varios videos)
-- ========================
CREATE TABLE Playlist_Video (
    playlist_id INT,
    video_id_glob INT,
    video_id_loc INT,
    PRIMARY KEY (playlist_id, video_id_glob, video_id_loc),
    FOREIGN KEY (playlist_id) REFERENCES Playlist(id),
    FOREIGN KEY (video_id_glob, video_id_loc) REFERENCES Video(id_glob, id_loc)
);

-- ========================
-- Tabla de sagas de películas
-- ========================
CREATE TABLE Saga (
    id INT PRIMARY KEY AUTO_INCREMENT
);

-- ========================
-- Relación Saga - Video (una saga tiene varias películas/videos)
-- ========================
CREATE TABLE Saga_Video (
    saga_id INT,
    video_id_glob INT,
    video_id_loc INT,
    PRIMARY KEY (saga_id, video_id_glob, video_id_loc),
    FOREIGN KEY (saga_id) REFERENCES Saga(id),
    FOREIGN KEY (video_id_glob, video_id_loc) REFERENCES Video(id_glob, id_loc)
);