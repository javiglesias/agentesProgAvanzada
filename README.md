agentesProgAvanzada
===================

Ejercicios de Agentes
Segun indica el ejercicio 2 de los seminarios de Programacion Avanzada, 
hay que hacer que 2 agentes se comuniquen mediante mensajes desde la terminal.
Para ello, definimos 2 agentes, uno que sea el que envia el mensaje y otro que sea el que recibe el mensaje.
El agente que enviara el mensaje se llamara Server y el que los reciba se llamara Cliente.
El Server, lo hemos definido con un cyclicBehaviour, en cuyo metodo Setup hemos llamado a un metodo de la clase utils, "enviarMensaje"
que se encargara de establecer ontologias, lenguajes, etc...
El Client, lo hemos definido como un cyclicBehaviour, en cuyo metodo Setup, hemos definido un receptor bloqueante, 
que muestra el mensaje por la terminal.
