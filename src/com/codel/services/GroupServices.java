package com.codel.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.codel.daos.ContactGroupDAO;
import com.codel.entities.ContactGroup;


public class GroupServices {

	@SuppressWarnings("finally")
	public JSONObject findAll(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContactGroupDAO groupDao = (ContactGroupDAO)context.getBean("myContactGroupDAO");
		List<ContactGroup> group_list = new ArrayList<ContactGroup>();
		JSONObject json_element = new JSONObject();
		JSONArray array = new JSONArray();
		try {
			group_list = groupDao.findAll();
			if(group_list.size()==0) {
				json_element.put("result", 404);
			}else {
				for (ContactGroup gl : group_list) {
					JSONObject groupListJSON = new JSONObject();
					groupListJSON.put("name",gl.getGroupName());

					array.put(groupListJSON);
				}
				json_element = new JSONObject().put("result", array);
				json_element.put("response", 200);
			}


		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			return json_element;	
		}
	}
	
	public void viderGroup(){
		
	}
}
