# Seguridad en UltimoFM 2

La seguridad es un tema muy importante en este proyecto. Por eso, se ha creado este documento para
explicar cómo se ha implementado la seguridad.

## Conexión a la base de datos

Las credenciales para el acceso a la base de datos de uso público se incluyen directamente en el
código fuente. Esto es así porque la base de datos es de uso público para evitar tener que crear
una base de datos en local en cada máquina de desarrollo. Esto no es un problema de seguridad
porque la base de datos es de uso público, no contiene información sensible y los permisos están
limitados a acciones no destructivas sobre las bases de datos en cuestión.

Además, todas las conexiones con la base de datos por defecto (alojada en Microsoft Azure) se hacen
mediante TLS 1.2, por lo que no hay riesgo de que los datos se intercepten en tránsito. Los datos
están cifrados en tránsito y en reposo por contraseñas gestionadas por Microsoft. Esto evita
problemas de acceso no autorizado a la base de datos.

## Autenticación

La autenticación de usuarios del programa se realiza con usuario y contraseña. La contraseña es
verificada
por el propio cliente (ya que no hay un servidor central que gestione el acceso) contra un
`hash` Bcrypt recuperado de la base de datos. Esto evita que los datos de acceso se envíen en
texto plano a la base de datos.

Las contraseñas nunca se almacenan en texto plano en la base de datos, ya que si se filtrase,
tendría
resultados catastróficos. En su lugar, se almacenan los `hash` Bcrypt de las contraseñas. Esto evita
que a partir del `hash` se pueda obtener la contraseña original.

## Usuarios de la base de datos

Existen dos bases de datos: `proyectoud2_ariel_abel_login` para los usuarios
y `proyectoud2_ariel_abel` para los artistas. Cada base de datos utiliza una conexión JDBC
diferente, por lo que no es posible acceder a la base de datos de artistas a través de la de
usuarios. Además, los usuarios de acceso a la base de datos son distintos para cada base de datos,
con lo que en un entorno realmente de producción, no sería posible acceder a la base de datos de
artistas a través de la de usuarios.