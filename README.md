# MongoDB-Java-Tests
Just playing around with MongoDB and Java: http://mongodb.github.io/mongo-java-driver/

To start Mongo (I don't why it is not started automatically) and the Web client for Mongo:

```
service mongod start
mongodb-compass-community
```

Export CSV:

```
mongoexport --db JavaTests --collection BigCollection --type=csv --fields name,type,count,info.x,info.y --out ./JavaTestsBigCollection.csv
```
