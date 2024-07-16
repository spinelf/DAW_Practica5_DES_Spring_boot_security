![AD1](https://github.com/user-attachments/assets/176ee3bd-021b-43f5-88c5-07334f132dfa)

## APP WEB: ROLE_CLIENTE
 

Una empresa quiere  lanzar  su propia aplicación web de compra online(por tanto el tema será libre, excepto montar una librería). Para  ello, nos cuenta los  detalles  en  una  entrevista  y llegamos  a la conclusión de que  se tiene  que  manipular la siguiente información básica:

Usuarios: ID numérico (PK), nombre, apellidos, fecha de nacimiento (solo mayores de edad), email (unívoco) y contraseña (aplicar  medidas de seguridad).
Roles: (id_rol entero autoincrementado, nombre del rol: ROLE_CLIENTE, ROLE_ADMON).
 
Direcciones: ID numérico  (PK),  código  postal  (atención al  formatoLinks to an external site.), localidad, calle, número,   piso   (opcional)   y  letra   (opcional).   Los   clientes   pueden  tener   varias direcciones    Por  otro  lado,  una  dirección  puede estar asociada  a varios clientes (pensemos en familiares que  conviven  en la misma casa, trabajadores de la misma oﬁcina, etc.).
 
Tarjetas bancarias:   ID   numérico   (PK),  número  de  tarjeta  (unívoco;  atención  al  formatoLinks to an external site.),  nombre del titular, fecha de caducidad (mes y año)  y CVV (código  de tres dígitos  que  está en el reverso). Los clientes pueden tener  varias tarjetas asociadas. Deberán elegir con  cuál  quieren pagar al ﬁnalizar  el proceso de compra. Así mismo, una  tarjeta puede estar asociada a varios clientes (pensemos en familiares que comparten tarjeta, por ejemplo).
 
Productos: ID numérico (PK), nombre (unívoco), descripción, precio y stock.
 
Compras realizadas(Pedidos):  ID numérico  (PK),  fecha de  realización  (día,  mes, año  y hora).
Todas las compras tienen  una dirección de entrega asociada. El cliente  que realice  la compra elegirá  cuál  de  las  que  tiene  registradas.  Lo mismo  ocurre  con  la tarjeta bancaria  escogida.  Una compra tiene  un conjunto  de  productos y las  unidades  de cada uno, y el precio de venta, así como  un producto puede estar asociado a múltiples compras.

Las funcionalidades que tiene que aportar la web son las siguientes:

     Ofrecer siempre  un  componente de  navegación  (menú  desplegable,  header,  ) hacia  las distintas secciones del sitio, que se gestionará mediante las etiquetas de seguridad que proporciona los taglib de spring security).
 
    Mostrar una sección de inicio (home) al acceder a la URL principal. Un usuario puede entrar como invitado y navegar para ver y hacer carrito.

    Registrar clientes  nuevos,  aportando la  información  necesaria  y en  los  formatos especiﬁcados.
 
    Iniciar sesión de un cliente mediante sus credenciales: email y contraseña(esta se encriptará en la base de datos).

    Registrar tarjetas bancarias (requerido haber iniciado sesión).

    Registrar direcciones (requerido haber iniciado sesión).

    Mostrar una sección de catálogo para  visualizar los distintos productos. Se valorará la posibilidad de aplicar  algún tipo de ﬁltro de ordenación (alfabética, por precio…).

    Ofrecer una  barra  de  búsqueda en  la sección del catálogo para  localizar  productos concretos.

    Mostrar los detalles de un producto al seleccionarlo.
 
    Agregar productos  al   carrito   de   compra,   pudiendo   seleccionar   las   unidades deseadas. El carrito permanecerá en sesión, y cundo esta se cierre, los productos seleccionados en carrito, 
    con la cantidad elegida(no mas de 10 por producto), se registrarán en la base de datos:
 
    Daremos de alta un pedido con el estado “carrito”, y grabaremos los productos de este carrito.
  
    Cuando un usuario se autentica, si tiene un pedido en estado carrito, recuperamos sus productos y los ponemos en una lista en memoria.
 
    Procesar una compra: pagar y registrarla en la BD.
    
    Cuando quiera comprar, eliminamos las filas de la tabla, y grabamos las que tenga el carrito en este momento; el estado del pedido cambiará a “comprado”.
    
    No contemplamos otros estados, como serían el seguimiento del pedido hasta su entrega y o devolución.
 
    Tendremos una opción (requerido haber iniciado sesión), para visualizar las compras o pedidos realizados, con la lista de los productos comprados en cada compra..
 

## APP WEB: ROLE_ADMINISTRADOR
    Dar de Alta, modificar y borrar Productos
    Dar de alta usuarios de rol_administrador
    Ver los pedidos realizados en un día, por los distintos clientes, con detalle suficiente como para poder empaquetar(supuestamente) el pedido para mandarlo al cliente
    Ver los datos de un cliente: cuantos pedidos ha realizado, el total del importe comprado.
 

## API REST:

API Rest para mostrar datos al exterior. Montar las url’s con las condiciones de entrada/salida para

A cualquiera que nos lo pida:

    Precio de un producto solicitado.
    Listado de productos de un tipo determinado.
    Listado de cuantos clientes de cada provincia tenemos en nuestra base de datos de clientes

## Entregar

El proyecto es FULL-STAK con java spring boot web, data jpa y security. La base del proyecto es web, y una parte api-rest.

Para probar la parte REST, lo podéis hacer con postman, o si alguien se atreve con una pequeña aplicación con angular, para practicar lo aprendido.

Las páginas web serán bonitas y con estilo, como os han enseñado en Diseño de Interfaces Web.

