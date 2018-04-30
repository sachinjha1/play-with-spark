import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object Top5PricedProducts {
  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("Simple Application")//.setMaster("local[2]") // --master local[2] is set to spark-submit thats why commented here.
    val sc = new SparkContext(conf)
    //create RDD for products part-00000 file
    //val products_rdd = sc.textFile("/Users/s2jha/Documents/IntegratedPlanning/spark-jobs/play-with-spark/src/main/resources/data/retail_db/products/part-00000")
    val products_rdd = sc.textFile("src/main/resources/data/retail_db/products/part-00000")
    val productNotEmptyPrice_rdd = products_rdd.filter(row => row.split(",")(4) != "")

    //spark 2 recommends below to use dataset instead of RDD
    //val products_ds = spark.read.textFile("/Users/s2jha/Documents/IntegratedPlanning/spark-jobs/intro-spark/data/retail_db/products/part-00000")

    //Taking product's price column out and convertint it to set to remove duplicate and then converting it to List because sorting does not work on set
    val distinctPricesList = productNotEmptyPrice_rdd.map(row => row.split(",")(4).toFloat).collect.toSet.toList
    //SortBy desc of price and taking top 5
    val top5PriceList = distinctPricesList.sortBy(p => -p).take(5)

    //Iterate through products to filter our all product with price >= top5 least price (top5PriceList[4])
    val top5Products = productNotEmptyPrice_rdd.filter(prod => (prod.split(",")(4).toFloat >= top5PriceList(4)))

    //test if data is loaded properly or not by printing 1st row from RDD
    top5Products.collect.foreach(println)

  }
}