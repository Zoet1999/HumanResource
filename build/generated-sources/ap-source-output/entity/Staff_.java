package entity;

import entity.Ecollection;
import entity.Experience;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-08T14:15:47")
@StaticMetamodel(Staff.class)
public class Staff_ { 

    public static volatile SingularAttribute<Staff, String> address;
    public static volatile SingularAttribute<Staff, Integer> staffNo;
    public static volatile SingularAttribute<Staff, String> mail;
    public static volatile SingularAttribute<Staff, String> sex;
    public static volatile SingularAttribute<Staff, String> name;
    public static volatile SingularAttribute<Staff, String> workingYears;
    public static volatile SingularAttribute<Staff, String> tel;
    public static volatile CollectionAttribute<Staff, Ecollection> ecollectionCollection;
    public static volatile CollectionAttribute<Staff, Experience> experienceCollection;
    public static volatile SingularAttribute<Staff, Integer> age;

}