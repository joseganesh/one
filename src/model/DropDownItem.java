package model;

import java.awt.Component;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

public class DropDownItem {
	
        private int id;
        private String description;
 
        public DropDownItem(int id, String description)
        {
            this.id = id;
            this.description = description;
        }
 
        public int getId()
        {
            return id;
        }
 
        public String getDescription()
        {
            return description;
        }
 
        public String toString()
        {
            return description;
        }
        
        public static DropDownItem finById(JComboBox comBox,int id){
        	DropDownItem obj =null;
        	
        	for(int i=0;i <comBox.getItemCount();i++){
        		DropDownItem tObj= (DropDownItem)comBox.getItemAt(i);
        		if(id== tObj.getId()){
        			obj = tObj;
        		}
        		
        	}
        	
        	return obj;
        	
        }
        
       /* public Component getTableCellRendererComponent(
                final JTable table, Object value,
                boolean isSelected, boolean hasFocus,
                int row, int column) {
        			this.add( new JButton("Edit"));
        			this.add( new JButton("Delete"));
    				return this;
                                     }*/
    
}
