# nhl-stats

## Nhl stats client generation
online client generator for OpenApi specifications https://editor.swagger.io  
OpenApi file [LINK](https://github.com/erunion/sport-api-specifications/blob/master/nhl/nhl.yaml)  
NHL API documentation [LINK](https://gitlab.com/dword4/nhlapi/tree/master/)  
List of paths [LINK](https://github.com/erunion/sport-api-specifications/tree/master/nhl)  
Gradle plugin to generate client [LINK](https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-gradle-plugin)

### How to generate a swagger client 
Generate client sources: `./gradlew openApiGenerate`  
Build client: `cd build/generated; gradle build`  
Copy generated client to `libs`  

# plantuml integration experiment
![your-UML-diagram-name](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/amartyushov/nhl-stats/master/docs/experiment.iuml)
