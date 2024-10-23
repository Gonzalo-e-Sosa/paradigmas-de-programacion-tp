# Objetivo
Implementar los conceptos abordados del paradigma de la Programación orientada a objetos, como solución a un problema real, partiendo del análisis de la problemática, el diseño de la solución (Diagrama de Clases) y posteriormente la construcción del producto final (Software).

## Consigna
### Temática
Batalla de Magos contra Mortífagos

### Objetivos del trabajo
Modelar un sistema de combate entre magos y mortífagos.
Implementar hechizos y habilidades especiales usando patrones de diseño (Strategy, Factory, Observer).
Gestionar batallones de magos y mortífagos, utilizando colecciones avanzadas (List, Set, Map) y/o patrones de diseño (Composite).
Usar herencia y polimorfismo para permitir la diversidad de magos (aurors, estudiantes, profesores) y mortífagos (seguidores comunes, comandantes, etc.).
Conectar con Prolog para resolver problemas específicos en la batalla (como decidir estrategias lógicas o predecir el siguiente ataque de un enemigo).

### Descripción General
El trabajo simulará una serie de batallas entre dos facciones: los magos y los mortífagos. Cada facción tendrá diferentes tipos de personajes, con sus propios hechizos, habilidades y características. Se espera que el sistema esté diseñado de manera flexible para que se puedan agregar nuevos tipos de personajes y hechizos fácilmente.

1. Clases Base
Personaje (abstracta): Tendrá atributos como nombre, nivel de magia, puntos de vida, y una lista de hechizos que puede lanzar.
Mago (hereda de Personaje): Se especializa en hechizos defensivos y de ataque. Subclases: Auror, Estudiante, Profesor.
Mortífago (hereda de Personaje): Se enfoca en ataques oscuros y habilidades especiales. Subclases: Seguidor, Comandante.

2. Hechizos y Habilidades (Strategy Pattern)
Implementar diferentes tipos de hechizos usando el patrón Strategy. Los hechizos pueden tener distintos comportamientos dependiendo del contexto
Hechizo (interface): Tendrá un método ejecutar, que aplicará un efecto a un personaje (daño, curación, efecto de estado).
Tipos de Hechizo: "Expelliarmus", "Avada Kedavra", "Protego", etc.
Cada hechizo implementará la interfaz de forma diferente. Por ejemplo, "Expelliarmus" desarmará a un enemigo, mientras que "Protego" protegerá al mago.

3. Patrón Factory para creación de personajes y hechizos
Usar el patrón Factory para crear personajes y hechizos según la situación de la batalla.

PersonajeFactory: Podría crear magos o mortífagos con diferentes habilidades iniciales.
HechizoFactory: Podría crear hechizos basados en un nivel de dificultad o tipo de magia.

4. Gestión de Batallones
Usar colecciones para manejar equipos de personajes.
List para la secuencia de ataques.
Map para registrar los hechizos lanzados por cada personaje.
Set para evitar que un personaje repita un hechizo en la misma ronda.

5. Integración con Prolog
Integrar Prolog para resolver alguna (una de ellas) lógica compleja. Ejemplos posibles, pero no son los únicos:
Estrategia de combate: Prolog podría analizar las fuerzas de ambos bandos y sugerir la mejor táctica para un mago en particular, basado en el estado de los personajes y sus habilidades.
Verificar si se puede lanzar un hechizo: Dependiendo quién lo lanza, su salud y magia, y a quién se lo lanza.
Definir, dentro de un batallón, quién conviene que ataque, o quién conviene que reciba el ataque.
Algunas referencias:
[Prolog en Java](https://jpl7.org/TutorialJavaCallsProlog)
[Integración con prolog](https://github.com/SWI-Prolog/packages-jpl/blob/a6a3617d17cde587ee0946c108d92cae8b1627d0/src/test/java/org/jpl7/standalone/Family.java)
