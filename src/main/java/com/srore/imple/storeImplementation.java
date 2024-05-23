package com.srore.imple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.srore.mainStore.mainStore;
@Component
public class storeImplementation {
	
	static List<mainStore> storeList = new ArrayList<>();
	static {
		mainStore mStore = new mainStore("11", "Laptop");
		mainStore mStore2 = new mainStore("12", "Computer");
		mainStore mStore3 = new mainStore("13", "HandsFree");
		mainStore mStore4 = new mainStore("14", "Phone");
		
		storeList.add(mStore);
		storeList.add(mStore2);
		storeList.add(mStore3);
		storeList.add(mStore4);
	}
	
	public List<mainStore> getAll(){
		return storeList;
	}
	
	public mainStore getSingle(String id) {
		mainStore mStore  = null;
		 mStore =	storeList.stream().filter(i->i.getId().equals(id)).findFirst().get();
		 System.out.println(mStore);
	return mStore;
		
	}

}
