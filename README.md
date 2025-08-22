# Evaluacion backend

## Base URL:   
    http://localhost:8080
### Url documentacion: 
    http://localhost:8080/swagger-ui/index.html
## Peticiones de prueba para postman
### Pacientes:

#### Obtener todos los pacientes
    GET http://localhost:8080/pacientes
#### Obtener el paciente con el ID 1
    GET http://localhost:8080/pacientes/1
#### Crear paciente nuevo
    POST http://localhost:8080/pacientes
```bash
{
"nombre": "Lucía",
"apellido": "Fernandez",
"dni": "40111222",
"email": "lucia.fernandez@example.com"
}
```
#### Eliminar el paciente con id 3 (Lucia)
    DELETE http://localhost:8080/pacientes/3
### Profesionales:
#### Obtener profesionales por especialidad
    GET http://localhost:8080/profesionales?especialidad=odontologia
#### Crear un nuevo profesional
    POST http://localhost:8080/profesionales
````bash
{
"nombre": "Romina",
"apellido": "Quiroga",
"especialidad": "Pediatra"
}
````

### Turnos:
   #### Obtener todos los turnos
    GET http://localhost:8080/turnos
#### Obtener todos los turnos entre dos fechas
    GET http://localhost:8080/turnos?desde=2025-08-23&hasta=2025-08-25
#### Obtener todos los turnos en una fecha especifica
    GET http://localhost:8080/turnos/fecha/2025-08-23
#### Crear un turno
    POST http://localhost:8080/turnos
````bash

{
"paciente": { "id": 1 },
"profesional": { "id": 1 },
"fecha": "2025-08-24"
}
````
#### Eliminar un turno
    DELETE http://localhost:8080/turnos/2

### Errores:
#### Crear un turno con un profesional paciente
    POST http://localhost:8080/turnos
````bash
{
"paciente": { "id": 9999 },
"profesional": { "id": 1 },
"fecha": "2025-08-30"
}
````
#### Crear un turno con un profesional inexistente
    POST http://localhost:8080/turnos
````bash
{
"paciente": { "id": 1 },
"profesional": { "id": 9999 },
"fecha": "2025-08-30"
}
````
#### Crear un turno con una fecha pasada
    POST http://localhost:8080/turnos
````bash
{
"paciente": { "id": 1 },
"profesional": { "id": 1 },
"fecha": "2024-01-01"
}
````
#### Crear  un turno de forma duplicada
    POST http://localhost:8080/turnos
````bash
{
"paciente": { "id": 1 },
"profesional": { "id": 1 },
"fecha": "2025-08-24"
}
````
Repetir dos veces para tener el fallo de turno duplicado (considerar el dia de prueba del codigo, para que la fecha sea coherente)

#### Paginas que dan 404:
    http://localhost:8080/paginaquenoexiste

## Aspectos de mejora
 * Git y Git flow
 * Logj4
 * Lo que ustedes me recomienden :))

Con el git y gitflow estuve bastante incomodo, me costo mergear y hacer los pull, deje el force por ejemplo en el repo para 
dejar un registro justamente de esto. Mucho bardo entre ramas, commits, medio q le fui agarrando la mano
pero pusheando al main, no a una rama superior cuando empece a hacer esto se me complico con todos los rebase

Logj4 en los plazos de entrega de la evaluacion no lo hice, tengo pensado verlo y sumarlo
si lo llegan a ver cuando lo corrigen, no lo consideren. 