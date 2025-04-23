IMPORTANTE:  
●	Crear un proyecto con su Apellido y Nombre.
●	Agregar la librería de Pilas.
●	Añadir comentarios a su código identificando cada ejercicio.
●	Si una función está completamente comentada no se corregirá.


Deseamos realizar un seguimiento por tramos que realizan un grupo de personas que están haciendo trekking. Para eso, vamos a ir registrando la cantidad de km que recorren, las pausas, y otros datos de relevancia.

1.	Realizar una función que solicite la carga de los km recorridos por cada tramo en las distintas jornadas de excursión dentro de una pila. 
•	Cada tramo son los km de recorrido hecho sin parar. 
•	Si se detienen a comer o cualquier otra actividad, cuenta como un tramo diferente una vez que comienzan a caminar. 
•	Para diferenciar por días, al finalizar cada día se guarda un -1.
•	La Pila deberia quedar asi, por ejemplo:
             
                1er DIA                                2do DIA                           3er DIA

   1°tramo    2°    3° 

5	4	10	8	2	-1	8	5	7	-1	1	15	5	11	3	-1		


2.	Deseamos buscar cuantos km tuvo el mayor tramo sin frenar que se hizo. En el caso del ejemplo anterior sería “15”. 

3.	Ahora, debemos mostrarle al usuario la información guardada, por lo que vamos a mostrar el contenido de la pila, pero en lugar de usar la función mostrar, vamos a generar una función propia, que muestre todos los datos.


4.	Deseamos ahora calcular la cantidad de km recorridos por día. 
•	Para esto, vamos a almacenar en un arreglo, los km recorridos por día en cada posición.
•	 La pila debe quedar sin modificar.
•	Del ejemplo anterior, quedaría algo así:

29	20	38				


5.	Ahora queremos guardar la cantidad de tramos que se hizo en cada día, y almacenarlas en otro arreglo, guardando en cada posición del arreglo la cantidad de tramos del dia.
Basándonos en la pila del primer punto, quedaría así:

5	3	5				


6.	Realizar una función que muestre los datos de cada día, para lo cual deberán mostrarse el arreglo con la cantidad de tramos recorridos ese día, y el arreglo con la cantidad de km recorridos ese día. 
En el ejemplo anterior, seria: 
Día 1:
Cant km: 29
Cantidad de tramos: 5


7.	Realizar una función main que demuestre el correcto funcionamiento y guíe a quien use el programa con instrucciones claras.
