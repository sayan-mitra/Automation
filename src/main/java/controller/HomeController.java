package controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    
    @RequestMapping(value="/rest/folders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ReturnClass> showClick(){
        System.out.println("in controller button");
        ReturnClass r1 = new ReturnClass("ABC");
        DataForReturnClass d1 = new DataForReturnClass(1);
        r1.data = d1;
        
        ReturnClass r2 = new ReturnClass("XYZ");
        DataForReturnClass d2 = new DataForReturnClass(2);
        r2.data = d2;
        
        ReturnClass r3 = new ReturnClass("EFG");
        DataForReturnClass d3 = new DataForReturnClass(3);
        r3.data = d3;
        
        ReturnClass r4 = new ReturnClass("LMN");
        DataForReturnClass d4 = new DataForReturnClass(4);
        r4.data = d4;
        
        ReturnClass[] childrenOfR1 = {r3};
        ReturnClass[] childrenOfR2 = {r4};
        
        r1.children = childrenOfR1;
        r2.children = childrenOfR2;
        
        ReturnClass[] rc = {r1,r2};
        return Arrays.asList(rc);
    }
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        System.out.println("in controller");
        return "index";
    }
    
    @RequestMapping(value="/rest/grid/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List showGrid(@PathVariable int id) {
        GridData gd1 = new GridData("Sam", "Mit", "Lex", "male");
        GridData gd2 = new GridData("Sud", "Chan", "Lex", "male");
        GridData gd3 = new GridData("Nil", "Ro", "Lex", "female");
        GridData gd4 = new GridData("Deb", "Ro", "Lex", "male");
        
        GridData[] returnGrid = {gd1,gd2,gd3,gd4};
       
        return Arrays.asList(returnGrid);
    }
}

class ReturnClass {
    String label;
    DataForReturnClass data;
    ReturnClass[] children;
    
    
    public ReturnClass(String label) {
        super();
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ReturnClass[] getChildren() {
        return children;
    }

    public void setChildren(ReturnClass[] children) {
        this.children = children;
    }

    public DataForReturnClass getData() {
        return data;
    }

    public void setData(DataForReturnClass data) {
        this.data = data;
    }
    
    
}

class DataForReturnClass {
    int id;

    public DataForReturnClass(int id) {
        super();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}

class GridData {
    String firstName;
    String lastName;
    String company;
    String gender;
    public GridData(String firstName, String lastName, String company, String gender) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.gender = gender;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    
}
