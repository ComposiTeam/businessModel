package br.com.compositeam.businessmodel;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.compositeam.businessmodel.dao.DisciplineDAO;
import br.com.compositeam.businessmodel.model.Discipline;

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
