# qpa-back-alliance
Descripción
Este proyecto es una aplicación de gestión de productos diseñada para optimizar y automatizar la administración de inventarios en tiempo real. La solución permite el manejo de productos, su stock y la validación de los niveles de inventario, proporcionando una interfaz sencilla y robusta para gestionar los productos en una empresa de logística global como Maersk. A través de esta aplicación, se busca mejorar la eficiencia operativa y minimizar los errores humanos asociados a la gestión manual de inventarios.

La arquitectura ha sido diseñada con un enfoque en escalabilidad, mantenimiento y eficiencia, garantizando una integración sencilla con otros sistemas empresariales, tanto internos como de terceros.

Arquitectura
Patrón de Arquitectura
Se ha empleado una arquitectura basada en microservicios para una mayor flexibilidad, escalabilidad y mantenibilidad. Cada componente se encuentra desacoplado, lo que facilita su evolución independiente, despliegue y pruebas.

Tecnologías Empleadas
Spring Boot: Framework utilizado para el desarrollo de microservicios, que permite una rápida configuración y despliegue.

JPA (Jakarta Persistence API): Para la persistencia de datos utilizando una base de datos relacional (MySQL).

Spring Data JPA: Abstracción que simplifica la interacción con la base de datos a través de la creación de repositorios de acceso a datos.

Mockito: Herramienta para realizar pruebas unitarias y mockear dependencias en el código, permitiendo testear los componentes de manera aislada.

Validation API de Jakarta: Para asegurar que los datos proporcionados a la aplicación cumplen con las restricciones definidas en las entidades.

Logback: Utilizado para la gestión de logs de la aplicación, lo que facilita el seguimiento y la resolución de problemas.

Estructura del Proyecto
El proyecto sigue una estructura de capas bien definida que incluye:

Capa de Presentación (Controller): Expuesta como servicios RESTful mediante los controladores, que reciben las peticiones y envían las respuestas.

Capa de Servicio: Contiene la lógica de negocio que opera sobre los modelos de datos.

Capa de Persistencia (Repository): Utiliza JPA para interactuar con la base de datos.

Capa de Excepciones: Encapsula el manejo centralizado de excepciones.

Integración con la Base de Datos
La aplicación interactúa con una base de datos MySQL, donde se almacena la información de los productos. La entidad Product es persistida a través de un repositorio JPA utilizando las anotaciones de Jakarta Persistence.

Validaciones
Las validaciones son una parte fundamental del proyecto para asegurar que los datos ingresados cumplan con las reglas de negocio y los requisitos de calidad:

Validación de Campo Nulo: Se emplean las anotaciones @NotBlank para asegurarse de que los campos críticos (como name y code) no sean vacíos.

Validación de Valores Positivos: Se usa @Positive para garantizar que las cantidades como el currentStock y minimumStock sean números positivos.

Restricciones de Unicidad: Se implementa @Column(unique = true) para asegurar que el código del producto sea único en la base de datos.

Estas validaciones se encuentran en las entidades de dominio y son procesadas automáticamente por el framework durante las operaciones de persistencia.

Manejo de Excepciones
El manejo de excepciones en la aplicación sigue un enfoque centralizado, proporcionando una respuesta coherente ante errores. Cuando se produce una excepción, se captura y se responde con un mensaje apropiado y un código de estado HTTP adecuado.

Excepciones Personalizadas
Se ha implementado una clase GlobalExceptionHandler que captura excepciones generales y específicas, como la ProductNotFoundException o la ConstraintViolationException, y las traduce en respuestas HTTP claras y comprensibles para el usuario.

ProductNotFoundException: Esta excepción es lanzada cuando un producto no es encontrado en la base de datos.

ValidationException: Se lanza cuando los datos no cumplen con las validaciones definidas, como un valor negativo para el stock.

Respuesta Estandarizada
Las respuestas de error siguen una estructura uniforme, facilitando el procesamiento en la capa cliente y asegurando que el usuario reciba información útil en caso de fallo.

Pruebas Unitarias
Se ha implementado un enfoque robusto de pruebas unitarias para garantizar que la lógica de negocio funcione correctamente antes de su despliegue. Las pruebas están diseñadas para simular las interacciones entre las distintas capas de la aplicación y asegurar que los métodos se comporten de manera esperada.

Herramientas de Test
JUnit 5: Para escribir las pruebas unitarias, se utiliza JUnit 5, que proporciona una infraestructura flexible y extensible.

Mockito: Se usa para simular comportamientos de las dependencias y asegurar que los métodos interactúan correctamente con otras partes del sistema.

AssertJ: Para realizar aserciones más expresivas y legibles en las pruebas.

Estrategia de Pruebas
Pruebas de Repositorio: Se aseguran de que las operaciones de base de datos (como la búsqueda de productos por código) funcionen correctamente.

Pruebas de Servicio: Validan que la lógica de negocio se ejecute correctamente y que las validaciones sean activadas cuando se ingrese un dato incorrecto.

Pruebas de Excepciones: Se comprueba que las excepciones sean lanzadas correctamente y que se devuelvan las respuestas adecuadas.

Constantes
Se han definido varias constantes dentro del proyecto para evitar la duplicación de cadenas de texto y valores en el código fuente. Estas constantes incluyen mensajes de error, códigos de estado HTTP y valores predeterminados para diversas operaciones.
