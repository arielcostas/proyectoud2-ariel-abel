# 脷ltimoFM 馃幍

Busca la informaci贸n de tus artistas favoritos!

![img.png](doc/img1.png)

## Introducci贸n

脷ltimoFM es una aplicaci贸n gr谩fica multiplataforma para buscar informaci贸n de artistas musicales
empleando
una base de datos relacional. Al iniciar la aplicaci贸n, aparece un cuadro de b煤squeda para buscar
posibles
coincidencias por su nombre, tras lo que se puede acceder desde la tabla a la p谩gina de un artista
individual.

## Manual de usuario 馃懃

NOTA: Una conexi贸n a Internet ser谩 necesaria para ejecutar el programa, salvo que se instale la base
de datos MySQL y los archivos de datos en el equipo local. Para hacer esto, despu茅s se debe invocar
el JAR
desde la l铆nea de comandos con las siguientes variables de entorno.

| Variable    | Descripci贸n                                                              | Predeterminado                                                                        |
|-------------|--------------------------------------------------------------------------|---------------------------------------------------------------------------------------|
| DB_URL      | URL de conexi贸n para el servidor MySQL con los datos de artistas         | `jdbc:mysql://dam-aad-ud2.mysql.database.azure.com:3306/proyectoud2_ariel_abel`       |
| DB_USER     | Nombre de usuario de la base de datos de artistas                        | `usuario_artistas`                                                                    |
| DB_PASS     | Contrase帽a del usuario de la base de datos de artistas                   | `yYTng2wg`                                                                            |
| LOGINDB_URL | URL de la conexi贸n para el servidor MySQL con los usuarios y contrase帽as | `jdbc:mysql://dam-aad-ud2.mysql.database.azure.com:3306/proyectoud2_ariel_abel_login` |
| DB_USER     | Nombre de usuario de la base de datos de artistas                        | `usuario_login`                                                                       |
| DB_PASS     | Contrase帽a del usuario de la base de datos de artistas                   | `7WQzdXsv`                                                                            |

Las credenciales de acceso por defecto son el usuario `admin` y la
contrase帽a `1234`. Tras introducir las credenciales correctas, se muestra una
interfaz donde se puede escribir el nombre del artista que se desea consultar.

![img.png](doc/img2.png)

Al realizar la b煤squeda, el programa propondr谩 una lista de artistas con base en las coincidencias
encontradas. Si se pulsa uno de los cuatro botones de la parte superior guardar谩 esa lista de
artistas en un archivo, dependiendo del bot贸n que se pulse. El primer bot贸n guarda como JSON, el
segundo, como XML, el siguiente en texto plano CSV y, por 煤ltimo, como un objeto binario de Java.
Finalmente, existe un bot贸n para cerrar el programa y otro para insertar un nuevo artista.

Al seleccionar cualquiera de estos artistas se pasar谩 a una ventana donde se muestra de forma
pormenorizada la informaci贸n del artista; as铆 como un bot贸n para volver al buscador. El resto de
botones sirven para lo mismo que antes esta vez guardando la informaci贸n concreta del artista
seleccionado.

![img.png](doc/img3.png)

## Manual de desarrollador 馃洜

Este programa se trata de una aplicaci贸n JavaFX con Gradle, dentro del m贸dulo 'app'. El
archivo `module-info.java`
dentro del main contiene el m贸dulo de Java con las distintas exportaciones y requisitos de paquetes.
Entrando al paquete
`com.github.cgainstitution.proyectoud1arielabel.app` encontramos una primera
clase `Main` que se encarga de
arrancar la aplicaci贸n JavaFX `UltimoFMApplication` y la interfaz gr谩fica
en FXML.

El paquete `controller` incluye el controlador de cada "pantalla" de la aplicaci贸n: la pantalla
principal `MainWindowController` y la p谩gina de datos del artista `ArtistDataWindowController`,
adem谩s de las de los di谩logos `DialogoLogin` y `DialogoCrear`.

En `service`, se contiene la capa de servicio donde se realiza la "l贸gica de negocio", es decir,
hacer llamadas a la base de datos, validaciones, guardar objetos a archivos...

Dentro de `datasource` se realizan las llamadas a la base de datos de artistas, con sus
corrrespondientes consultas y recuperando a los modelos en `models`.

Por 煤ltimo, los `models` son `record` de Java 14 que contienen los datos de los artistas que
recupera de la base de datos. ResumenArtista contiene los datos b谩sicos de un artista (para un
resultado de b煤squeda) y Artista contiene todos los datos de un artista.

Para entender mejor los componentes de la arquitectura de este programa, el siguiente diagrama (
elaboraci贸n propia)
puede ser de ayuda:

![Diagrama de la arquitectura](doc/diagrama.png)

## Reparto de tareas 馃搵

_Nota: A partir del trabajo de la UD1_

El esquema y dataset de la base de datos se ha realizado por Ariel. La implementaci贸n de las nuevas
partes de la aplicaci贸n (interfaz gr谩fica, controladores, servicios...) se ha realizado por Abel,
con ayuda puntual de Ariel. La documentaci贸n se ha redactado por ambos. El diagrama de la
arquitectura fue creado por Ariel. La seguridad fue implementada por Ariel, con ayuda de Abel
revisando el c贸digo por posibles vulnerabilidades. Finalmente, la base de datos en Azure fue
desplegada por Abel, con la ayuda de Ariel para configurar el servidor.

## Extras

Se realizaron los siguientes extras en el Proyecto:

- Ordenaci贸n de resultados de las consultas y almacenaje de los datos (mediante la tabla de JavaFX).
- Control de errores (errores de ficheros, consultas sin resultados...)
- Adici贸n de un login (control de acceso restringido) con usuario y contrase帽a contenidos en una
  base de datos distinta. Ver [SEGURIDAD.md](SEGURIDAD.md) para m谩s informaci贸n.

## Propuestas

- Mejoras a la interfaz gr谩fica, o uso de una hoja de estilos distinta (AtlantaFX, BootstrapFX...)

## Otros cr茅ditos

Los siguientes proyectos y herramientas fueron 煤tiles en la realizaci贸n de este proyecto:

- [mvnrepository.com](https://mvnrepository.com/): Encontrar dependencias 煤tiles para el proyecto
- [Bootstrap Icons](https://icons.getbootstrap.com/): Iconos en la aplicaci贸n (Licencia MIT)
- JetBrains Code with Me: Codificaci贸n en pareja de forma remota
- [Javadoc de JavaFX 8](https://docs.oracle.com/javase/8/javafx/) Documentaci贸n de JavaFX para Java
  8 de Oracle
- [Comunidad de JavaFX en Reddit](https://www.reddit.com/r/javafx/) Ayuda para generar un JAR
  multiplataforma con JavaFX desde Maven.
- [Microsoft Azure](https://azure.microsoft.com/es-es/) Proveer cr茅dito educativo para el uso de
  servicios de Azure, en este caso, el servidor MySQL.

## Conclusiones

Abel: Este proyecto ha sido una buena oportunidad para aprender a usar m谩s JavaFX que fue un apartado
que no hab铆a tocado en profundidad en el anterior proyecto. Adem谩s, ha sido una buena oportunidad para
conocer m谩s sobre la seguridad en aplicaciones Java, y c贸mo implementarla de forma sencilla.

Ariel: Este trabajo fue bastante m谩s sencillo de lo que esperaba, ya que Abel se manejaba mejor por el
c贸digo y con Git, adem谩s de que pude hacer bastante limpieza, reduciendo la complejidad del c贸digo y
eliminando c贸digo innecesario.

En total le he dedicado unas 5 horas de clase, principalmente explicando cosas que pueden ser complejas a Abel, y
haciendo pruebas de concepto para ver si funcionaba lo que quer铆amos hacer. Adem谩s de corrigiendo fallos y dise帽ando
las nuevas funcionalidades (login contra base de datos, inserci贸n y eliminaci贸n de artistas).