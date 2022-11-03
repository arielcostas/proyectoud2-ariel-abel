# ÚltimoFM 🎵

Busca la información de tus artistas favoritos!

![img.png](doc/img1.png)

## Introducción

ÚltimoFM es una aplicación gráfica multiplataforma para buscar información de artistas musicales empleando
la [API de Last.fm](https://last.fm/api). Al iniciar la aplicación, aparece un cuadro de búsqueda para buscar posibles
coincidencias por su nombre, tras lo que se puede acceder desde la tabla a la página de un artista individual.

## Manual de usuario 👥

Nada más ejecutar el programa, comprobará si hay un archivo `ultimofm.properties` en el directorio donde se encuentra.
Si no hay tal archivo, el programa no funcionará. Las credenciales de acceso por defecto son el usuario `admin` y la
contraseña `1234`, pero se pueden modificar en el archivo `ultimofm.properties` cambiando las propiedades `app.usuario`
y `app.contraseña` (un hash bcrypt de una contraseña). Tras introducir las credenciales correctas, se muestra una
interfaz donde se puede escribir el nombre del artista que se desea consultar.

![img.png](doc/img2.png)

Al realizar la búsqueda, el programa propondrá una lista de artistas con base en las coincidencias encontradas. Si se
pulsa uno de los cuatro botones de la parte superior guardará esa lista de artistas en un archivo, dependiendo del botón
que se pulse. El primer botón guarda como JSON, el segundo, como XML, el siguiente en texto plano CSV y, por último,
como un objeto binario de Java. Finalmente, existe un botón para cerrar el programa.

Al seleccionar cualquiera de estos artistas se pasará a una ventana donde se muestra de forma pormenorizada la
información del artista; así como un botón para volver al buscador. El resto de botones sirven para lo mismo que antes
esta vez guardando la información concreta del artista seleccionado.

![img.png](doc/img3.png)

## Manual de desarrollador 🛠

Este programa se trata de una aplicación JavaFX con Gradle, dentro del módulo 'app'. El archivo `module-info.java`
dentro del main contiene el módulo de Java con las distintas exportaciones y requisitos de paquetes. Entrando al paquete
`com.github.cgainstitution.proyectoud1arielabel.app` encontramos una primera clase `HelloApplication` que se encarga de
arrancar la aplicación con el controlador principal (`MainWindowController`) y la interfaz gráfica en FXML.

El paquete `controller` incluye el controlador de cada "pantalla" de la aplicación: la pantalla
principal `MainWindowController` y la página de datos del artista `ArtistDataWindowController`.

En `service`, se contiene la capa de servicio donde se realiza la "lógica de negocio", es decir,
hacer llamadas a la API remota, validaciones, guardar objetos a archivos...

Dentro de `datasource` se realizan las llamadas a la API de Last.fm, desde Jackson mediante URL y leyendo a los POJO
generados mediante el plugin `RoboPOJOGenerator` de IntelliJ IDEA en los paquetes `models`.

Después está `dto`, que contiene _Data Transfer Objects_ para pasar los datos de un artista individual entre
los dos controladores, y luego guardarlo a archivos de distintos formatos (JSON, XML, Texto plano CSV y objeto binario).
Aquí se utiliza en algunos DTO los `record` de Java 14, que son inmutables y evitan tener que crear y mantener
getters/setters, constructores...

Para entender mejor los componentes de la arquitectura de este programa, el siguiente diagrama (elaboración propia)
puede ser de ayuda:

![Diagrama de la arquitectura](doc/diagrama.png)

## Reparto de tareas 📋

La interfaz gráfica fue realizada por Ariel Costas. Entre sus tareas estuvo desarrollar las funcionalidades de las
ventanas como los botones, las distintas escenas, diseño del programa etc. También añadió e implemento las _DTO_ o _Data
Transfer Object_ en la lógica del programa y desarrolló parte del sistema de inicio de sesión.

La conexión con la API y el sistema de transmisión de datos fue realizado por Abel Rodríguez. Entre sus tareas estuvo
la conexión de la API LastFM (DataSource) y el desarrollo de las funciones para guardar los archivos con distintas
extensiones en los Service. Además de corrección de bugs en el programa.

## Extras

Se realizaron los siguientes extras en el Proyecto:

- Ordenación de resultados de las consultas y almacenaje de los datos.
- Control de errores (errores de ficheros, consultas sin resultados...)
- Uso de autentificación en la API.
- Adición de un login (control de acceso restringido) con usuario y contraseña contenidos en un fichero de Properties.

## Propuestas

- Incluir mas métodos de búsqueda como cantidad de oyentes, tags(género o estilo musical), álbums etc.
- Mejoras a la interfaz gráfica, o uso de una hoja de estilos distinta (AtlantaFX, BootstrapFX...)
- Implementación de la caché de respuestas

## Otros créditos

Los siguientes proyectos y herramientas fueron útiles en la realización de este proyecto:

- [mvnrepository.com](https://mvnrepository.com/): Encontrar dependencias útiles para el proyecto
- [Bootstrap Icons](https://icons.getbootstrap.com/): Iconos en la aplicación (Licencia MIT)
- JetBrains Code with Me: Codificación en pareja de forma remota
- [Javadoc de JavaFX 8](https://docs.oracle.com/javase/8/javafx/) Documentación de JavaFX para Java 8 de Oracle

## Conclusiones

Abel: Este ha sido mi primer proyecto a esta escala y me ha parecido que el trabajo ha quedado bastante bien hecho desde
el punto de vista de mis capacidades. En gran parte la experiencia de mi compañero ha sido lo que ha hecho que el
proyecto avanzase sin complicaciones, pero siempre incluyéndome en el trabajo realizado y explicándome las partes que
no comprendía. En mi opinión personal he de decir que creo que el programa merece un diez, ya que cumple con todo lo
requerido e incluye varios extras.

Ariel: Es la primera vez que en un trabajo de clase tengo que aprender tanto por mi cuenta y _buscarme la vida_ por mi
cuenta, lo cual es de agradecer, ya que la mejor forma de aprender es haciendo, y no leyendo de un PDF. Ahora bien,
JavaFX ha sido complicado de usar en cuanto a compilación y despliegue, como la mayoría de herramientas de escritorio.

Trabajar con un compañero ha sido enriquecedor, ya que hay dos puntos de vista y cuatro ojos sobre el mismo código, y
más de una vez las preguntas de Abel me han hecho replantear código y funcionalidades, o encontrar fallos que yo habría
pasado por alto. Además, me dio la oportunidad de enseñarle lo (no mucho) que sé de GitHub y otras herramientas de
colaboración.

En total le he dedicado unas 9 horas de clase, y otro tanto en casa, principalmente depurando problemas con JavaFX y
realizando mejoras a la interfaz gráfica, como diseñando un logo o remplazando los iconos. Relativo a la cualificación,
el trabajo cumple con todos los requisitos y se han realizado varios extras, que en total suman el 100% de la nota, con
lo que podría ser un 10.