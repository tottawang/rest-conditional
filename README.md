# rest-coniditonal

### Run and build
Step-1 : 
./gradlew clean build

Step-2 :
java -jar build/libs/sample-0.0.1-SNAPSHOT.jar

### Test
Run curl http://localhost:{your_sever_port}/api/condition-one
This endpoint goes through ConditionalFilter to set header based on its ConditionOne annotation
It should return string: ConditionOne

If you call curl curl http://localhost:{your_sever_port}/api/condition-two
It should return string: ConditinTwo

for an endpoint without ConditionOne or ConditionTwo annotation
It should return empty i.e. http://localhost:{your_sever_port}/api/condition-non