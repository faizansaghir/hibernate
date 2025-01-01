# Overview  
This repository is to track learning and development for Hibernate

## Notes  
1. **How the concept came into picture?**  
    We had Objects in OOP languages and relation/table in RDBMS.  
    The tables were analogous to classes while rows were analogous to objects.  
    The columns were analogous to fields while the column values were analogous to field values.  
    This showed that there can be a mapping between objects and relations.  
    This brought in the concept of ORM (Object-Relational Mapping).  
    Some ORMs are Hibernate, iBatis, Toplink.  
    &emsp;
2. **What is Hibernate?**  
    ORM is an idea where-as Hibernate is one such implementation of this idea i.e. it is an ORM implementation.  
    &emsp;
3. **Flow of Data From Variable to Database**  
    The data is first stored in variable which is called as the transient storage as it will be lost once program exits,  
    Post storage of data in variable, we use JDBC connectivity to connect language to DB.  
    We write query and populate the query with required data from object to persist them in the database.  
    As an alternate, we can use framework such as Hibernate which takes care of connecting to DB and persisting data.  
    Using such ORM tool, we need not worry about writing SQL queries for simple tasks.  
    &emsp;  
4. **Table, Entity and Class**  
    When we create a class with ```@Entity```, it by default has entity and table name same as class name in lower case.  
    If we specify the ```name``` attribute in ```@Entity``` then it changes the entity name and table name(if not specified).  
    If we specify the ```name``` attribute in ```@Table``` then it changes the table name only.  
    <strong>@Transient</strong>: Annotation to tell hibernate that the column value is not to be stored.  
    &emsp;  
5. **Embeddable**  
    If a field of an Entity is complex or can be separated out into a logical class, we can create a new class for the same.  
    This new class needs to have ```Embeddable``` which tells Hibernate that the field is not a separate entity.  
    The fields of the Embeddable object will be separated out into multiple columns with the parent table itself.  
    &emsp;  
