-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 30 Des 2022 pada 14.37
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fppbo`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id_admin` varchar(10) NOT NULL,
  `nama_admin` varchar(50) NOT NULL,
  `password` varchar(6) NOT NULL,
  `alamat` text NOT NULL,
  `nomor_hp` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id_admin`, `nama_admin`, `password`, `alamat`, `nomor_hp`) VALUES
('1', 'Diah', '3322', 'Jl. Tukad Languan No. 5', '098678654345'),
('2', 'Viencent', '4455', 'Jl. Balembong No. 3', '089976678666'),
('3', 'asdf', 'asdf', 'qwer', '1234');

-- --------------------------------------------------------

--
-- Struktur dari tabel `detailtransaksi`
--

CREATE TABLE `detailtransaksi` (
  `kode_transaksi` varchar(10) NOT NULL,
  `tanggal_transaksi` datetime NOT NULL,
  `kode_menu` varchar(20) NOT NULL,
  `harga` int(15) NOT NULL,
  `qty` int(15) NOT NULL,
  `total_harga` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `detailtransaksi`
--

INSERT INTO `detailtransaksi` (`kode_transaksi`, `tanggal_transaksi`, `kode_menu`, `harga`, `qty`, `total_harga`) VALUES
('100', '2022-12-29 08:33:34', '01', 10000, 1, 10000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `kasir`
--

CREATE TABLE `kasir` (
  `id_kasir` varchar(10) NOT NULL,
  `nama_kasir` varchar(50) NOT NULL,
  `password` varchar(6) NOT NULL,
  `alamat` text NOT NULL,
  `nomor_hp` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `kasir`
--

INSERT INTO `kasir` (`id_kasir`, `nama_kasir`, `password`, `alamat`, `nomor_hp`) VALUES
('1', 'Kamel', '123456', 'Jl. Kendedes No. 25', '085777333444'),
('2', 'Rizki', '654321', 'Jl. Goa Gong No. 5', '087678435333'),
('3', 'qwerty', 'qwerty', 'asdf', '1235');

-- --------------------------------------------------------

--
-- Struktur dari tabel `menu`
--

CREATE TABLE `menu` (
  `kode_menu` varchar(20) NOT NULL,
  `nama_menu` varchar(50) NOT NULL,
  `harga` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `menu`
--

INSERT INTO `menu` (`kode_menu`, `nama_menu`, `harga`) VALUES
('01', 'Mie Angel', 10000),
('02', 'Mie Setan Level 1', 10000),
('03', 'Mie Setan Level 2', 10000),
('04', 'Mie Setan Level 3', 10000),
('05', 'Mie Setan Level 4', 10000),
('06', 'Mie Setan Level 6', 11000),
('07', 'Mie Setan Level 7', 11000),
('08', 'Mie Setan Level 8', 11000),
('09', 'Mie Iblis Level 0', 10000),
('10', 'Mie Iblis Level 1', 10000),
('11', 'Mie Iblis Level 2', 10000),
('12', 'Mie Iblis Level 3', 10000),
('13', 'Mie Iblis Level 4', 10000),
('14', 'Mie Iblis Level 6', 11000),
('15', 'Mie Iblis Level 7', 11000),
('16', 'Mie Iblis Level 8', 11000),
('17', 'Siomay', 9000),
('18', 'Ceker', 9000),
('19', 'Udang Rambutan', 9000),
('20', 'Udang Keju', 9000),
('21', 'Lumpiang Udang', 9000),
('22', 'Pangsit Goreng', 10000),
('23', 'Es Genderuwo', 9000),
('24', 'Es Tuyul', 5000),
('25', 'Es Sundel Bolong', 6000),
('26', 'Es Pocong', 9000),
('27', 'Es Teh', 4000),
('28', 'Es Orange', 5000),
('29', 'Lemon Tea', 6000),
('30', 'Teh Tarik', 6000),
('31', 'Milo', 9000),
('32', 'Vanila Latte', 9000),
('33', 'Air Mineral', 4000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `kode_transaksi` varchar(10) NOT NULL,
  `tanggal_transaksi` datetime NOT NULL,
  `status` int(1) NOT NULL,
  `status_kitchen` int(1) NOT NULL DEFAULT 1,
  `keterangan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`kode_transaksi`, `tanggal_transaksi`, `status`, `status_kitchen`, `keterangan`) VALUES
('1', '2022-12-21 13:22:02', 3, 1, 'Dine In'),
('10', '2022-12-30 19:39:42', 3, 1, 'Dine In'),
('2', '2022-12-21 13:22:02', 2, 1, 'Dine In'),
('3', '2022-12-21 13:22:02', 2, 1, 'Take Away'),
('4', '2022-12-21 13:22:02', 2, 1, 'Take Away'),
('5', '2022-12-21 13:22:02', 1, 1, 'Dine In'),
('6', '2022-12-21 13:22:02', 0, 3, 'Dine In'),
('7', '2022-12-21 13:22:02', 3, 1, 'Dine In'),
('8', '2022-12-21 13:22:02', 2, 1, 'Dine In'),
('9', '2022-12-30 17:11:48', 2, 1, 'Dine In');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi_temporary`
--

CREATE TABLE `transaksi_temporary` (
  `no_meja` varchar(5) NOT NULL,
  `nama_pelanggan` varchar(10) NOT NULL,
  `kode_transaksi` varchar(10) NOT NULL,
  `tanggal_transaksi` datetime NOT NULL,
  `kode_menu` varchar(20) NOT NULL,
  `harga` int(15) NOT NULL,
  `qty` int(15) NOT NULL,
  `total_harga` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaksi_temporary`
--

INSERT INTO `transaksi_temporary` (`no_meja`, `nama_pelanggan`, `kode_transaksi`, `tanggal_transaksi`, `kode_menu`, `harga`, `qty`, `total_harga`) VALUES
('21', 'rizki', '1', '2022-12-21 13:22:02', '01', 10000, 1, 10000),
('21', 'rizki', '1', '2022-12-21 13:22:02', '02', 10000, 1, 10000),
('99', 'rty', '10', '2022-12-30 19:36:35', '01', 10000, 1, 10000),
('1', 'qwerty', '2', '2022-12-21 13:22:02', '01', 10000, 1, 10000),
('1', 'qwerty', '2', '2022-12-21 13:22:02', '02', 10000, 2, 20000),
('1', 'qwerty', '2', '2022-12-21 13:22:02', '05', 10000, 2, 20000),
('11', 'asdfg', '3', '2022-12-02 00:00:00', '01', 10000, 1, 10000),
('10', 'bnm', '6', '2022-12-21 13:22:02', '18', 9000, 2, 18000),
('56', 'fgh', '7', '2022-12-30 07:48:01', '23', 9000, 2, 18000),
('34', 'tyui', '8', '2022-12-21 13:22:02', '01', 10000, 1, 10000),
('34', 'tyui', '8', '2022-12-21 13:22:02', '02', 10000, 1, 10000),
('78', 'bola', '9', '2022-12-30 17:11:36', '10', 10000, 2, 20000),
('78', 'bola', '9', '2022-12-30 17:11:42', '17', 9000, 1, 9000);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indeks untuk tabel `detailtransaksi`
--
ALTER TABLE `detailtransaksi`
  ADD PRIMARY KEY (`kode_transaksi`,`kode_menu`);

--
-- Indeks untuk tabel `kasir`
--
ALTER TABLE `kasir`
  ADD PRIMARY KEY (`id_kasir`);

--
-- Indeks untuk tabel `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`kode_menu`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`kode_transaksi`);

--
-- Indeks untuk tabel `transaksi_temporary`
--
ALTER TABLE `transaksi_temporary`
  ADD PRIMARY KEY (`kode_transaksi`,`kode_menu`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
