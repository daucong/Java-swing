USE [BanDoAnVat]
GO
/****** Object:  Table [dbo].[Danhmuc_sp]    Script Date: 5/22/2021 10:13:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Danhmuc_sp](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[TenDM] [nvarchar](50) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DonHang]    Script Date: 5/22/2021 10:13:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonHang](
	[ID] [nvarchar](50) NOT NULL,
	[MaDH] [nvarchar](50) NULL,
	[MaKH] [nvarchar](50) NULL,
	[HotenKH] [nvarchar](50) NULL,
	[TenSP] [nvarchar](50) NULL,
	[Soluong] [int] NULL,
	[Giaban] [int] NULL,
 CONSTRAINT [PK_DonHang_1] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Donhanghoa]    Script Date: 5/22/2021 10:13:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Donhanghoa](
	[Madhh] [nvarchar](50) NOT NULL,
	[TenSP] [varchar](50) NULL,
	[Ngay_dathang] [date] NULL,
	[Ngay_ketThuc] [date] NULL,
	[tinh_trang] [bit] NULL,
 CONSTRAINT [PK_Donhanghoa] PRIMARY KEY CLUSTERED 
(
	[Madhh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Hoadon]    Script Date: 5/22/2021 10:13:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Hoadon](
	[MaHD] [nvarchar](50) NOT NULL,
	[Ngaylay_hd] [nvarchar](50) NULL,
	[tinh_trang] [bit] NULL,
 CONSTRAINT [PK_Hoadon] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 5/22/2021 10:13:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [nvarchar](50) NOT NULL,
	[Hoten] [nvarchar](50) NULL,
	[Gioitinh] [bit] NULL,
	[Diachi] [nvarchar](50) NULL,
	[SDT] [varchar](50) NULL,
	[Tinhtrang] [bit] NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[login]    Script Date: 5/22/2021 10:13:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[login](
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NULL,
 CONSTRAINT [PK_login] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Quanly_sp]    Script Date: 5/22/2021 10:13:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Quanly_sp](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[TenSP] [varchar](50) NULL,
	[TenDM] [varchar](50) NULL,
	[Giaban] [int] NULL,
	[Mota] [text] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Danhmuc_sp] ON 

INSERT [dbo].[Danhmuc_sp] ([id], [TenDM]) VALUES (15, N'Kem ')
INSERT [dbo].[Danhmuc_sp] ([id], [TenDM]) VALUES (16, N'Bánh 1 tuần')
INSERT [dbo].[Danhmuc_sp] ([id], [TenDM]) VALUES (17, N'Bim bim')
INSERT [dbo].[Danhmuc_sp] ([id], [TenDM]) VALUES (18, N'Nước Ngọt')
INSERT [dbo].[Danhmuc_sp] ([id], [TenDM]) VALUES (19, N'Bánh mì')
INSERT [dbo].[Danhmuc_sp] ([id], [TenDM]) VALUES (20, N'Trà')
INSERT [dbo].[Danhmuc_sp] ([id], [TenDM]) VALUES (21, N'Bánh Ngọt')
SET IDENTITY_INSERT [dbo].[Danhmuc_sp] OFF
GO
INSERT [dbo].[DonHang] ([ID], [MaDH], [MaKH], [HotenKH], [TenSP], [Soluong], [Giaban]) VALUES (N'2', N'DH02', N'KH02', N'duong', N'Kem', 3, 13000)
INSERT [dbo].[DonHang] ([ID], [MaDH], [MaKH], [HotenKH], [TenSP], [Soluong], [Giaban]) VALUES (N'3', N'DH03', N'KH01', N'daucong', N'Banh chocolate', 2, 40000)
INSERT [dbo].[DonHang] ([ID], [MaDH], [MaKH], [HotenKH], [TenSP], [Soluong], [Giaban]) VALUES (N'4', N'DH04', N'DH03', N'Hoa', N'Kẹo', 10, 40000)
INSERT [dbo].[DonHang] ([ID], [MaDH], [MaKH], [HotenKH], [TenSP], [Soluong], [Giaban]) VALUES (N'5', N'DH05', N'DH05', N'Hoaa', N'Kẹo', 10, 40000)
GO
INSERT [dbo].[Donhanghoa] ([Madhh], [TenSP], [Ngay_dathang], [Ngay_ketThuc], [tinh_trang]) VALUES (N'1', N'Bim cua', CAST(N'2021-05-18' AS Date), CAST(N'2021-05-18' AS Date), 1)
INSERT [dbo].[Donhanghoa] ([Madhh], [TenSP], [Ngay_dathang], [Ngay_ketThuc], [tinh_trang]) VALUES (N'2', N'Bim tôm', CAST(N'2021-05-18' AS Date), CAST(N'2021-05-18' AS Date), 1)
INSERT [dbo].[Donhanghoa] ([Madhh], [TenSP], [Ngay_dathang], [Ngay_ketThuc], [tinh_trang]) VALUES (N'3', N'kem chocolate', CAST(N'2021-05-18' AS Date), CAST(N'2021-05-19' AS Date), 1)
INSERT [dbo].[Donhanghoa] ([Madhh], [TenSP], [Ngay_dathang], [Ngay_ketThuc], [tinh_trang]) VALUES (N'4', N'kem dau xanh', CAST(N'2021-05-18' AS Date), CAST(N'2021-05-20' AS Date), 1)
GO
INSERT [dbo].[Hoadon] ([MaHD], [Ngaylay_hd], [tinh_trang]) VALUES (N'1', N'18/5/2021', 1)
INSERT [dbo].[Hoadon] ([MaHD], [Ngaylay_hd], [tinh_trang]) VALUES (N'2', N'18/5/2021', 1)
INSERT [dbo].[Hoadon] ([MaHD], [Ngaylay_hd], [tinh_trang]) VALUES (N'3', N'19/5/2021', 1)
INSERT [dbo].[Hoadon] ([MaHD], [Ngaylay_hd], [tinh_trang]) VALUES (N'4', N'20/5/2021', 1)
GO
INSERT [dbo].[KhachHang] ([MaKH], [Hoten], [Gioitinh], [Diachi], [SDT], [Tinhtrang]) VALUES (N'KH01', N'daucong', 1, N'I a nan', N'0326475036', 1)
INSERT [dbo].[KhachHang] ([MaKH], [Hoten], [Gioitinh], [Diachi], [SDT], [Tinhtrang]) VALUES (N'KH02', N'tuong', 1, N'I a chía', N'0123456789', 1)
INSERT [dbo].[KhachHang] ([MaKH], [Hoten], [Gioitinh], [Diachi], [SDT], [Tinhtrang]) VALUES (N'KH03', N'duong', 1, N'Quang nam', N'123456', 0)
INSERT [dbo].[KhachHang] ([MaKH], [Hoten], [Gioitinh], [Diachi], [SDT], [Tinhtrang]) VALUES (N'KH04', N'hoa', 0, N'Quangnam', N'123', 1)
INSERT [dbo].[KhachHang] ([MaKH], [Hoten], [Gioitinh], [Diachi], [SDT], [Tinhtrang]) VALUES (N'KH05', N'duongad', 1, N'Quang nam 02', N'123456', 1)
GO
INSERT [dbo].[login] ([username], [password]) VALUES (N'admin', N'1234')
INSERT [dbo].[login] ([username], [password]) VALUES (N'cong', N'110901')
GO
SET IDENTITY_INSERT [dbo].[Quanly_sp] ON 

INSERT [dbo].[Quanly_sp] ([id], [TenSP], [TenDM], [Giaban], [Mota]) VALUES (14, N'Kem chocolate', N'Kem', 5000, N'Ngon')
INSERT [dbo].[Quanly_sp] ([id], [TenSP], [TenDM], [Giaban], [Mota]) VALUES (15, N'Bim cay', N'Bimbim', 2000, N't?t')
INSERT [dbo].[Quanly_sp] ([id], [TenSP], [TenDM], [Giaban], [Mota]) VALUES (16, N'Bánh pia', N'bánh', 10000, N'Siu ngon')
INSERT [dbo].[Quanly_sp] ([id], [TenSP], [TenDM], [Giaban], [Mota]) VALUES (18, N'Kem chuoi', N'Trà', 7000, N'Ngon')
INSERT [dbo].[Quanly_sp] ([id], [TenSP], [TenDM], [Giaban], [Mota]) VALUES (19, N'Trà dá', N'Trà', 0, N'Ðu?c')
INSERT [dbo].[Quanly_sp] ([id], [TenSP], [TenDM], [Giaban], [Mota]) VALUES (20, N'Kem chocolate', N'Kem ', 4000, N'')
INSERT [dbo].[Quanly_sp] ([id], [TenSP], [TenDM], [Giaban], [Mota]) VALUES (21, N'Sinh  t?', N'Kem ', 2000, N'')
INSERT [dbo].[Quanly_sp] ([id], [TenSP], [TenDM], [Giaban], [Mota]) VALUES (22, N'Ya ua', N'Kem ', 3000, N'')
SET IDENTITY_INSERT [dbo].[Quanly_sp] OFF
GO
