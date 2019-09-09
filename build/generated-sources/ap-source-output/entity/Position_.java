package entity;

import entity.Company;
import entity.Experience;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-08T14:15:47")
@StaticMetamodel(Position.class)
public class Position_ { 

    public static volatile SingularAttribute<Position, Company> companycompanyNo;
    public static volatile SingularAttribute<Position, String> level;
    public static volatile SingularAttribute<Position, Integer> positionNo;
    public static volatile SingularAttribute<Position, String> position;
    public static volatile SingularAttribute<Position, String> department;
    public static volatile CollectionAttribute<Position, Experience> experienceCollection;

}