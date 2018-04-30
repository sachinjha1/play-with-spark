# intro-spark
Spark for beginners (Some of the instruction below will be OSX specific)

Spark is general purpose cluster computing system.

Install apache-spark using homebrew. 
```brew install apache-spark```

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
