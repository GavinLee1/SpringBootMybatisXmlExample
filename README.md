## SpringBootMybatisXmlExample
It is a Spring Boot based project. As usual, the first thing is to set up the environment:  
- Basic: Java 8 <JRE + JDK>  
- org.springframework.boot:1.4.3.RELEASE  
- Maven  
- Recommend you to use Intellij as the IDE  
  
You can just impore the project into your IDE(eithore eclipse or Intellij) by existing MAVEN project.  
  
As to how to run it? You just simply use `mvn clean install`, just as normal Spring Boot project. But before turnning it on, you should at first check the database schema. Because of some security issue, I did not attach the whole jdbc configurations. Later I will parse some  SQL query to help you set up your own DB.  
  
##What this project for?  
This project is a demo project for myself to learn:  
> How to integrate Mybatis with Spring Boot?  
> How to use Mybatis XML mappers?  
> How to connect the MySQL database?  
> How to differentiate the infrastructure and the bussiness logic/codes?  
> How to integrate Swagger API?  
> How to use Spring Boot annotations?  
> And of course, the Spring Boot Controllers / Services.  
  
##Good Method can be used futurely  
1. Use a `ApplicationSettings` to load system config file and use a singlton instance of `ApplicationSettingsFactory` to use it.  
2. Use some basic classes, like domain, repository, exception and message. Later you can design your own class which extends these basic classes. To reduce redundance and help maintanance.  
3. Use a function model interface `MybatisAction` for easier use Mybatis.  
```  
	public interface MybatisAction<T> {
	/**
     * Execute the action.
     *
     * @param sqlSession
     *         mybatis sqlSession
     * @return object
     * @throws DatabaseException
     *          Thrown if an exception occurs when trying to execute the action.
     */
    T Apply(SqlSession sqlSession) throws DatabaseException;
}   
```  
4.  