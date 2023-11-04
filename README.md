# Examen Techniva

Prueba: MovieTest

El presente proyecto tiene como finalidad el poder valorar la implementación de una API proveniente del portal [TMDB](https://www.themoviedb.org/?language=es), con el objetivo de obtener el listado de películas, todo por medio de la implementación del patrón de arquitectura MVVM.

## Requisitos de la prueba

1. Pantalla de Búsqueda:
  - Debe contener un campo de búsqueda donde los usuarios puedan introducir el nombre de una película.
  - Al presionar "Buscar", se deben mostrar los resultados de la búsqueda en una lista de películas, con al menos el título de la película y el póster.
  - Los resultados de la búsqueda deben mostrarse de forma paginada (cargando más resultados a medida que el usuario se desplaza).
2. Pantalla de Detalles:
  - Al hacer clic en una película de la lista de resultados, los usuarios deben ser llevados a una pantalla de detalles.
  - En la pantalla de detalles, muestra información adicional sobre la película, como el título, la descripción, la fecha de lanzamiento y el póster.
3. Utiliza la API de TMDb para obtener los datos de las películas. Debes registrarte en el sitio web de TMDb para obtener una clave de API gratuita.
4. Debes utilizar Kotlin para escribir el código de la aplicación.
5. Implementa un patrón arquitectónico MVVM para organizar el código.
6. Utiliza RecyclerView para mostrar la lista de resultados de búsqueda.
7. Asegúrate de manejar errores y estados de carga, como cuando se realiza una búsqueda o se cargan detalles de una película.
8. La aplicación debe ser capaz de manejar cambios de orientación sin perder datos.

## Requisitos mínimos para el funcionamiento del proyecto

### Entorno de desarrollo
El código fue elaborado en el IDE de Android Studio proveniente del [ToolBox](https://www.jetbrains.com/toolbox-app/), recomendando utilizar esta herramienta para instalar Android Studio ya que viene mejor adaptada que la versión descargada de la web.

- Version: Android Studio Giraffe | 2022.3.1 Patch 2
- Runtime version: 17.0.6+0-17.0.6b829.9-10027231

### Lenguaje de programación y bibliotecas

- Kotlin Version 1.7.10
- JDK Version 17
- JVM Version 17
- Java Version 17
- Compile SDK 34
- Version mínima de SDK Android para funcionar 28
- Bibliotecas
  - Retrofit 2.9.8
  - Glide 4.10.0
  - Navigation Fragment 2.7.5
  - Coroutines 1.7.1
  - Lifecycle 2.6.1


### Herramientas

Las herramientas necesarias para poder hacer funcionar este proyecto son las siguientes:

- Registro en el portal de [TMDB](https://www.themoviedb.org/?language=es) para obtener API Key y Authorization Token que permitirán consumir los servicios
- Equipo de cómputo con requisitos mínimos como
  - RAM 16 Gb
  - Almacenamiento 256 GB
  - Procesador
    - Intel 7/9 décima generación o superior
    - Apple M1
  - Tarjeta gráfica dedicada para poder correr simulador en caso de requerirse
- Dispositivo móvil con Android 11 o superior para correr la aplicación.


## Requisitos para obtener el código del proyecto
Dirigirse al botón de verde denominado "Code" y descargar el proyecto o bien, clonar con el siguiente comando.
  - git clone https://github.com/charBot21/techniva.git 

Para clonar el proyecto, requieres tener instalado Git en tu equipo de cómputo y dirigirte a la terminal de Mac o bien, abrir la terminal Bash de Git en Windows.
