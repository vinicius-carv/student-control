package com.vinidev.studentcontrol.DAO;

import com.vinidev.studentcontrol.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    private EntityManager entityManager;
    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }
    @Override
    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);
    }
    public List<Student> getAllStudents(){
        return entityManager.createQuery("SELECT p from student p", Student.class).getResultList();
    }
    @Override
    public Student findById(int id){
        return entityManager.find(Student.class, id);
    }
    @Override
    public List<Student> findAll(){
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM student",Student.class);
        return theQuery.getResultList();
    }
    @Override
    public List<Student> findByFName(String firstName){
        TypedQuery<Student> theQuery = entityManager.createQuery("from student where firstName = :firstName",Student.class);
        theQuery.setParameter("firstName", firstName);
        return theQuery.getResultList();
    }
    @Override
    @Transactional
    public void update(Student theStudent){
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void deleteSingle(Integer Id){
        Student theStudent = entityManager.find(Student.class,Id);
        entityManager.remove(theStudent);
    }
    public int deleteMany(){
        int numRowsDeleted = entityManager.createQuery("delete from student where lastName=:lastName", Student.class).executeUpdate();
        return 0;
    }
}
