
# Documentación de la API ReservarController

## Descripción
Esta API permite a los usuarios crear una reserva de un libro a través de una solicitud HTTP POST. El endpoint está diseñado para manejar solicitudes de reserva entrantes, procesarlas utilizando el `ReservarServiceImpl` y devolver una respuesta que indique el éxito de la operación.

## Endpoints

### Crear Reserva
#### URL
`POST localhost:8080/bideafactory/book`

#### Cuerpo de la Solicitud
El cuerpo de la solicitud debe ser un objeto JSON que contenga los datos necesarios para crear una reserva. Los campos deben ser validados de acuerdo con la clase `ReservarRequest`.



##### Ejemplo de Cuerpo de Solicitud
```json
{
    "id": "14564088-8",
    "name": "Gonzalo",
    "lastname": "Pérez",
    "age": 33,
    "phoneNumber": "56988123222",
    "startDate": "2022-03-04",
    "endDate": "2022-03-04",
    "houseId": "213132",
    "discountCode": "D0542A13"
}
```

##### PROBAR ENDPOINT

#### Usando Postman
1. Abre Postman y selecciona el tipo de solicitud POST.
2. Ingresa la URL http://localhost:8080/bideafactory/book.
3. Ve a la pestaña "Body", selecciona raw y asegúrate de que esté seleccionado JSON.
4. Copia y pega el ejemplo del cuerpo de solicitud en el área de texto.
5. Haz clic en "Send" para enviar la solicitud.

![img.png](img.png)