CREATE TABLE `jsonstructure` (
  `id` varchar(255) NOT NULL,
  `position` int(11) NOT NULL,
  `encodedJson` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`,`position`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
