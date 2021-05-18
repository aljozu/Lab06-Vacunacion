# Lab06-Vacunacion

Principales características:  
  1. Para consultar todas las personas registradas se debe seguir la siguiente ruta: /api/persona/  
  2. Para consultar la fecha de vacunación de una persona que ya se encuentra registrada se debe seguir la siguiente ruta: /api/persona/{DNI}  
  3. Para hacer un POST se debe seguir este formato en la ruta /api/persona/:  
  ```
    {
    "id": "número",
    "nombres": "nombres",
    "apellidos": "apellido paterno + apellido materno",
    "fdn": "yyyy-mm-dd",
    "tlf": "---------",
    "email": "email",
    "fdv": "yyyy-mm-dd"
    }
  ```
  Notas: Implementado de manera local por lo que se requiere cambiar aplication.properties:
  ```java
  spring.datasource.url=jdbc:postgresql://localhost:5432/{nombre_baseDatos}
  spring.datasource.username={username}
  spring.datasource.password={password}
  ```
