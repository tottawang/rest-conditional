# rest-coniditonal

### Run and build
Step-1 : 
./gradlew clean build

Step-2 :
java -jar build/libs/sample-0.0.1-SNAPSHOT.jar

### Test
Run curl http://localhost:{your_sever_port}/api/condition-one or
Run curl http://localhost:{your_sever_port}/api/condition-one-explicit
This endpoint goes through ConditionalFilter to set header based on its ConditionOne annotation
It should return string: [Conditional One Header]: ConditionOne [Conditional Two Header]: null

If you call curl curl http://localhost:{your_sever_port}/api/condition-two
It should return string: [Conditional One Header]: ConditionOne [Conditional Two Header]: ConditionTwo
Note that Conditional One Header is also set because its name bining has already been setup in resource level.
