# How to use the Archetype

1. Firstly you need to checkout this repo into your machine, using the command git clone
2. Now is necessary run the maven command to install the archetype into your repository
   
   2.1 Go to the path of the project and execute the command:
   ``` shell script
   $> mvn clean install
   ```
3. After the execution of procedure above, you can choose the path where your want to generate the project via archetype
   
   3.1 In the case I will create into the path:
   ```
   $> cd $HOME/Development/git
   ``` 
   
   3.2 The archetype command generates:
   ```shell script
   $> mvn archetype:generate \
      -DarchetypeGroupId=io.github.lhsribas \
      -DarchetypeArtifactId=quarkus-reactive-crud-archetype \
      -DinteractiveMode=false \
      -DgroupId=com.quarkus.clean_arch.crud \
      -DartifactId=quarkus-reactive-crud
   ```
4. probably now, you have the project in your path with the name *quarkus-reactive-crud*
