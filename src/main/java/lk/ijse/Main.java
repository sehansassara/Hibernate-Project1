package lk.ijse;

import lk.ijse.comfit.FactoryConfiguration;
import lk.ijse.embed.FullName;
import lk.ijse.entity.Student;
import lk.ijse.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session= FactoryConfiguration.getInstance().getSession();
        FullName fullName=new FullName("Seha","Sassara");

        Student student=new Student();
        student.setId(1);
        student.setName(fullName);
        student.setAddress("Kegalle");
        //open transaction
        Transaction transaction=session.beginTransaction();

        session.save(student);
        //delete ekai get ekai
        //kohomada thawa table ekk genne


        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("Piyath");
        teacher.setSalary(10000.00);

        session.save(teacher);

        session.update(teacher);

        session.delete(teacher);

        session.get("id",Teacher.class);
        System.out.println(teacher.getId()+teacher.getName()+teacher.getSalary());
        transaction.commit();
        session.close();
    }
}
