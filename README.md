#Dataflow test
This project tests a call to Dataflow getMetrics endpoint using gax-java 0.104.1 to confirm the BadRequest from 
the previous version is not produced

#Usage
This sample project requires default gcloud credentials to be set. This can be 
done with the command `gcloud auth application-default login`
```shell
mvn compile exec:java -Dexec.mainClass="com.dataflowtest.Main" -U -Dexec.args="PROJECT_ID REGION JOB_ID TIMESTAMP_SECONDS"
```