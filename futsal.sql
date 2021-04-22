-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 17 Agu 2020 pada 03.12
-- Versi server: 10.1.37-MariaDB
-- Versi PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `futsal`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `nik` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `nama_admin` varchar(128) NOT NULL,
  `level` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`nik`, `username`, `password`, `nama_admin`, `level`) VALUES
('13331', 'hilman', '121212', 'M.Hilman', 'admin'),
('13332', 'okta', '121212', 'Okta dwinarto', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `harga`
--

CREATE TABLE `harga` (
  `id` int(11) NOT NULL,
  `hargaperjam` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `harga`
--

INSERT INTO `harga` (`id`, `hargaperjam`) VALUES
(1, 100000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `member`
--

CREATE TABLE `member` (
  `faktur` varchar(50) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `telp` varchar(12) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `paket` varchar(20) NOT NULL,
  `harga` int(20) NOT NULL,
  `tanggalmulai` date NOT NULL,
  `tanggalselesai` date NOT NULL,
  `hari` varchar(20) NOT NULL,
  `jammulai` int(20) NOT NULL,
  `jamakhir` int(20) NOT NULL,
  `lapangan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `member`
--

INSERT INTO `member` (`faktur`, `nama`, `telp`, `alamat`, `paket`, `harga`, `tanggalmulai`, `tanggalselesai`, `hari`, `jammulai`, `jamakhir`, `lapangan`) VALUES
('M0001', 'Rendi', '081209087787', 'Bekasi', 'paket 1', 800000, '2020-05-24', '2020-06-24', 'Selasa', 3, 5, 'A'),
('M0002', 'Farhan', '08129075379', 'Bekasi', 'Paket 1', 400000, '2020-06-07', '2020-07-07', 'Sabtu', 1, 2, 'B'),
('M0003', 'Rahman', '08129036790', 'Bekasi', 'Paket 2', 800000, '2020-06-14', '2020-07-14', 'Sabtu', 5, 7, 'B'),
('M0004', 'Mulyadi', '081298976590', 'Bekasi', 'Paket 1', 400000, '2020-06-07', '2020-07-07', 'Kamis', 5, 6, 'A'),
('M0006', 'Gunawan', '081290129012', 'Bekasi', 'Paket 1', 400000, '2020-06-28', '2020-07-28', 'Senin', 7, 8, 'A');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pemesanan`
--

CREATE TABLE `pemesanan` (
  `faktur` varchar(128) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `telp` varchar(12) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `mulai` int(20) NOT NULL,
  `selesai` int(20) NOT NULL,
  `tanggal` date NOT NULL,
  `lapangan` varchar(20) NOT NULL,
  `jammain` int(20) NOT NULL,
  `biaya` int(20) NOT NULL,
  `uangmuka` int(20) NOT NULL,
  `sisabayar` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pemesanan`
--

INSERT INTO `pemesanan` (`faktur`, `nama`, `telp`, `alamat`, `mulai`, `selesai`, `tanggal`, `lapangan`, `jammain`, `biaya`, `uangmuka`, `sisabayar`) VALUES
('P0001', 'Heri', '0812080808', 'Bekasi', 1, 3, '2020-05-17', 'A', 2, 200000, 100000, 100000),
('P0002', 'Rizki', '081286519021', 'Bekasi', 3, 6, '2020-05-30', 'B', 3, 600000, 100000, 500000),
('P0003', 'Feri', '081209760912', 'Bekasi', 3, 6, '2020-05-24', 'B', 3, 300000, 100000, 200000),
('P0004', 'Agus', '08129023723', 'Bekasi', 5, 7, '2020-06-14', 'A', 2, 200000, 100000, 100000),
('P0005', 'Deni', '087882927971', 'Bekasi', 5, 7, '2020-06-21', 'A', 2, 200000, 100000, 100000),
('P0006', 'Henri', '0812890890', 'Bekasi', 4, 7, '2020-06-28', 'B', 3, 300000, 100000, 200000),
('P0007', 'Rio', '08980972680', 'Bekasi', 7, 8, '2020-06-29', 'B', 1, 100000, 50000, 50000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tab_paket`
--

CREATE TABLE `tab_paket` (
  `id` int(11) NOT NULL,
  `paket` varchar(128) NOT NULL,
  `bulan` varchar(128) NOT NULL,
  `jam` varchar(128) NOT NULL,
  `harga` varchar(128) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tab_paket`
--

INSERT INTO `tab_paket` (`id`, `paket`, `bulan`, `jam`, `harga`, `tanggal`) VALUES
(3, 'Paket 1', '1 bulan', '1 jam', '400000', '2020-05-27'),
(4, 'Paket 2', '1 bulan', '2 jam', '800000', '2020-05-27'),
(6, 'Paket 3', '1 bulan', '3 jam', '1200000', '2020-05-27');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `notransaksi` varchar(50) NOT NULL,
  `faktur` varchar(50) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `tanggal` date NOT NULL,
  `lapangan` varchar(20) NOT NULL,
  `jammain` int(20) NOT NULL,
  `biaya` int(20) NOT NULL,
  `uangmuka` int(20) NOT NULL,
  `sisabayar` int(20) NOT NULL,
  `bayar` int(20) NOT NULL,
  `kembali` int(20) NOT NULL,
  `tgltransaksi` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`notransaksi`, `faktur`, `nama`, `tanggal`, `lapangan`, `jammain`, `biaya`, `uangmuka`, `sisabayar`, `bayar`, `kembali`, `tgltransaksi`) VALUES
('T0001', 'P0001', 'Heri', '2020-05-17', 'A', 2, 200000, 100000, 100000, 100000, 0, '2020-05-26'),
('T0002', 'P0002', 'Rizki', '2020-05-30', 'B', 3, 600000, 100000, 500000, 500000, 0, '2020-06-09'),
('T0003', 'P0003', 'Feri', '2020-05-24', 'A', 3, 300000, 100000, 200000, 200000, 0, '2020-06-09'),
('T0004', 'P0002', 'Rizki', '2020-05-30', 'B', 3, 600000, 100000, 500000, 500000, 0, '2020-08-15'),
('T0005', 'P0002', 'Rizki', '2020-05-30', 'B', 3, 600000, 100000, 500000, 500000, 0, '2020-08-15'),
('T0006', 'P0002', 'Rizki', '2020-05-30', 'B', 3, 600000, 100000, 500000, 500000, 0, '2020-08-15'),
('T0007', 'P0002', 'Rizki', '2020-05-30', 'B', 3, 600000, 100000, 500000, 500000, 0, '2020-08-16');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transmember`
--

CREATE TABLE `transmember` (
  `notransmember` varchar(50) NOT NULL,
  `nomember` varchar(50) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `paket` varchar(20) NOT NULL,
  `harga` int(20) NOT NULL,
  `bayar` int(20) NOT NULL,
  `kembali` int(20) NOT NULL,
  `tglbayar` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transmember`
--

INSERT INTO `transmember` (`notransmember`, `nomember`, `nama`, `paket`, `harga`, `bayar`, `kembali`, `tglbayar`) VALUES
('T0001', 'M0001', 'Rendi', 'paket 1', 800000, 800000, 0, '2020-05-26'),
('T0002', 'M0002', 'Farhan', 'Paket 1', 400000, 400000, 0, '2020-06-09'),
('T0003', 'M0003', 'Rahman', 'Paket 2', 800000, 800000, 0, '2020-06-09'),
('T0004', 'M0002', 'Farhan', 'Paket 1', 400000, 400000, 0, '2020-08-15'),
('T0005', 'M0003', 'Rahman', 'Paket 2', 800000, 800000, 0, '2020-08-15'),
('T0006', 'M0001', 'Rendi', 'paket 1', 800000, 800000, 0, '2020-08-15'),
('T0007', 'M0001', 'Rendi', 'paket 1', 800000, 800000, 0, '2020-08-16'),
('T0008', 'M0001', 'Rendi', 'paket 1', 800000, 800000, 0, '2020-08-17');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`nik`);

--
-- Indeks untuk tabel `harga`
--
ALTER TABLE `harga`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`faktur`);

--
-- Indeks untuk tabel `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD PRIMARY KEY (`faktur`);

--
-- Indeks untuk tabel `tab_paket`
--
ALTER TABLE `tab_paket`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`notransaksi`);

--
-- Indeks untuk tabel `transmember`
--
ALTER TABLE `transmember`
  ADD PRIMARY KEY (`notransmember`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `harga`
--
ALTER TABLE `harga`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `tab_paket`
--
ALTER TABLE `tab_paket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
