#### Bucky.io

**Bucky.io** is a java based programming library built to develop java based applications easier.

The **Bucky.io** library uses interfaces and inheritance to guide your web application towards a clearer project structure.

By using this framework, web application development processes can be streamlined, while not sacraficing customization and extendability.

Bucky.io is scalable, and can easily be amended to fit the needs of your project.

Example implementation: Inserting data into a database

````java
public class myDAO {
    public static void main(String[] args) {
        DAO newDao = new DAO("table_name");
        HashMap insertVals = new HashMap<>();
        insertVals.put("column", "data");
        newDao.insertStr(insertVals);
    }
}
````

By using this implementation, **Bucky.io** handles all the possible errors, and makes database modification easier and faster.
