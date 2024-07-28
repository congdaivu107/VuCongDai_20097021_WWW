CREATE DATABASE SachBaiTapLon;
USE SachBaiTapLon;

CREATE TABLE KhachHang (
    maKhachHang INT PRIMARY KEY,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    email VARCHAR(255),
    address VARCHAR(255),
    active BIT,
    birthDate DATE,
    phone VARCHAR(20)
);

CREATE TABLE Sach (
    maSach INT PRIMARY KEY,
    tenSach VARCHAR(255),
    tacGia VARCHAR(255),
    mieuTa TEXT,
    giaSach DECIMAL(10, 2),
    danhGia DECIMAL(3, 2),
    ngayXuatBang DATE
);

CREATE TABLE GioHang (
    maKhachHang INT,
    maSach INT,
    SoLuong INT,
    ghiChu TEXT,
    PRIMARY KEY (maKhachHang, maSach),
    FOREIGN KEY (maKhachHang) REFERENCES KhachHang(maKhachHang),
    FOREIGN KEY (maSach) REFERENCES Sach(maSach)
);

CREATE TABLE TaiKhoan (
    idTaiKhoan INT PRIMARY KEY,
    taiKhoan VARCHAR(255),
    password VARCHAR(255),
    status BIT,
    role VARCHAR(255),
    maKhachHang INT,
    FOREIGN KEY (maKhachHang) REFERENCES KhachHang(maKhachHang)
);

CREATE TABLE Photo (
    idPhoto INT PRIMARY KEY,
    maKhachHang INT,
    photo VARCHAR(255),
    FOREIGN KEY (maKhachHang) REFERENCES KhachHang(maKhachHang)
);

CREATE TABLE BinhLuan (
    maBinhLuan INT PRIMARY KEY,
    tenNguoi VARCHAR(255),
    noiDung TEXT,
    maSach INT,
    FOREIGN KEY (maSach) REFERENCES Sach(maSach)
);

CREATE TABLE Image (
    idImage INT PRIMARY KEY,
    maSach INT,
    photo VARCHAR(255),
    FOREIGN KEY (maSach) REFERENCES Sach(maSach)
);

CREATE TABLE ThongTinKhac (
    Sach_maSach INT,
    thongTinThem VARCHAR(255),
    PRIMARY KEY (maSach, thongTinThem),
    FOREIGN KEY (maSach) REFERENCES Sach(maSach)
);
