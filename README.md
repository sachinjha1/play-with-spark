# play-with-spark
Spark for beginners (Some of the instruction below will be OSX specific)
Spark is general purpose cluster computing system.

Refer for sbt-spark-scala setup -> https://www.youtube.com/watch?v=qrPjAyIapFY&t=755s
## Spark - Setting up Spark Dev Environment using SBT and Eclipse

### Step 1 (Prereq): Install/Setup software (Use homebrew wherever possible)
Install Scala
Install SBT
Install Eclipse
Install Spark

### Step 2:
Create a folder structure and add a build.sbt file
mkdir -p src/{main,test}/{java,resources,scala}
mkdir lib project target

Create plugin.sbt in project folder (for sbt eclipse and abt assembly)

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.6")
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.4")

### Step 3:
Run sbt, sbt eclipse

### Step 4:
Import project into workspace
Add code for spark

### Step 5:
spark-submit \
 --class "Top5PricedProducts" \
 --master local[2] \
 /Users/s2jha/Documents/IntegratedPlanning/spark-jobs/play-with-spark/target/scala-2.11/play-with-spark_2.11-1.0.jar
  






Once spark is installed go to terminal and run ```spark-shell --master local[2]```
This starts spark in interactive mode with 2 threads (cores) for spark execution. Feel free to specifiy more cores assuming you have high end system. I got 8 cores on my MacBook Pro (2016 model).

The spark driver program uses spark context to connect to the cluster through a resource manager (YARN orMesos..).
sparkConf creates spark context object.
sparkConf keeps appName (to identify your spark driver), application, no# cores, memory size of executor running on worker node.

```
val conf = new SparkConf().setAppName(“RetailDataAnalysis”).setMaster(“spark://master:7077”).set(“spark.executor.memory”, “2g”)

creation of sparkContext:
val sc = new SparkContext(conf)
```




