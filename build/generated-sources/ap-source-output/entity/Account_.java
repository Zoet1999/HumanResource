package entity;

import entity.Ccollection;
import entity.Ecollection;
import entity.Notice;
import entity.Operation;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-08T14:15:47")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile CollectionAttribute<Account, Notice> noticeCollection;
    public static volatile CollectionAttribute<Account, Operation> operationCollection;
    public static volatile SingularAttribute<Account, Integer> accountNo;
    public static volatile SingularAttribute<Account, String> authority;
    public static volatile CollectionAttribute<Account, Ccollection> ccollectionCollection;
    public static volatile SingularAttribute<Account, String> name;
    public static volatile CollectionAttribute<Account, Ecollection> ecollectionCollection;
    public static volatile SingularAttribute<Account, String> pwd;
    public static volatile SingularAttribute<Account, String> telNo;

}