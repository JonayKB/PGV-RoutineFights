CREATE DATABASE IF NOT EXISTS RoutineFights;
USE RoutineFights;
--
-- Estructura de tabla para la tabla `biomes`
--

CREATE TABLE `biomes` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `dimension_id` int DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;
--
-- Volcado de datos para la tabla `biomes`
--

INSERT INTO `biomes` (`id`, `name`, `dimension_id`)
VALUES (1, 'Plains', 1),
  (2, 'Forest', 1),
  (3, 'Soul Sand Valley', 2),
  (4, 'The Void', 3),
  (5, 'test', 1),
  (6, 'test3', 1),
  (7, 'test3', 1),
  (8, 'test3', 1),
  (9, 'test3', 1),
  (10, 'test3', 1),
  (11, 'test3', 1);
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `dimensions`
--

CREATE TABLE `dimensions` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;
--
-- Volcado de datos para la tabla `dimensions`
--

INSERT INTO `dimensions` (`id`, `name`)
VALUES (1, 'Overworld'),
  (2, 'Nether'),
  (3, 'End'),
  (4, 'Nueva Dimension'),
  (5, 'Nueva Dimension');
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `items`
--

CREATE TABLE `items` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;
--
-- Volcado de datos para la tabla `items`
--

INSERT INTO `items` (`id`, `name`)
VALUES (1, 'Sword'),
  (2, 'Bow'),
  (3, 'Arrow'),
  (4, 'Ender Pearl'),
  (5, 'NuevoItem');
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `items_mobs`
--

CREATE TABLE `items_mobs` (
  `drop_list_id` int NOT NULL,
  `mobs_id` int NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;
--
-- Volcado de datos para la tabla `items_mobs`
--

INSERT INTO `items_mobs` (`drop_list_id`, `mobs_id`)
VALUES (1, 1),
  (2, 2),
  (3, 3),
  (4, 4),
  (5, 1),
  (5, 2),
  (5, 3);
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `items_players`
--

CREATE TABLE `items_players` (
  `items_id` int NOT NULL,
  `players_id` int NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;
--
-- Volcado de datos para la tabla `items_players`
--

INSERT INTO `items_players` (`items_id`, `players_id`)
VALUES (5, 1);
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `mobs`
--

CREATE TABLE `mobs` (
  `id` int NOT NULL,
  `base_attack` int DEFAULT NULL,
  `base_health` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `special_ability` varchar(255) DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;
--
-- Volcado de datos para la tabla `mobs`
--

INSERT INTO `mobs` (
    `id`,
    `base_attack`,
    `base_health`,
    `name`,
    `special_ability`
  )
VALUES (1, 5, 20, 'Zombie', 'None'),
  (2, 10, 20, 'Creeper', 'Explode'),
  (3, 15, 10, 'Ghast', 'Fireball'),
  (4, 7, 40, 'Enderman', 'Teleport');
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `mobs_biomes`
--

CREATE TABLE `mobs_biomes` (
  `spawn_mobs_id` int NOT NULL,
  `biomes_id` int NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;
--
-- Volcado de datos para la tabla `mobs_biomes`
--

INSERT INTO `mobs_biomes` (`spawn_mobs_id`, `biomes_id`)
VALUES (1, 1),
  (1, 2),
  (2, 2),
  (3, 3),
  (4, 4);
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `players`
--

CREATE TABLE `players` (
  `id` int NOT NULL,
  `level` int DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;
--
-- Volcado de datos para la tabla `players`
--

INSERT INTO `players` (
    `id`,
    `level`,
    `nickname`,
    `password`,
    `username`
  )
VALUES (1, 10, 'Hero123', 'securepass', 'hero1');
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;
--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id`, `name`)
VALUES (1, 'ROLE_ADMIN'),
  (5, 'ROLE_USER');
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` int NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `rol_id` int DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;
--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `password`, `username`, `rol_id`)
VALUES (
    3,
    '$2a$10$QecjbCCthiXvWMmIdSrPF.mBuKYoUdVCtt1HB7kIN2bubDH83ePCO',
    'nuevoUser',
    NULL
  ),
  (
    4,
    '$2a$10$QecjbCCthiXvWMmIdSrPF.mBuKYoUdVCtt1HB7kIN2bubDH83ePCO',
    'nuevoUser13123',
    NULL
  ),
  (
    9,
    '$2a$10$QecjbCCthiXvWMmIdSrPF.mBuKYoUdVCtt1HB7kIN2bubDH83ePCO',
    'test',
    1
  ),
  (
    11,
    '$2a$10$QecjbCCthiXvWMmIdSrPF.mBuKYoUdVCtt1HB7kIN2bubDH83ePCO',
    'string',
    5
  ),
  (
    12,
    '$2a$10$QecjbCCthiXvWMmIdSrPF.mBuKYoUdVCtt1HB7kIN2bubDH83ePCO',
    'test2',
    5
  ),
  (
    13,
    '$2a$10$QecjbCCthiXvWMmIdSrPF.mBuKYoUdVCtt1HB7kIN2bubDH83ePCO',
    '1q2w3e4r',
    5
  ),
  (
    14,
    '$2a$10$2QJsbsx2nRLz0kDhaI4KV.tHoEAcT5.qLjKzS0QgfnPP2w/Mwm5gG',
    'nuevoUser3',
    5
  ),
  (
    15,
    '$2a$10$NTHchcCAqPn6palmqYdzg.iMmgtrW3D4EN71Sfkh9AjJL5zzXWZFq',
    'nuevoUserVayaRol',
    5
  ),
  (
    17,
    '$2a$10$nI8zJZEfKtND/XdbDNIN6O2xatSiwmoBJ7R8KdnnCuaQUchGMSoie',
    'nuevoUserVayaRol',
    5
  ),
  (
    18,
    '$2a$10$skOnorBtoDqmbFCR0ZF5ROVy7v3r/5iaQLh9gDr84QWCAo88JCYSu',
    'nuevoUserVayaRol',
    5
  );
--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `biomes`
--
ALTER TABLE `biomes`
ADD PRIMARY KEY (`id`),
  ADD KEY `FKlyurfw2uf5ounxib18ybmdtec` (`dimension_id`);
--
-- Indices de la tabla `dimensions`
--
ALTER TABLE `dimensions`
ADD PRIMARY KEY (`id`);
--
-- Indices de la tabla `items`
--
ALTER TABLE `items`
ADD PRIMARY KEY (`id`);
--
-- Indices de la tabla `items_mobs`
--
ALTER TABLE `items_mobs`
ADD KEY `FK3io0u8xbrnsnlc6fmvfyx7grm` (`mobs_id`),
  ADD KEY `FK4l0ka7f6sviaxxocvri7uauvo` (`drop_list_id`);
--
-- Indices de la tabla `items_players`
--
ALTER TABLE `items_players`
ADD KEY `FK53a5wiruv70k7mrx3oalgs1lk` (`players_id`),
  ADD KEY `FKb2lbr1930naubw58t29cn4f3k` (`items_id`);
--
-- Indices de la tabla `mobs`
--
ALTER TABLE `mobs`
ADD PRIMARY KEY (`id`);
--
-- Indices de la tabla `mobs_biomes`
--
ALTER TABLE `mobs_biomes`
ADD PRIMARY KEY (`spawn_mobs_id`, `biomes_id`),
  ADD KEY `FKns8qw58yop80qbxbi7timhcqh` (`biomes_id`);
--
-- Indices de la tabla `players`
--
ALTER TABLE `players`
ADD PRIMARY KEY (`id`);
--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
ADD PRIMARY KEY (`id`);
--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
ADD PRIMARY KEY (`id`),
  ADD KEY `FKgqf6aajl2lwd68xv9ypxpo7ra` (`rol_id`);
--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `biomes`
--
ALTER TABLE `biomes`
MODIFY `id` int NOT NULL AUTO_INCREMENT,
  AUTO_INCREMENT = 12;
--
-- AUTO_INCREMENT de la tabla `dimensions`
--
ALTER TABLE `dimensions`
MODIFY `id` int NOT NULL AUTO_INCREMENT,
  AUTO_INCREMENT = 6;
--
-- AUTO_INCREMENT de la tabla `items`
--
ALTER TABLE `items`
MODIFY `id` int NOT NULL AUTO_INCREMENT,
  AUTO_INCREMENT = 6;
--
-- AUTO_INCREMENT de la tabla `mobs`
--
ALTER TABLE `mobs`
MODIFY `id` int NOT NULL AUTO_INCREMENT,
  AUTO_INCREMENT = 5;
--
-- AUTO_INCREMENT de la tabla `players`
--
ALTER TABLE `players`
MODIFY `id` int NOT NULL AUTO_INCREMENT,
  AUTO_INCREMENT = 3;
--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
MODIFY `id` int NOT NULL AUTO_INCREMENT,
  AUTO_INCREMENT = 7;
--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
MODIFY `id` int NOT NULL AUTO_INCREMENT,
  AUTO_INCREMENT = 19;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `biomes`
--
ALTER TABLE `biomes`
ADD CONSTRAINT `FKlyurfw2uf5ounxib18ybmdtec` FOREIGN KEY (`dimension_id`) REFERENCES `dimensions` (`id`);
--
-- Filtros para la tabla `items_mobs`
--
ALTER TABLE `items_mobs`
ADD CONSTRAINT `FK3io0u8xbrnsnlc6fmvfyx7grm` FOREIGN KEY (`mobs_id`) REFERENCES `mobs` (`id`),
  ADD CONSTRAINT `FK4l0ka7f6sviaxxocvri7uauvo` FOREIGN KEY (`drop_list_id`) REFERENCES `items` (`id`);
--
-- Filtros para la tabla `items_players`
--
ALTER TABLE `items_players`
ADD CONSTRAINT `FK53a5wiruv70k7mrx3oalgs1lk` FOREIGN KEY (`players_id`) REFERENCES `players` (`id`),
  ADD CONSTRAINT `FKb2lbr1930naubw58t29cn4f3k` FOREIGN KEY (`items_id`) REFERENCES `items` (`id`);
--
-- Filtros para la tabla `mobs_biomes`
--
ALTER TABLE `mobs_biomes`
ADD CONSTRAINT `FK4nkpj7y9hcucld09cxjltmtd` FOREIGN KEY (`spawn_mobs_id`) REFERENCES `mobs` (`id`),
  ADD CONSTRAINT `FKns8qw58yop80qbxbi7timhcqh` FOREIGN KEY (`biomes_id`) REFERENCES `biomes` (`id`);
--
-- Filtros para la tabla `users`
--
ALTER TABLE `users`
ADD CONSTRAINT `FKgqf6aajl2lwd68xv9ypxpo7ra` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`id`) ON DELETE
SET NULL;
COMMIT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */
;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */
;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */
;