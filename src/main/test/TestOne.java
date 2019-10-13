import edu.ssm.mapper.StudentMapper;
import edu.ssm.mapper.TestMapper;
import edu.ssm.model.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Blse
 * @date 2019/6/25
 * @description
 */
public class TestOne {


    @Test
    public void testOne() {
        ApplicationContext application = new ClassPathXmlApplicationContext("classpath:beans.xml");
        StudentMapper mapper = application.getBean(StudentMapper.class);
        Student student = new Student();
//        student.setNumber(123);
//        student.setPassword("123465");
        System.out.println(mapper.insert(student));
    }

    @Test
    public void testTwo() {
        ApplicationContext application = new ClassPathXmlApplicationContext("classpath:beans.xml");
        StudentMapper mapper = application.getBean(StudentMapper.class);
        Student student = new Student();
//        student.setNumber(123);
//        student.setPassword("123465");
//        student.setMajor("sss");
//        System.out.println(mapper.selectOne(student).getId());
    }

    @Test
    public void testThree() {
        ApplicationContext application = new ClassPathXmlApplicationContext("classpath:beans.xml");
        StudentMapper mapper = application.getBean(StudentMapper.class);
        Student student = new Student();
        student.setId(1);
//        student.setDirection("sad");
//        mapper.pickDir(student);
    }
}
