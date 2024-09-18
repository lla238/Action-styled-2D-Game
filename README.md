## Build
        
```bash
git clone https://github.sfu.ca/saba/CMPT276F23_group23.git  
``` 
        
Navigate Project Directory: ```CMPT276F23_GROUP23```. And build the Project using Maven: 
        
```bash
mvn clean install 
``` 
        
Notes: When install the app, it must pass all the test cases including a pop-up test case. Please click "Restart the Game" to pass. Otherwise, the jar file cannot be generated as expected. 

## Run
After building the project, you can run the game with the following command:
```bash
java -jar target/CMPT276F23_group23-1.0.jar
```

## Test
Run the Automated tests use Maven: 
```bash
mvn test
```

## Doc File 
Generate the doc by the comments: 
```bash
mvn javadoc:javadoc
```

After running the code, you can open the index page in the browser as: ```target/site/apidocs/index.html```
