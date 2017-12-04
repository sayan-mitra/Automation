package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class TestClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
    Long id;

    String name;
    
    @Column(name = "ORACLE_DATASET")
    String datasetNameOra;
    
    @Column(name = "PG_DATASET")
    String datasetNamePg;
    
    @OneToMany(mappedBy = "testClass" , cascade = CascadeType.ALL)
    Set<TestCase> testCases = new HashSet<TestCase>();


    public TestClass() {
        super();
    }


    public TestClass(String name, String datasetNameOra, String datasetNamePg) {
        super();
        this.name = name;
        this.datasetNameOra = datasetNameOra;
        this.datasetNamePg = datasetNamePg;
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


    public String getDatasetNameOra() {
        return datasetNameOra;
    }


    public void setDatasetNameOra(String datasetNameOra) {
        this.datasetNameOra = datasetNameOra;
    }


    public String getDatasetNamePg() {
        return datasetNamePg;
    }


    public void setDatasetNamePg(String datasetNamePg) {
        this.datasetNamePg = datasetNamePg;
    }

    public Set<TestCase> getTestCases() {
        return testCases;
    }


    public void setTestCases(Set<TestCase> testCases) {
        this.testCases = testCases;
    }
    
}
