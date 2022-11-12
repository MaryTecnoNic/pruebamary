CREATE TABLE [dbo].[marylu](
    [idempleado] [int] IDENTITY(1,1) NOT NULL,
    [nombre] [varchar](50) NULL,
    [apellido] [varchar](50) NULL,
    [sexo] [char](10) NULL,
    CONSTRAINT [PK_marylu] PRIMARY KEY CLUSTERED
(
[idempleado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
