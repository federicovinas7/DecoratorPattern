# DecoratorPattern


Tenemos un sistema "funcional" de base de datos construido con la clase BaseDatosMemoria.

Nuestra mision es implementar un "adapter" a la funcionalidad de base de datos (expresada en 
la interface BaseDatos) que haga uso de un logger e informe a este logger de las operaciones
realizadas.

En particular, debemos modificar el LoggerDecorator para que usando un determinado logger y una 
implementacion de BaseDatos (ambos obtenidos en un constructor que debemos implementar) haga
lo siguiente:

- cuando recibe una invocacion a inserta(registro):
   1 - guarde en el logger un mensaje "inserta "  registro
   2 - propage la llamada a la implementacion de base de datos obtenida en el constructor
  
- cuando recibe una invocaciona a registros():
   1 - guarde en el logger un mensaje "lectura"
   2 - devuelva el resultado de la base de datos obtenida en el constructor a la misma llamada
  
Cuando tengas implementada la clase LoggerDecorator deberas ir al test 
test/org/formacion/decorator/TestBaseDatosConLogger.java

y modificar el metodo init para que se asigne a la variable bbdd un LoggerDecorator con los objetos
logger y sinLogger que ya estan creados.

Fijense en el objetivo de la aplicacion de este pattern: poder "enriquecer" el comportamiento
de nuestra clase existente (BaseDatosMemoria) sin modificar ni una linea de su codigo!
