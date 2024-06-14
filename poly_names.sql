
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Base de données : `poly_names`
--

-- --------------------------------------------------------

--
-- Structure de la table `carte`
--

CREATE TABLE `carte` (
  `Id` int(11) NOT NULL,
  `IdMot` int(11) DEFAULT NULL,
  `IdPartie` int(11) DEFAULT NULL,
  `Couleur` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `couleur`
--

CREATE TABLE `couleur` (
  `id` int(11) NOT NULL,
  `coulleur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `jouer`
--

CREATE TABLE `jouer` (
  `IdPartie` int(11) NOT NULL,
  `IdJoueur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `joueur`
--

CREATE TABLE `joueur` (
  `Id` int(11) NOT NULL,
  `Nom` text DEFAULT NULL,
  `role` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `mot`
--

CREATE TABLE `mot` (
  `Id` int(11) NOT NULL,
  `Texte_du_mot` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `mot`
--

INSERT INTO `mot` (`Id`, `Texte_du_mot`) VALUES
(1, 'Arbre'),
(2, 'Bateau'),
(3, 'Chat'),
(4, 'Danse'),
(5, 'Éléphant'),
(6, 'Fenêtre'),
(7, 'Guitare'),
(8, 'Hôtel'),
(9, 'Île'),
(10, 'Jardin'),
(11, 'Koala'),
(12, 'Lampe'),
(13, 'Montagne'),
(14, 'Nuage'),
(15, 'Océan'),
(16, 'Papier'),
(17, 'Question'),
(18, 'Raison'),
(19, 'Soleil'),
(20, 'Téléphone'),
(21, 'Univers'),
(22, 'Voiture'),
(23, 'Wagon'),
(24, 'Pluie'),
(25, 'Oiseau'),
(26, 'Zèbre'),
(27, 'Amour'),
(28, 'Ballon'),
(29, 'Ciel'),
(30, 'Désert'),
(31, 'École'),
(32, 'Forêt'),
(33, 'Glace'),
(34, 'Horloge'),
(35, 'Image'),
(36, 'Joie'),
(37, 'Kiwi'),
(38, 'Livre'),
(39, 'Maison'),
(40, 'Nuit'),
(41, 'Orange'),
(42, 'Piano'),
(43, 'Quartz'),
(44, 'Rose'),
(45, 'Sable'),
(46, 'Table'),
(47, 'Urgence'),
(48, 'Vase'),
(49, 'Loup'),
(50, 'Fraise');

-- --------------------------------------------------------

--
-- Structure de la table `partie`
--

CREATE TABLE `partie` (
  `Id` int(11) NOT NULL,
  `Score_final` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `tour`
--

CREATE TABLE `tour` (
  `Numéro` int(11) NOT NULL,
  `IdPartie` int(11) DEFAULT NULL,
  `Score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `carte`
--
ALTER TABLE `carte`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `IdMot` (`IdMot`),
  ADD KEY `IdPartie` (`IdPartie`);

--
-- Index pour la table `couleur`
--
ALTER TABLE `couleur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `jouer`
--
ALTER TABLE `jouer`
  ADD PRIMARY KEY (`IdPartie`,`IdJoueur`),
  ADD KEY `IdJoueur` (`IdJoueur`);

--
-- Index pour la table `joueur`
--
ALTER TABLE `joueur`
  ADD PRIMARY KEY (`Id`);

--
-- Index pour la table `mot`
--
ALTER TABLE `mot`
  ADD PRIMARY KEY (`Id`);

--
-- Index pour la table `partie`
--
ALTER TABLE `partie`
  ADD PRIMARY KEY (`Id`);

--
-- Index pour la table `tour`
--
ALTER TABLE `tour`
  ADD PRIMARY KEY (`Numéro`),
  ADD KEY `IdPartie` (`IdPartie`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `mot`
--
ALTER TABLE `mot`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `carte`
--
ALTER TABLE `carte`
  ADD CONSTRAINT `carte_ibfk_1` FOREIGN KEY (`IdMot`) REFERENCES `mot` (`Id`),
  ADD CONSTRAINT `carte_ibfk_2` FOREIGN KEY (`IdPartie`) REFERENCES `partie` (`Id`);

--
-- Contraintes pour la table `jouer`
--
ALTER TABLE `jouer`
  ADD CONSTRAINT `jouer_ibfk_1` FOREIGN KEY (`IdPartie`) REFERENCES `partie` (`Id`),
  ADD CONSTRAINT `jouer_ibfk_2` FOREIGN KEY (`IdJoueur`) REFERENCES `joueur` (`Id`);

--
-- Contraintes pour la table `tour`
--
ALTER TABLE `tour`
  ADD CONSTRAINT `tour_ibfk_1` FOREIGN KEY (`IdPartie`) REFERENCES `partie` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
