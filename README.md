Kafka Filtering
===========
Kafka-filtering solves the problem of filtering out messages from Kafka or any such stream very efficiently. This is very much like a *grep* for Kafka message stream. 

### Problem Statement
Kafka doesn't support filtering ability for consumers. If a consumer needs to listen to a sub-set of messages published on to a Kafka topic, consumer has to read all & filter only what is needed. This is in-efficient as all the messages are to be deserialized & make such a decision. Other option is to create different topics - but that works only if you know who all the consumers. In such a case a consumer needs to consume from more than one topic ordering is lost! 

### Filtering
This solves the problem by having headers (Map<String,String>) which gets encoded at producer side along with the actual data (byte[]) and as a consumer you can express based on these tags what it wants to consume & filter-out the unwanted very efficiently. Encoding & Decoding of these {headers, data} is done using *Flatbuffers*. Thus its very efficient & it wont be taxing. 

At the integration level, all you need to do is to pass headers (Map<String,String>) along with your data & at consumer level you can give an MVEL expression (grep filter expression what consumer wants).

Example code: 
https://github.com/flipkart-incubator/kafka-filtering/blob/master/exp-filtering-mvel/src/test/java/FilterTest.java




