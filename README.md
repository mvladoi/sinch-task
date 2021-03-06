# Kotlin Spring Boot on GCP API GATEWAY with App Engine Standard service backend 


### Deploy locally 

```sh
git clone https://github.com/mvladoi/sinch-task.git
cd springboot
mvn spring-boot:run 

```

[tutorial]: https://cloud.google.com/community/tutorials/kotlin-springboot-app-engine-java8


### Apis implemented : 

- **a.**\
Action	     HTTPS \
Verb         POST\
URL      sinch-assignment/all-pairs  
> Description  Exercise 1 

- **b.**\
Action	     HTTPS \
Verb         POST\
URL      sinch-assignment/polish-notation
> Description  Exercise 2


## Running Time
1. All pair is the coding exercise : ```Count pairs with given sum```
   O(n) time

2. Polish notation is the coding exercise: ```Evaluation of Prefix Expressions```
    O(n) time
   

## Test it on GCP API GATEWAY 

curl -X POST https://sinch-gateway-dcx6qn7w.nw.gateway.dev/sinch-assignment/polish-notation/?key=AIzaSyBigpr5hghSfwqwCKoeLzcRpImjrq3qUIU  --data-binary  @sinch/springboot/input_files/polish_notation/file1  -H "Content-Type: application/text"

Response: 

```{result: 42.00, 1337.00, -12.50, 100500.00, error, error}```



curl -X POST https://sinch-gateway-dcx6qn7w.nw.gateway.dev/sinch-assignment/all-pairs/?key=AIzaSyBigpr5hghSfwqwCKoeLzcRpImjrq3qUIU  --data-binary  @sinch/springboot/input_files/all_pairs/file1  -H "Content-Type: application/text"

Response:

```{result: 2}```


## To Do
1. Improve the testing with different test cases 
    (add suport for input files that contains empty lines)
3. Improve the api response code in case of failures 
