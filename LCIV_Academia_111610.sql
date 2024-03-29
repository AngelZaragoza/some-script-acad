USE [master]
GO
/****** Object:  Database [LCIV_Academia_111610]    Script Date: 28/11/2020 15:15:23 ******/
CREATE DATABASE [LCIV_Academia_111610]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'LCIV_Academia_111610', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\LCIV_Academia_111610.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'LCIV_Academia_111610_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\LCIV_Academia_111610_log.ldf' , SIZE = 2048KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [LCIV_Academia_111610] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [LCIV_Academia_111610].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [LCIV_Academia_111610] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [LCIV_Academia_111610] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [LCIV_Academia_111610] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [LCIV_Academia_111610] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [LCIV_Academia_111610] SET ARITHABORT OFF 
GO
ALTER DATABASE [LCIV_Academia_111610] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [LCIV_Academia_111610] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [LCIV_Academia_111610] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [LCIV_Academia_111610] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [LCIV_Academia_111610] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [LCIV_Academia_111610] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [LCIV_Academia_111610] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [LCIV_Academia_111610] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [LCIV_Academia_111610] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [LCIV_Academia_111610] SET  DISABLE_BROKER 
GO
ALTER DATABASE [LCIV_Academia_111610] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [LCIV_Academia_111610] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [LCIV_Academia_111610] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [LCIV_Academia_111610] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [LCIV_Academia_111610] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [LCIV_Academia_111610] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [LCIV_Academia_111610] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [LCIV_Academia_111610] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [LCIV_Academia_111610] SET  MULTI_USER 
GO
ALTER DATABASE [LCIV_Academia_111610] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [LCIV_Academia_111610] SET DB_CHAINING OFF 
GO
ALTER DATABASE [LCIV_Academia_111610] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [LCIV_Academia_111610] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [LCIV_Academia_111610] SET DELAYED_DURABILITY = DISABLED 
GO
USE [LCIV_Academia_111610]
GO
/****** Object:  Table [dbo].[Alumnos]    Script Date: 28/11/2020 15:15:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Alumnos](
	[idAlumno] [int] IDENTITY(1,1) NOT NULL,
	[legajo] [varchar](15) NOT NULL,
	[apellido] [varchar](50) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[direccion] [nvarchar](50) NULL,
	[email] [varchar](60) NULL,
	[fechaNac] [varchar](10) NULL,
	[activo] [bit] NOT NULL,
 CONSTRAINT [PK_Alumnos] PRIMARY KEY CLUSTERED 
(
	[idAlumno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Cursos]    Script Date: 28/11/2020 15:15:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cursos](
	[idCurso] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [nvarchar](50) NOT NULL,
	[descripcion] [nvarchar](300) NOT NULL,
	[costo] [float] NOT NULL,
	[imagenUrl] [nvarchar](150) NULL,
	[activo] [bit] NOT NULL,
 CONSTRAINT [PK_Cursos] PRIMARY KEY CLUSTERED 
(
	[idCurso] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Descuentos]    Script Date: 28/11/2020 15:15:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Descuentos](
	[idDescuento] [int] IDENTITY(1,1) NOT NULL,
	[descripcion] [varchar](50) NOT NULL,
	[porcentDescuento] [int] NOT NULL,
 CONSTRAINT [PK_Descuentos] PRIMARY KEY CLUSTERED 
(
	[idDescuento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Examenes]    Script Date: 28/11/2020 15:15:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Examenes](
	[idExamen] [int] IDENTITY(1,1) NOT NULL,
	[idInscripcion] [int] NOT NULL,
	[idTipoExamen] [int] NOT NULL,
	[fechaExamen] [smalldatetime] NOT NULL,
	[calificacion] [float] NOT NULL,
 CONSTRAINT [PK_Examenes] PRIMARY KEY CLUSTERED 
(
	[idExamen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Inscripciones]    Script Date: 28/11/2020 15:15:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Inscripciones](
	[idInscripcion] [int] IDENTITY(1,1) NOT NULL,
	[idAlumno] [int] NOT NULL,
	[idCurso] [int] NOT NULL,
	[idDescuento] [int] NOT NULL,
	[fechaInscripcion] [varchar](10) NOT NULL,
	[montoDescuento] [float] NOT NULL,
	[montoAbonado] [float] NOT NULL,
 CONSTRAINT [PK_Alumnos_Cursos] PRIMARY KEY CLUSTERED 
(
	[idInscripcion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Programas]    Script Date: 28/11/2020 15:15:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Programas](
	[idPrograma] [int] IDENTITY(1,1) NOT NULL,
	[idAlumno] [int] NOT NULL,
	[nombrePrograma] [varchar](50) NOT NULL,
	[descripcion] [varchar](200) NULL,
	[permiteDescarga] [bit] NOT NULL,
	[cantidadDescargas] [int] NOT NULL,
	[pathDescarga] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Programas] PRIMARY KEY CLUSTERED 
(
	[idPrograma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TiposExamen]    Script Date: 28/11/2020 15:15:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TiposExamen](
	[idTipoExamen] [int] IDENTITY(1,1) NOT NULL,
	[descripcion] [varchar](30) NOT NULL,
 CONSTRAINT [PK_TiposExamen] PRIMARY KEY CLUSTERED 
(
	[idTipoExamen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Alumnos] ON 

INSERT [dbo].[Alumnos] ([idAlumno], [legajo], [apellido], [nombre], [direccion], [email], [fechaNac], [activo]) VALUES (1, N'AGZ123', N'Zaragoza', N'Angel', N'R Saenz Peña 2345', N'', N'1982-03-08', 1)
INSERT [dbo].[Alumnos] ([idAlumno], [legajo], [apellido], [nombre], [direccion], [email], [fechaNac], [activo]) VALUES (2, N'RD876', N'Rodriguez', N'David', N'47 y 35', N'david_ro@ymail.com', N'1987-06-07', 0)
INSERT [dbo].[Alumnos] ([idAlumno], [legajo], [apellido], [nombre], [direccion], [email], [fechaNac], [activo]) VALUES (3, N'AL543', N'Aguilar', N'Lynn', N'Los Nogales', N'', N'1988-01-17', 1)
INSERT [dbo].[Alumnos] ([idAlumno], [legajo], [apellido], [nombre], [direccion], [email], [fechaNac], [activo]) VALUES (4, N'PHG294', N'Pena', N'Hernan', N'Calle Falsa 123', N'', N'1985-02-13', 1)
INSERT [dbo].[Alumnos] ([idAlumno], [legajo], [apellido], [nombre], [direccion], [email], [fechaNac], [activo]) VALUES (5, N'ALB664', N'Benedetto', N'Ana Laura', N'Nuevo Jesús María ', N'bene_laura@jotmail.com', N'1986-09-17', 1)
INSERT [dbo].[Alumnos] ([idAlumno], [legajo], [apellido], [nombre], [direccion], [email], [fechaNac], [activo]) VALUES (6, N'AAL732', N'Altamirano', N'Analia', N'Lote 15 Colonia Caroya', N'', N'', 1)
INSERT [dbo].[Alumnos] ([idAlumno], [legajo], [apellido], [nombre], [direccion], [email], [fechaNac], [activo]) VALUES (7, N'TDR317', N'Tirabosque', N'Desiree', N'Pueblo Nuevo', N'', N'1989-04-20', 1)
SET IDENTITY_INSERT [dbo].[Alumnos] OFF
SET IDENTITY_INSERT [dbo].[Cursos] ON 

INSERT [dbo].[Cursos] ([idCurso], [nombre], [descripcion], [costo], [imagenUrl], [activo]) VALUES (1, N'IntroducciÃ³n a Java', N'Primeros pasos en el desarrollo de aplicaciones de escritorio en Java', 2500, N'https://cdn.pixabay.com/photo/2017/05/19/21/12/java-2327538_960_720.png', 0)
INSERT [dbo].[Cursos] ([idCurso], [nombre], [descripcion], [costo], [imagenUrl], [activo]) VALUES (3, N'Introducción a Python', N'Orientación a objetos, Programación imperativa y, en menor medida, programación funcional', 5600, N'http://lorempixel.com/400/200', 1)
INSERT [dbo].[Cursos] ([idCurso], [nombre], [descripcion], [costo], [imagenUrl], [activo]) VALUES (4, N'Introducción a Angular', N'Angular es un framework para aplicaciones web desarrollado en TypeScript, de cÃ³digo abierto, mantenido por Google, que se utiliza para crear y mantener aplicaciones web de una sola pÃ¡gina.', 3460, N'http://i.imgur.com/Ys2vmh6.jpg', 1)
INSERT [dbo].[Cursos] ([idCurso], [nombre], [descripcion], [costo], [imagenUrl], [activo]) VALUES (5, N'Curso de Programación BackEnd', N'Aprende a crear aplicaciones de gran rendimiento y escalabilidad utilizando Node.js y modernos servicios de bases de datos. Desarrolla un servidor web basado en Javascript.', 6840, N'http://lorempixel.com/500/300/technics/', 1)
INSERT [dbo].[Cursos] ([idCurso], [nombre], [descripcion], [costo], [imagenUrl], [activo]) VALUES (6, N'Fundamentos de JavaScript', N'Lenguaje de programación interpretado, dialecto del estándar ECMAScript. Se define como orientado a objetos, ​ basado en prototipos, imperativo, débilmente tipado y dinámico.', 3200, N'https://cdn.pixabay.com/photo/2018/04/20/21/10/code-3337044_960_720.jpg', 1)
INSERT [dbo].[Cursos] ([idCurso], [nombre], [descripcion], [costo], [imagenUrl], [activo]) VALUES (7, N'Prueba de Edición??', N'A ver a ver... si mantiene el estado eliminado.

// Efectivamente mantiene... //', 1560, N'', 0)
INSERT [dbo].[Cursos] ([idCurso], [nombre], [descripcion], [costo], [imagenUrl], [activo]) VALUES (8, N'Fundamentos de Node.js', N'Node.js es un entorno en tiempo de ejecución multiplataforma, de código abierto, para la capa del servidor (pero no limitándose a ello) basado en el lenguaje de programación JavaScript, asíncrono, con E/S de datos en una arquitectura orientada a eventos y basado en el motor V8 de Google', 4300, N'https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Node.js_logo.svg/200px-Node.js_logo.svg.png', 1)
INSERT [dbo].[Cursos] ([idCurso], [nombre], [descripcion], [costo], [imagenUrl], [activo]) VALUES (9, N'BASH para principiantes', N'GNU Bash o simplemente Bash es un lenguaje de órdenes y shell de Unix que generalmente se ejecuta en una ventana de texto.', 1200, N'https://blog.desdelinux.net/wp-content/uploads/2019/01/bash-logo.jpg.webp', 1)
SET IDENTITY_INSERT [dbo].[Cursos] OFF
SET IDENTITY_INSERT [dbo].[Descuentos] ON 

INSERT [dbo].[Descuentos] ([idDescuento], [descripcion], [porcentDescuento]) VALUES (1, N'Sin Descuento', 0)
INSERT [dbo].[Descuentos] ([idDescuento], [descripcion], [porcentDescuento]) VALUES (2, N'10% Descuento Verano', 10)
INSERT [dbo].[Descuentos] ([idDescuento], [descripcion], [porcentDescuento]) VALUES (3, N'15% Descuento Dos Cursos', 15)
INSERT [dbo].[Descuentos] ([idDescuento], [descripcion], [porcentDescuento]) VALUES (4, N'20% Descuento Alumno Regular', 20)
INSERT [dbo].[Descuentos] ([idDescuento], [descripcion], [porcentDescuento]) VALUES (5, N'30% Descuento Pago Anual', 30)
INSERT [dbo].[Descuentos] ([idDescuento], [descripcion], [porcentDescuento]) VALUES (6, N'100% Descuento Alumno Becado', 100)
SET IDENTITY_INSERT [dbo].[Descuentos] OFF
SET IDENTITY_INSERT [dbo].[Inscripciones] ON 

INSERT [dbo].[Inscripciones] ([idInscripcion], [idAlumno], [idCurso], [idDescuento], [fechaInscripcion], [montoDescuento], [montoAbonado]) VALUES (1, 1, 6, 2, N'2020-01-14', 320, 2880)
INSERT [dbo].[Inscripciones] ([idInscripcion], [idAlumno], [idCurso], [idDescuento], [fechaInscripcion], [montoDescuento], [montoAbonado]) VALUES (2, 4, 3, 4, N'2020-07-06', 1126, 4504)
INSERT [dbo].[Inscripciones] ([idInscripcion], [idAlumno], [idCurso], [idDescuento], [fechaInscripcion], [montoDescuento], [montoAbonado]) VALUES (3, 2, 1, 6, N'2020-02-17', 2500, 0)
INSERT [dbo].[Inscripciones] ([idInscripcion], [idAlumno], [idCurso], [idDescuento], [fechaInscripcion], [montoDescuento], [montoAbonado]) VALUES (4, 3, 1, 4, N'2020-03-06', 500, 2000)
INSERT [dbo].[Inscripciones] ([idInscripcion], [idAlumno], [idCurso], [idDescuento], [fechaInscripcion], [montoDescuento], [montoAbonado]) VALUES (5, 1, 4, 3, N'2020-04-08', 519, 2941)
INSERT [dbo].[Inscripciones] ([idInscripcion], [idAlumno], [idCurso], [idDescuento], [fechaInscripcion], [montoDescuento], [montoAbonado]) VALUES (6, 4, 5, 5, N'2020-03-09', 2052, 4788)
INSERT [dbo].[Inscripciones] ([idInscripcion], [idAlumno], [idCurso], [idDescuento], [fechaInscripcion], [montoDescuento], [montoAbonado]) VALUES (7, 1, 3, 4, N'2020-08-20', 1126, 4504)
INSERT [dbo].[Inscripciones] ([idInscripcion], [idAlumno], [idCurso], [idDescuento], [fechaInscripcion], [montoDescuento], [montoAbonado]) VALUES (8, 5, 5, 4, N'2020-05-15', 1368, 5472)
INSERT [dbo].[Inscripciones] ([idInscripcion], [idAlumno], [idCurso], [idDescuento], [fechaInscripcion], [montoDescuento], [montoAbonado]) VALUES (9, 3, 3, 3, N'2020-05-12', 844.5, 4785.5)
INSERT [dbo].[Inscripciones] ([idInscripcion], [idAlumno], [idCurso], [idDescuento], [fechaInscripcion], [montoDescuento], [montoAbonado]) VALUES (10, 2, 8, 5, N'2020-04-21', 1290, 3010)
INSERT [dbo].[Inscripciones] ([idInscripcion], [idAlumno], [idCurso], [idDescuento], [fechaInscripcion], [montoDescuento], [montoAbonado]) VALUES (11, 6, 6, 1, N'2020-09-17', 0, 3200)
INSERT [dbo].[Inscripciones] ([idInscripcion], [idAlumno], [idCurso], [idDescuento], [fechaInscripcion], [montoDescuento], [montoAbonado]) VALUES (12, 7, 8, 1, N'2019-11-27', 0, 4300)
SET IDENTITY_INSERT [dbo].[Inscripciones] OFF
SET IDENTITY_INSERT [dbo].[Programas] ON 

INSERT [dbo].[Programas] ([idPrograma], [idAlumno], [nombrePrograma], [descripcion], [permiteDescarga], [cantidadDescargas], [pathDescarga]) VALUES (1, 1, N'PrimerUpload', N'Primera prueba de upload de archivos', 1, 2, N'PrimerUpload_1_Hash.txt')
INSERT [dbo].[Programas] ([idPrograma], [idAlumno], [nombrePrograma], [descripcion], [permiteDescarga], [cantidadDescargas], [pathDescarga]) VALUES (2, 4, N'SegundaPrueba', N'PRueba de almacenamiento del path corregido', 1, 1, N'SegundaPrueba_4_Expirt.jpg')
INSERT [dbo].[Programas] ([idPrograma], [idAlumno], [nombrePrograma], [descripcion], [permiteDescarga], [cantidadDescargas], [pathDescarga]) VALUES (3, 3, N'Tercera', N'Falta probar la descarga...', 0, 0, N'Tercera_3_Solucion GlassFish con jdbc - paso 1.jpg')
SET IDENTITY_INSERT [dbo].[Programas] OFF
ALTER TABLE [dbo].[Examenes]  WITH CHECK ADD  CONSTRAINT [FK_Examenes_Inscripciones] FOREIGN KEY([idInscripcion])
REFERENCES [dbo].[Inscripciones] ([idInscripcion])
GO
ALTER TABLE [dbo].[Examenes] CHECK CONSTRAINT [FK_Examenes_Inscripciones]
GO
ALTER TABLE [dbo].[Examenes]  WITH CHECK ADD  CONSTRAINT [FK_Examenes_TiposExamen] FOREIGN KEY([idTipoExamen])
REFERENCES [dbo].[TiposExamen] ([idTipoExamen])
GO
ALTER TABLE [dbo].[Examenes] CHECK CONSTRAINT [FK_Examenes_TiposExamen]
GO
ALTER TABLE [dbo].[Inscripciones]  WITH CHECK ADD  CONSTRAINT [FK_Inscripciones_Alumnos] FOREIGN KEY([idAlumno])
REFERENCES [dbo].[Alumnos] ([idAlumno])
GO
ALTER TABLE [dbo].[Inscripciones] CHECK CONSTRAINT [FK_Inscripciones_Alumnos]
GO
ALTER TABLE [dbo].[Inscripciones]  WITH CHECK ADD  CONSTRAINT [FK_Inscripciones_Cursos] FOREIGN KEY([idCurso])
REFERENCES [dbo].[Cursos] ([idCurso])
GO
ALTER TABLE [dbo].[Inscripciones] CHECK CONSTRAINT [FK_Inscripciones_Cursos]
GO
ALTER TABLE [dbo].[Inscripciones]  WITH CHECK ADD  CONSTRAINT [FK_Inscripciones_Descuentos] FOREIGN KEY([idDescuento])
REFERENCES [dbo].[Descuentos] ([idDescuento])
GO
ALTER TABLE [dbo].[Inscripciones] CHECK CONSTRAINT [FK_Inscripciones_Descuentos]
GO
ALTER TABLE [dbo].[Programas]  WITH CHECK ADD  CONSTRAINT [FK_Programas_Alumnos] FOREIGN KEY([idAlumno])
REFERENCES [dbo].[Alumnos] ([idAlumno])
GO
ALTER TABLE [dbo].[Programas] CHECK CONSTRAINT [FK_Programas_Alumnos]
GO
USE [master]
GO
ALTER DATABASE [LCIV_Academia_111610] SET  READ_WRITE 
GO
