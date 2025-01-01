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
6. **Mapping Relations**
   - **@OneToOne**: Annotated on field which represents a one-to-one relation in database.  
     If both the Entity have ```@OneToOne``` with a reference to the other Entity, 
     one of the entity must have ```mappedBy``` attribute specified in its annotation, 
     else tables associated to both the entities will have foreign key referencing to the other entity table.
     > Say Student has Address and both have @OneToOne mapping without mappedBy attribute in either of the entity class, 
        Student will have address_id while Address will have student_id as foreign key.
        If we save Address first and then its associated Student, Hibernate will first create entry in Address will null  
        reference to Student and once the associated Student is added to Student table, it will update the existing Address entry
     
     If one of the Entity has mappedBy mentioned as field name in other Entity that reference this Entity,  
     then the table associated with this Entity will not have foreign key column while the other one will maintain the column.
     > Say Student mentions the mappedBy attribute in the annotation, then Address will maintain student_id  
        while Student will not have any foreign key column  
        If Address is persisted first and then its associated Student, then Hibernate will use update query to add value 
        to foreign_key column.
        If Student is persisted first and then its associated Address, then Hibernate will only use insert query and no 
        update query is needed.   
     
   - **@OneToMany**: Annotated on field which is List representing a one-to-many relation in database.  
        Used in combination with its attribute ```mappedBy``` which refers to field in entity that has many-to-one mapping.  
        If we do not mention ```mappedBy``` then the class with this annotation will create a mapping table separately.  
        ```mappedBy``` tells the Entity that the mapping column is handled by the other entity and not by a mapping table.
     > If we have Student and Book with OneToMany mapping, we mention @OneToMany in Student for List&lt;Book&gt; field 
    and @ManyToOne in Book for Student field.
    We can have 2 approaches, we get a mapping table of book_id to student_id or we create a foreign key column in Book.
    Without mappedBy mentioned in either of the Entity, both table as well as foreign key column will be created     
    We can not get only additional mapping table, hence we need to go with additional foreign key column in Book table.
    To eliminate the additional mapping table, we should mention name of the field in Book class that reference Student Entity
    This mapping also follows similar approach for different order of inserting into database for dependant entities.  

   - **@ManyToMany**: Annotated on field which is List representing a many-to-many relation in database.  
     For ```@ManyToMany```, if we do not specify mappedBy in either of the Entity, both will create mapping tables.  
     The first will create ```entity1_entity2```, the second will create ```entity2_entity1```.  
     > If Author and Book entity are related with ManyToMany mapping, we mention @ManyToMany in Author for List&lt;Book&gt; field 
    and @ManyToMany in Book for List&lt;Author&gt; field  
    We can have 2 approaches, we get a mapping table of book_author or author_book
    Without mappedBy mentioned in either of the Entity, both tables will be created
    If we want to remove author_book and only have book_author mapping table, we add mappedBy attribute in Author Entity
    Here the order of insertion into table does not matter as whenever both associated entities are inserted, 
    only then the mapping table is populated.  

