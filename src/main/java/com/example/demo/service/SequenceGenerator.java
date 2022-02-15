package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.demo.model.DatabaseSequence;


@Service
public class SequenceGenerator {

	@Autowired
	MongoOperations mongoOperations;
	
	
	public int getSequenceNumber(String seqName)
	{
	  //get the sequence number
	  Query query = new Query(Criteria.where("id").is(seqName));
	  //Update it by incrementing 1
	  Update update = new Update().inc("seqNo",1);
	  //Update in the document
	  DatabaseSequence counter = 
			  mongoOperations.findAndModify(query,
					  update,options().returnNew(true).upsert(true),
					  DatabaseSequence.class);
	  
	  return !Objects.isNull(counter) ? counter.getSeqNo():1;
	  
	}
}
