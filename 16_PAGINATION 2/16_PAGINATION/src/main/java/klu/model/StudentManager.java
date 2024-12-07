package klu.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import klu.repository.StudentRepository;

@Service
public class StudentManager {
	@Autowired
	StudentRepository SR;
	
	//Retrieve data
	public String getData(int cPage, int pSize)
	{
		List<String> slist = new ArrayList<String>();
		for(Student S : SR.findAll(PageRequest.of(cPage, pSize)))
		{
			slist.add(toJson(S));
		}
		return slist.toString();
	}
	
	//Convert JAVA object to JSON
	public String toJson(Object obj)
	{
		Gson G = new GsonBuilder().create();
		return G.toJson(obj);
	}
	
	//Generate Page Numbers
	public String getPages(int pSize)
	{
		int totalRecords = SR.totalRecords();
		int pageCount = totalRecords / pSize;
		if(totalRecords % pSize == 0)
			pageCount += 0;
		else
			pageCount += 1;
		
		List<String> pages = new ArrayList<String>();
		for(Integer i=1; i<=pageCount; i++)
		{
			pages.add(i.toString());
		}
		return pages.toString();
	}
	
}
