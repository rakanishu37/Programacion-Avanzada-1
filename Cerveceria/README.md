# Cerveceria
Es un sistema en el cual se resuelva la problematica de Productor-Consumidor utilizando Threads de Java

## Consumidores
De la forma en que esta diseñado el codigo con un solo hilo alcanza para lograr que el stock llegue a 0     

## Bloques Synchronized
Los bloques synchronized se utilizan para evitar que dos o más hilos accedan al mismo tiempo a una seccion sencible del 
codigo o tambien llamada seccion critica como por ejemplo operaciones que modifiquen el estado del recurso compartido 
entre ellos.

## Recurso Compartido
El recurso compartido no es más que una estructura o conjunto de datos el cual se comparte entre hilos que pueden acceder
o modificar y se debe asegurar su integridad para que no se produzcan errores 
    
## Formas de instanciar un Thread de Java  

- Si una clase implementa la interface Runnable luego se debera pasar un objeto de ella en el constructor del Thread como
argumento.
```bash
ClaseQueImplementaRunnable obj = new ClaseQueImplementaRunnable ();

Thread t = new Thread(obj);

t.start();
```

- Si una clase extiende de la clase thread con llamar su constructor alcanza 

```bash
ClaseQueExtiendeThread obj = new ClaseQueExtiendeThread();
obj.start()
```
 
- Por ultimo llamando al constructor sin parametros de Thread se puede instanciar uno
```bash            
Thread t = new Thread();
t.start();       
```        
