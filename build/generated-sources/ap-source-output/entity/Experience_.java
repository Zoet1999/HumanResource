package entity;

import entity.Position;
import entity.Staff;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-08T14:15:47")
@StaticMetamodel(Experience.class)
public class Experience_ { 

    public static volatile SingularAttribute<Experience, Staff> staffstaffNo;
    public static volatile SingularAttribute<Experience, Integer> expNo;
    public static volatile SingularAttribute<Experience, Date> iniDate;
    public static volatile SingularAttribute<Experience, Position> positionpositionNo;
    public static volatile SingularAttribute<Experience, Date> depDate;

}