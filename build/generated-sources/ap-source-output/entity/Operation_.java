package entity;

import entity.Account;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-08T14:15:47")
@StaticMetamodel(Operation.class)
public class Operation_ { 

    public static volatile SingularAttribute<Operation, String> optType;
    public static volatile SingularAttribute<Operation, Integer> optNo;
    public static volatile SingularAttribute<Operation, String> optContent;
    public static volatile SingularAttribute<Operation, Account> accountaccountNo;
    public static volatile SingularAttribute<Operation, Date> optTime;

}