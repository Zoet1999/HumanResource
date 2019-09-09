package entity;

import entity.Ccollection;
import entity.Position;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-08T14:15:47")
@StaticMetamodel(Company.class)
public class Company_ { 

    public static volatile SingularAttribute<Company, String> address;
    public static volatile SingularAttribute<Company, Integer> companyNo;
    public static volatile SingularAttribute<Company, String> companyName;
    public static volatile CollectionAttribute<Company, Ccollection> ccollectionCollection;
    public static volatile CollectionAttribute<Company, Position> positionCollection;
    public static volatile SingularAttribute<Company, String> remark;

}