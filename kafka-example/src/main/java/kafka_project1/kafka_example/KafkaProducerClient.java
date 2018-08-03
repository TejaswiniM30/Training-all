package kafka_project1.kafka_example;


import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;


/**
 * https://kafka.apache.org/documentation/
 * @author tejaswini.m
 *
 */

public class KafkaProducerClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//set all the properties
		//the details can be kept in flat file or properties class
		
		Properties properties = new Properties();
		properties.setProperty("bootstrap.servers", "localhost:9092");
		properties.setProperty("key.serializer", StringSerializer.class.getName());
		properties.setProperty("value.serializer", StringSerializer.class.getName());
		
		//for ack, retries etc etc
		//when producer sends we can ask for ack
		properties.setProperty("acks", "1");
		properties.setProperty("retries", "3");
		
		Producer<String, String> producer = new KafkaProducer<String,String>(properties);
		for(int i=0;i<30;i++) {
		ProducerRecord<String, String> producerRecord = new  ProducerRecord<String,String>("topicA","1"+i,"Testing message from java: "+i);
		System.out.println("Message sent: "+i);
		producer.send(producerRecord);
		
		//ProducerRecord<String, String> producerRecord2 = new ProducerRecord<String, String>("topicA", "2","Second testing message from java");
		}
	//	producer.send(producerRecord);
	//	producer.send(producerRecord2);
		
		producer.flush();
		producer.close();
		
		//close the connection
		
		
		
		
	}

}
