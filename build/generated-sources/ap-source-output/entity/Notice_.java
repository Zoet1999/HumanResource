package entity;

import entity.Account;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-08T14:15:47")
@StaticMetamodel(Notice.class)
public class Notice_ { 

    public static volatile SingularAttribute<Notice, Integer> noticeNo;
    public static volatile SingularAttribute<Notice, Date> changeDate;
    public static volatile SingularAttribute<Notice, Account> accountaccountNo;
    public static volatile SingularAttribute<Notice, String> title;
    public static volatile SingularAttribute<Notice, String> content;
    public static volatile SingularAttribute<Notice, Date> createDate;

}