# ProyectoPOO
Su grupo de trabajo ha sido contratado para implementar una solución que permita dar 
acceso a los visitantes a una urbanización de manera más eficiente, para llevar a cabo lo 
anterior expuesto, se deberá crear un permiso de entrada por parte de uno de los residentes, 
lo cual hará que el guardia no tenga que llamar o movilizarse hasta la manzana y villa a 
confirmar si puede pasar el visitante. El guardia igual deberá seguir el protocolo de 
verificación de cédula del usuario y demás normas establecidas.
Especificaciones
El sistema proveerá un menú como el siguiente:
1. Urbanización
2. Residentes
3. Visitantes
4. Colaboradores de la urbanización
5. Permisos de entrada
6. Revisión de entrada
7. Reportes
8. Salir
Al iniciar el sistema debe existir un proceso de carga de datos para crear en memoria objetos para probar el funcionamiento. Llame a este proceso inicializarSistema(), detalles más adelante.
Detalle de cada opción

1, Urbanización
Al iniciar esta opción el usuario podrá visualizar la información de la urbanización.
De la urbanización se registrará nombre, etapa, email administración, detalles de la dirección, constructora y la persona responsable(administrador).
También se podrá modificar alguna de esta información, deberá proveer el mecanismo para realizarlo. El administrador se lo selecciona entre los colaboradores registrados.

2, Residentes
Al iniciar esta opción el usuario podrá visualizar la información de los residentes.
De cada persona se registra su cédula, nombre, teléfono, email, estado(Activo,/Inactivo), mz, villa, cantidad de personas que viven con el residente , urbanización)
Se podrán agregar residentes, editar y eliminar. La acción de eliminar lo que hará es cambiar el estado a Inactivo y además pondrá en estado inactivo algún permiso que haya sido creado por ese residente.
*Por ahora solo un residente por casa.

3, Visitantes
Al iniciar esta opción el usuario podrá visualizar la información de los visitantes.
De cada visitante se registra cédula, nombre, teléfono, email, empresa (en caso que sea repartidor), historial de sanciones (texto).
Se podrán agregar visitantes y editar todos los campos menos la cédula.

4, Colaboradores de la urbanización
Al iniciar esta opción el usuario podrá visualizar la información de los empleados.
De cada empleado se registra cédula, nombre, teléfono, email, puesto de trabajo, tipo de empleado (guardía, administrador, jardinero), estado (activo/inactivo), fecha de inicio actividades, fecha de fin de actividades.

5, Permisos de entrada
Al seleccionar esta opción el usuario podrá visualizar un submenú
1. Crear permiso de entrada
2. Eliminar permiso de entrada
3. Consultar permisos por manzana y villa
El permiso tendrá el estado de: activo, inactivo, caducado, usado.
  1. Crear permiso de entrada
    Se registra la fecha y hora de creación del permiso, se registrará al residente que aprueba y crea el permiso, persona(visitante) que va a ingresar, fecha que va a     ingresar, hora que va a ingresar (dar un rango de 15 minutos antes y después), duración aproximada de visita, creación de código único.
    Aquí se debe verificar que el visitante no tenga ninguna sanción y que la fecha en la que se concede el permiso sea la fecha actual (no se pueden crear permisos       anticipados de más de un día)
  2. Eliminar permiso
    Se pedirá la cédula del residente para poder mostrar sus permisos activos y poder eliminar alguna de ellos. ( el estado cambiará a inactivo)
  3. Consultar permisos por manzana y villa
    Se pedirá la manzana y villa del residente y se mostrarán los permisos ordenados por fecha

6, Revisión de ingreso
Ya con el visitante en la urbanización, el guardia pedirá el código y le pedirá que muestre la cédula en la cámara (para verificar que sea la misma persona que porta la cédula, verificará con el código toda la información y mostrará un mensaje con el estado del permiso (activo, inactivo, caducado, usado) si está activo es porque está la fecha actual en el rango de permiso especificado y podrá ingresar alguna observación adicional.
Luego de esto se actualizará el permiso de registro de entrada con los datos del guardia (quien realizó la revisión pertinente), la observación y el estado(usado).

7, Reportes
Con el número de cédula del Residente se podrá consultar la lista de permisos que ha generado, estado, visitante y observación.
inicializarSistema()
Al iniciar la aplicación deberá tener cargada la información del negocio:
Datos de la urbanización
Un residente,
Dos visitantes,
2 colaboradores(guardias)
1 reserva estado caducada
1 reserva estado inactiva
