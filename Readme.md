<h1>overview</h1>

This repository is to track learning and development for Hibernate

<h2>Notes</h2>

1. <strong>How the concept came into picture?</strong> <br>
    We had Objects in OOP languages and relation/table in RDBMS. <br>
    The tables were analogous to classes while rows were analogous to objects. <br>
    The columns were analogous to fields while the column values were analogous to field values. <br>
    This showed that there can be a mapping between objects and relations. <br>
    This brought in the concept of ORM (Object-Relational Mapping). <br>
    Some ORMs are Hibernate, iBatis, Toplink. <br><br>
2. <strong>What is Hibernate?</strong> <br>
    ORM is an idea where-as Hibernate is one such implementation of this idea i.e. it is an ORM implementation. <br><br>
3. <strong>Flow of Data From Variable to Database</strong> <br>
    The data is first stored in variable which is called as the transient storage as it will be lost once program exits, <br>
    Post storage of data in variable, we use JDBC connectivity to connect language to DB. <br>
    We write query and populate the query with required data from object to persist them in the database. <br>
    As an alternate, we can use framework such as Hibernate which takes care of connecting to DB and persisting data. <br>
    Using such ORM tool, we need not worry about writing SQL queries for simple tasks. <br><br>
4. <strong>Table, Entity and Class</strong> <br>
    When we create a class with <code>@Entity</code>, it by default has entity and table name same as class name in lower case. <br>
    If we specify the <code>name</code> attribute in <code>@Entity</code> then it changes the entity name and table name(if not specified). <br>
    If we specify the <code>name</code> attribute in <code>@Table</code> then it changes the table name only. <br>
    <strong>@Transient</strong>: Annotation to tell hibernate that the column value is not to be stored. <br><br>
5. <strong>Embeddable</strong> <br>
    If a field of an Entity is complex or can be separated out into a logical class, we can create a new class for the same. <br>
    This new class needs to have <code>@Embeddable</code> which tells Hibernate that the field is not a separate entity. <br>
    The fields of the Embeddable object will be separated out into multiple columns with the parent table itself. <br><br>
