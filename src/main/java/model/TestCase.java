package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
    Long id;

    String name;
    String rallyNumber;
    String priority;
    
    @ManyToOne
    @JoinColumn(name = "TEST_CLASS_ID")
    TestClass testClass;

    public TestCase() {
        super();
    }

    public TestCase(String name, String rallyNumber, String priority) {
        super();
        this.name = name;
        this.rallyNumber = rallyNumber;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRallyNumber() {
        return rallyNumber;
    }

    public void setRallyNumber(String rallyNumber) {
        this.rallyNumber = rallyNumber;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

   
    public TestClass getTestClass() {
        return testClass;
    }

    public void setTestClass(TestClass testClass) {
        this.testClass = testClass;
    }
   
    
}
