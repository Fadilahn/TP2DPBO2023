-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 12 Apr 2023 pada 17.28
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_myresto`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `account`
--

CREATE TABLE `account` (
  `name` varchar(50) NOT NULL,
  `gender` varchar(16) NOT NULL,
  `job` varchar(50) NOT NULL,
  `username` varchar(16) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(8) NOT NULL,
  `image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `account`
--

INSERT INTO `account` (`name`, `gender`, `job`, `username`, `email`, `password`, `image`) VALUES
('aa', 'Male', 'Karyawan', 'a', 'aa@aaaa.aaa', 'a', 'src/assets/Logo-UPI-Universitas-Pendidikan-Indonesia-Original-PNG.png'),
('M Fadhillah Nursyawal', 'Male', 'Admin', 'admin', 'fadilahnursyawal@upi.edu', 'admin', 'src/assets/default-pp.png');

-- --------------------------------------------------------

--
-- Struktur dari tabel `drinks`
--

CREATE TABLE `drinks` (
  `id_drink` int(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` int(20) NOT NULL,
  `description` text DEFAULT NULL,
  `image` blob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `drinks`
--

INSERT INTO `drinks` (`id_drink`, `name`, `price`, `description`, `image`) VALUES
(1, 'Iced Caramel Macchiato', 25000, 'Espresso shot dituangkan di atas susu dan sirup karamel yang disajikan dingin', 0x443a2f46616468696c2f436f6d707574657220536369656e63652f73656d65737465722d342f6470626f2f636f64652f4170616368654e65746265616e732f6c61746968616e2f7372632f6173736574732f696365642d636172616d656c2d6d616363686961746f2e6a7067),
(2, 'Matcha Latte', 28000, 'Minuman berbasis matcha dengan campuran susu, gula dan whipped cream', 0x443a2f46616468696c2f436f6d707574657220536369656e63652f73656d65737465722d342f6470626f2f636f64652f4170616368654e65746265616e732f6c61746968616e2f7372632f6173736574732f6d61746368612d6c617474652e6a7067),
(3, 'Chocolate Frappuccino', 30000, 'Espresso dicampur dengan susu cokelat, sirup vanila, dan disajikan dingin dengan whipped cream di atasnya', 0x443a2f46616468696c2f436f6d707574657220536369656e63652f73656d65737465722d342f6470626f2f636f64652f4170616368654e65746265616e732f6c61746968616e2f7372632f6173736574732f63686f636f6c6174652d6672617070756363696e6f2e6a7067),
(4, 'Hazelnut Latte', 27000, 'Espresso dicampur dengan susu dan sirup hazelnut, kemudian dihiasi dengan whipped cream', 0x443a2f46616468696c2f436f6d707574657220536369656e63652f73656d65737465722d342f6470626f2f636f64652f4170616368654e65746265616e732f6c61746968616e2f7372632f6173736574732f68617a656c6e75742d6c617474652e6a7067),
(5, 'Mango Smoothie', 32000, 'Smoothie dengan campuran mangga, yogurt, susu, dan es batu', 0x443a2f46616468696c2f436f6d707574657220536369656e63652f73656d65737465722d342f6470626f2f636f64652f4170616368654e65746265616e732f6c61746968616e2f7372632f6173736574732f6d616e676f2d736d6f6f746869652e6a7067),
(6, 'Avocado Milkshake', 35000, 'Minuman segar yang terbuat dari daging buah alpukat yang diblender dengan susu dan gula', 0x443a2f46616468696c2f436f6d707574657220536369656e63652f73656d65737465722d342f6470626f2f636f64652f4170616368654e65746265616e732f6c61746968616e2f7372632f6173736574732f61766f6361646f2d6d696c6b7368616b652e6a7067),
(7, 'Iced Green Tea', 23000, 'Teh hijau yang disajikan dingin dengan sirup gula dan es batu', 0x443a2f46616468696c2f436f6d707574657220536369656e63652f73656d65737465722d342f6470626f2f636f64652f4170616368654e65746265616e732f6c61746968616e2f7372632f6173736574732f696365642d677265656e2d7465612e6a7067),
(8, 'Cinnamon Hot Chocolate', 26000, 'Susu cokelat yang dicampur dengan bubuk kayu manis', 0x443a2f46616468696c2f436f6d707574657220536369656e63652f73656d65737465722d342f6470626f2f636f64652f4170616368654e65746265616e732f6c61746968616e2f7372632f6173736574732f63696e6e616d6f6e2d686f742d63686f636f6c6174652e6a7067),
(9, 'Caramel Affogato', 32000, 'Es krim vanila yang disiram dengan espresso shot dan sirup karamel', 0x443a2f46616468696c2f436f6d707574657220536369656e63652f73656d65737465722d342f6470626f2f636f64652f4170616368654e65746265616e732f6c61746968616e2f7372632f6173736574732f636172616d656c2d6166666f6761746f2e6a7067),
(10, 'Iced Vanilla Latte', 25000, 'Espresso yang dicampur dengan susu dan sirup vanila, kemudian disajikan dingin', 0x443a2f46616468696c2f436f6d707574657220536369656e63652f73656d65737465722d342f6470626f2f636f64652f4170616368654e65746265616e732f6c61746968616e2f7372632f6173736574732f696365642d76616e696c6c612d6c617474652e6a7067);

-- --------------------------------------------------------

--
-- Struktur dari tabel `foods`
--

CREATE TABLE `foods` (
  `id_food` int(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` int(20) NOT NULL,
  `description` text DEFAULT NULL,
  `image` blob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `foods`
--

INSERT INTO `foods` (`id_food`, `name`, `price`, `description`, `image`) VALUES
(1, 'Steak', 250000, 'Daging sapi panggang dengan saus black pepper dan kentang goreng', 0x443a2f46616468696c2f436f6d707574657220536369656e63652f73656d65737465722d342f6470626f2f636f64652f4170616368654e65746265616e732f6c61746968616e2f7372632f6173736574732f737465616b2e6a7067),
(2, 'Pasta Carbonara', 150000, 'Pasta dengan saus creamy dari telur, keju parmesan, dan smoked beef', 0x443a2f46616468696c2f436f6d707574657220536369656e63652f73656d65737465722d342f6470626f2f636f64652f4170616368654e65746265616e732f6c61746968616e2f7372632f6173736574732f70617374612d636172626f6e6172612e6a7067),
(3, 'Grilled Chicken', 120000, 'Ayam bakar dengan bumbu rempah dan nasi putih', 0x443a2f46616468696c2f436f6d707574657220536369656e63652f73656d65737465722d342f6470626f2f636f64652f4170616368654e65746265616e732f6c61746968616e2f7372632f6173736574732f6772696c6c65642d636869636b656e2e6a7067),
(4, 'Fish and Chips', 100000, 'Ikan goreng tepung dengan kentang goreng dan saus tartar', 0x443a2f46616468696c2f436f6d707574657220536369656e63652f73656d65737465722d342f6470626f2f636f64652f4170616368654e65746265616e732f6c61746968616e2f7372632f6173736574732f666973682d616e642d63686970732e6a7067),
(5, 'Caesar Salad', 80000, 'Sayur romaine, crouton, keju parmesan, dan saus caesar', 0x443a2f46616468696c2f436f6d707574657220536369656e63652f73656d65737465722d342f6470626f2f636f64652f4170616368654e65746265616e732f6c61746968616e2f7372632f6173736574732f6361657361722d73616c61642e6a7067),
(6, 'Burger', 120000, 'Roti, patty sapi, keju, selada, tomat, dan saus burger', 0x443a2f46616468696c2f436f6d707574657220536369656e63652f73656d65737465722d342f6470626f2f636f64652f4170616368654e65746265616e732f6c61746968616e2f7372632f6173736574732f6275726765722e6a7067),
(7, 'Fried Rice', 90000, 'Nasi goreng dengan telur, ayam, dan sayuran', 0x443a2f46616468696c2f436f6d707574657220536369656e63652f73656d65737465722d342f6470626f2f636f64652f4170616368654e65746265616e732f6c61746968616e2f7372632f6173736574732f66726965642d726963652e6a7067),
(8, 'Pizza Margherita', 180000, 'Pizza dengan saus tomat, keju mozzarella, dan basil', 0x443a2f46616468696c2f436f6d707574657220536369656e63652f73656d65737465722d342f6470626f2f636f64652f4170616368654e65746265616e732f6c61746968616e2f7372632f6173736574732f70697a7a612d6d6172676865726974612e6a7067),
(9, 'Beef Rendang', 200000, 'Daging sapi yang dimasak dengan bumbu rempah khas Indonesia', 0x443a2f46616468696c2f436f6d707574657220536369656e63652f73656d65737465722d342f6470626f2f636f64652f4170616368654e65746265616e732f6c61746968616e2f7372632f6173736574732f626565662d72656e64616e672e6a7067),
(10, 'Sushi Roll', 150000, 'Nori, nasi, dan isian seperti salmon, avokad, dan mentimun', 0x443a2f46616468696c2f436f6d707574657220536369656e63652f73656d65737465722d342f6470626f2f636f64652f4170616368654e65746265616e732f6c61746968616e2f7372632f6173736574732f73757368692d64656d6f3b2e6a7067);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`username`);

--
-- Indeks untuk tabel `drinks`
--
ALTER TABLE `drinks`
  ADD PRIMARY KEY (`id_drink`);

--
-- Indeks untuk tabel `foods`
--
ALTER TABLE `foods`
  ADD PRIMARY KEY (`id_food`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `drinks`
--
ALTER TABLE `drinks`
  MODIFY `id_drink` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT untuk tabel `foods`
--
ALTER TABLE `foods`
  MODIFY `id_food` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;