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
