# Kotlin Spring Boot on App Engine Standard


##Deploy locally 

```sh
git clone https://github.com/mvladoi/sinch-task.git
cd sinch/springboot
mvn spring-boot:run 

```

[tutorial]: https://cloud.google.com/community/tutorials/kotlin-springboot-app-engine-java8


## Two Apis 
1. ```sinch-assignment/all-pairs```
2. ```sinch-assignment/polish-notation```


## Running Time
1. All pair is the coding exercise : ```Count pairs with given sum```
   O(n) time

2. Polish notation is the coding exercise: ```Evaluation of Prefix Expressions```
    O(n) time
   

## To test it on GCP APP Engine 
curl -X POST https://fresh-metrics-266911.uc.r.appspot.com/sinch-assignment/all-pairs --data-binary  @sinch/springboot/input_files/all_pairs/file1  -H "Content-Type: application/javascript"

curl -X POST https://fresh-metrics-266911.uc.r.appspot.com/sinch-assignment/polish-notation  --data-binary  @sinch/springboot/input_files/polish_notation/file1  -H "Content-Type: application/javascript"
