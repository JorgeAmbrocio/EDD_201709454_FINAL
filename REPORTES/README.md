# Ejemplo TreantJS
**Curso Estructuras de datos Seccion B Segundo semestre 2019** 
*Desarrollado por Aux de catedra Fernando Antonio Hernández*

Los archivos importantes son:.

 - Index.html 
 - ejemplo.js 
## Index.html

    <script src="ejemplo.js"></script>
    <script>
    new  Treant( chart_config );
    </script>



 - En este archivo se configura el archivo js para su uso uso. 
 - En este caso es "ejemplo.js" pero pueden cambiarlo por el nombre que se desee.


## Archivo ejemplo.js

    var  chart_config  = {...}
Esta es la variable encargada de armar el árbol por lo tanto es la única que debe de aparecer en el mismo.    
 *  Esta variable tiene dos partes muy importantes como lo son:
	 1. chart
	 2. nodeStructure
### Chart 
- Es la parte que se encargara de configurar todas las características que poseerá nuestro árbol.
- Pueden modificar a su gusto esta parte yo para este ejemplo deje esta configuración.

    chart: {
            container: "#basic-example",# basicamente es el id del arbol
            
            connectors: {
                type: 'bCurve' #tipo de uniones en este caso curveadas
            },
            animateOnInit: true, # tendra animación
            
            node: {
                collapsable: true, #se podra esconder
                HTMLclass: 'nodeExample1' #nombre de los nodos por defecto
            },
            animation: {
                nodeAnimation: "easeOutBounce", #tipo de animación nodo
                nodeSpeed: 700, #velocidad de animación nodo
                connectorsAnimation: "bounce", # tipo animación enlace
                connectorsSpeed: 700 # velocidad animación enlace
            }
        }
En cierta manera cuando ustedes generen este archivo js desde java  este texto ira quemado ya que tiene que estar si o si presente para que el grafo funcione.

### NodeStructure
Esta es la parte que nos interesa ya que es la parte que iremos armando recorriendo el árbol(arreglo en este caso) y quemando uno a uno los elementos.

Para declarar un nodo es muy sencillo.

    text: {
                name: "Fernando",
                title: "201296742",
            },
    children:[...]
En text ira toda la parte que se quiera mostrar en el arbol.
En children es un array que contiene mas nodos del mismo tipo.
Ejemplo.

    children: [
                {
                    text:{
                        name: "Ejemplo",
                        title: "#ejemplo"
                    },
                    collapsed: true,
                    children: [
                        {
                            text:{
                                name: "Ejemplo1",
                                title: "hola"
                            }
                        },
                        {
                            text:{
                                name: "Ejemplo3",
                                title: "mundo"
                            }
                        }
                    ]
                   }
	]

Como se puede ver la estructura de children es la siguiente.
   

    children: [
                     {
                         #nodo
                     },
                     {
                         #otro nodo
                     }
              ]
Entonces se debe de recorrer el array de manera en la que todos los elementos queden escritos en el archivo js este sera generado cada vez que se quiera visualizar un árbol.

Por ultimo para visualizar el árbol solo se debe abrir el index.html en el navegador y si el archivo js fue generado correctamente el árbol debería de poderse visualizar como en este ejemplo.
