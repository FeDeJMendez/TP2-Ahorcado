# TP2-Ahorcado

# Diferencia entre Runnable y Thread
- Thread es una clase que contiene los métodos utilizados. Para utilizarla se recomienda crear una clase que herede de la misma. Luego solo bastaría con crear un objeto de la clase heredada. Se utiliza en el caso que la clase heredada no herede de otra tercera clase.
- Runnable es una interface. Para utilizarla se recomienda crear una clase que implemente ésta interfaz. Luego de crear el objeto, se debería crear un objeto de la clase Thread pasando como parámetro en su constructor el objeto anterior. Se utiliza en el caso que la clase heredada herede de otra tercera clase.

En ambos casos se debe definir el método run() luego invocar su método start().

#  Ciclo de vida de un Thread
El ciclo de vida de un thread representa los estados por los cuales pasa el mismo desde que nace hasta que muere. Durante este ciclo puede encontrarse en diferentes estados luego de pasar por diferentes métodos relacionados de la siguiente manera:

![alt text](https://github.com/FeDeJMendez/TP2-Ahorcado/blob/master/CicloVidaThreadBasico.jpg)

# Métodos [start, sleep, yield, join]
- start(): comienza con la ejecución del thread.
- sleep(): deja “dormido” el thread, es decir, fuera de ejecución por un tiempo pasado por parámetro expresado en milisegundos.
- yield (): provoca una pausa temporal en el thread  y da paso a que se ejecuten otros threads. Ayuda a evitar la inanición de un determinado thread.
- join(): espera antes de darle muerte al thread cierto tiempo pasado por parámetro en milisegundos + nanosegundos respectivamente. Se utiliza para esperar el fin de la ejecución de un thread, y primero realizar acciones que dependan de ello.
		




