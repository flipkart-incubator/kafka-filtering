Kafka Filtering
===========
Kafka-filtering solves the problem of filtering out messages from Kafka or any such stream very efficiently. This is very much like a *grep* for Kafka message stream.

Kafka doesn't support filtering ability for consumers. If a consumer needs to listen to a sub-set of messages published on to a Kafka topic, consumer has to read all & filter only what is needed. This is in-efficient as all the messages are to be deserialized & make such a decision. Other option is to create different topics: in such a case a consumer needs to consume from more than one topic & ordering is lost as well (as Kafka supports ordering only within a single topic)!

### Filtering
This solves the problem by having headers (Map&lt;String,String&gt;) which gets encoded at producer side along with the actual data (byte[]). Consumer can express, based on these tags, what it wants to consume & filter-out the unwanted very efficiently. Encoding & Decoding of these {headers, data} are done using [Flatbuffers](https://github.com/google/flatbuffers). Thus its very efficient & it wont be taxing.

### What is the overhead?
Benchmarked for the overhead of this for the following case:
1 KB data serialized data size with a 2-3 key-value entries as header (having map of 2-3 small key-value entries with key, value around 8-15 characters long string). 
Codec.encode() => 4 micro secs overhead
Codec.decode() & compiled Filter application => 2 micro secs overhead
Tests are to be done for a wide range of serialized data sizes & header sizes. 

### How to integrate?
Stream producer needs to pass headers (Map&lt;String,String&gt;) along with the data & at consumer level the stream can be filtered by providing an [MVEL](https://github.com/mvel/mvel) expression (grep filter expression what consumer wants).

Example code:
https://github.com/flipkart-incubator/kafka-filtering/blob/master/exp-filtering-mvel/src/test/java/FilterTest.java


