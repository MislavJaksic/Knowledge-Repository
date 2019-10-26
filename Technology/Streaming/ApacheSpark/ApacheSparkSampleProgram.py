#You can run a Spark Python script with "spark-2.1.0-bin-hadoop2.7\bin\spark-submit ApacheSpark.py"
from pyspark import SparkConf, SparkContext

CLUSTER_URL = "local"
APP_NAME = "MyApp"

#Initialise Spark
conf = SparkConf().setMaster(CLUSTER_URL).setAppName(APP_NAME)
sc = SparkContext(conf = conf)

#Create a RDD
lines = sc.parallelize(["first line", "second line"])
#OR
fileLines = sc.textFile("TestNumbers.txt")

#.persist() command will load the RDD and keep it in memory

#Transformations (return RDDs):
#.map() #.flatMap() #.filter()
#.distinct() #.union() #.intersection() #subtract() #.cartesian() #-> set operations
numbers = fileLines.map(lambda x: int(x))
evenNumbers = numbers.filter(lambda x: (x%2 == 0))
words = lines.flatMap(lambda line: line.split(" "))

#Actions (don't return RDDs)
#.reduce() #.fold() #.aggregate() #.count() #.first()
words.first() #-> first

for line in evenNumbers.take(5):
  print line
#Sum all the elements
print (evenNumbers.reduce(lambda x,y: x + y)) #-> 90

#Column 1: startingValue=0, doInNode=x+1, combineNodesData=x+y
#Column 2: startingValue=0, doInNode=x+y, combineNodesData=x+y
sumAndCount = evenNumbers.aggregate((0,0),
                                    lambda x,y: (x[0] + 1, x[1] + y),
									lambda x,y: (x[0] + y[0], x[1] + y[1]))
print sumAndCount[0] #-> 9
print sumAndCount[1] #-> 90

sc.stop()