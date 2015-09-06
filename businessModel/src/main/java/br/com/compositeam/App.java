package br.com.compositeam;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.compositeam.dao.DisciplineDAO;
import br.com.compositeam.model.Discipline;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        
        DisciplineDAO personDAO = context.getBean(DisciplineDAO.class);
         
        Discipline discipline = new Discipline("654","Test");
         
        personDAO.save(discipline);
         
        System.out.println("Person::"+discipline);
         
        
        //close resources
        context.close();    
    }
}
