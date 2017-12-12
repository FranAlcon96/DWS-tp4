package com.huerta.bean;
import com.huerta.model.Elemento;
import java.io.Serializable;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.JOptionPane;


@ManagedBean(name="obj")
@SessionScoped
public class ViewManager implements Serializable{
  private String key;
  private String value;
  private String last;
  private boolean good;
  private Map<String,String> hashk;
  private List<Elemento> listClaves = new ArrayList<Elemento>();
  
 public List<Elemento> getListClaves() {
    
    return listClaves;
}
public void setListClaves(List<Elemento> listClaves) {
	this.listClaves = listClaves;
}
public ViewManager() {
     good=false;
     hashk = new HashMap<String, String>();
  }
  public String getLast() {
    return last;
  }
  public Map<String,String> getHashk() {
    
    return hashk;
  }
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }
  public boolean isGood() {
    return good;
  }
  public String getValue() {
    return value;
  }

  public void setLast(String last) {
    this.last = last;
  }

  public void setValue(String value) {
    this.value = value;
  }
  
  public void add() {
	if (!hashk.containsKey(this.key)) {
		System.out.println("entro aqui");
		hashk.put(this.key, this.value);
		System.out.println(hashk.get(this.key));
	}else {
		JOptionPane p = new JOptionPane("Ya ha introducido esa key, por favor introduzca otra.");
	}
    this.setKey("");
    this.setValue("");

  }
  
  public void mostrar() {
    
	if(!good){
		listClaves = new ArrayList<Elemento>();
   	 	for(Map.Entry<String,String> entry : hashk.entrySet()) {
      		listClaves.add(new Elemento(entry.getKey(),entry.getValue()));
		this.good=true;
    	}

	}else{
		listClaves = new ArrayList<Elemento>();
		this.good=false;
	}
  }
  
  
}
