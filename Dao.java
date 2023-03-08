package com.lss.patient.Hospital.hospitalDao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.MultiIdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.spi.SessionFactoryBuilderService;
import org.hibernate.criterion.Restrictions;
import org.omg.CORBA.TRANSACTION_MODE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.lss.patient.Hospital.hospitalEntity.Patient;
@Repository
public class Dao {

	@Autowired
	SessionFactory sf;
	
	//1.getData
	public List<Patient> getData() {
		System.out.println("In dao...= ");
		Session s=sf.openSession();
		Criteria criteria = s.createCriteria(Patient.class);
		return criteria.list();
	}
	//2.getDataInserted
	public String getDataInserted(List<Patient> pl) {
		System.out.println("In dao: "+pl);
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		for (Patient pa : pl) {
			ss.save(pa);			
		}
		tr.commit();
		return "Patient Data save successfully...";
	}
	//3.getDataUpdated
	public String getDataUpdate(List<Patient> pa) {
		System.out.println("In dao: "+pa);
		Session session=sf.openSession();
		Transaction tr = session.beginTransaction();
		for (Patient patient : pa) {
			session.update(patient);
		}
		tr.commit();
		return "Updated Data...";
	}
	//4.getGreaterAge
	public List<Patient> getGreaterAge() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Patient.class);
		criteria.add(Restrictions.gt("age", 23));
		List<Patient> list=criteria.list();
		for (Patient patient : list) {
			System.out.println(patient);
		}
		session.close();
		return list;
	}
	//5.getLessAge
	public List<Patient> getLessAge() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Patient.class);
		criteria.add(Restrictions.lt("age", 25));
		List<Patient> list = criteria.list();
		System.out.println("In dao: "+list);
		for (Patient patient : list) {
			System.out.println(patient);
		}
		session.close();
		return list;
	}
	//6.getEqualAge
	public List<Patient> getEqualAge() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Patient.class);
		criteria.add(Restrictions.eq("age", 25));
		List<Patient> list=criteria.list();
		for (Patient patient : list) {
			System.out.println(patient);
		}
		session.close();
		return list;
	}
	//7.getBetween
	public List<Patient> getBetween() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Patient.class);
		criteria.add(Restrictions.between("name", "A", "P"));
		List<Patient> list= criteria.list();
		for (Patient patient : list) {
			System.out.println(patient);
		}
		session.close();
		return list;
	}
	//8.load
	public List<Patient> load() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Patient.class);
		return criteria.list();
	}
	//9.ById	
	public List<Patient> ById(int id) {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Patient.class);
		criteria.add(Restrictions.eq("id", id));
		List<Patient> list=criteria.list();
		return list;
	}
	//10.getUpdate
	public String getUpdate(int id,String name) {
		Session session=sf.openSession();
		Patient pp=session.load(Patient.class, id);
		Transaction tr = session.beginTransaction();
		pp.setName(name);
		session.update(pp);
		
		tr.commit();
		session.close();
		return "Data Get&Updated...";
	}
	//11.like
	public List<Patient> like() {
		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Patient.class);
		cr.add(Restrictions.like("id", 5));
		List<Patient>list=cr.list();
		return list;
	}
	//12.like2
	public List<Patient> like2() {
		Session ss = sf.openSession();
		Criteria cr=ss.createCriteria(Patient.class);
		cr.add(Restrictions.like("name", "Pavan More"));
		List<Patient> li = cr.list();
		return li;
	}
	//13.setProperty
	public String setProperty() {
		Session ss = sf.openSession();
		Transaction tr=ss.beginTransaction();
		ss.setProperty("id", 7);
		return "In dao: ";
	}
	//14.eqOrNull
	public List<Patient> eqOrNull() {
		Session s = sf.openSession();
		Criteria c =s.createCriteria(Patient.class);
		c.add(Restrictions.eqOrIsNull("name", "pavan more"));
		return c.list();
	}
	//15.idEqual
	public List<Patient> idEqual() {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Patient.class);
		cr.add(Restrictions.idEq(4));
		return cr.list();
	}
	//16.getIdEqualId
	public List<Patient> getIdEqual(int id) {
		Session s = sf.openSession();
		Criteria c = s.createCriteria(Patient.class);
		c.add(Restrictions.idEq(id));
		return c.list();
	}
	//17.deleteData
	public String deleteData(int id) {
		Session ss = sf.openSession();
		Transaction tr=ss.beginTransaction();
		Patient pp=ss.load(Patient.class, id);
		ss.delete(pp);
		tr.commit();
		ss.close();
		return "Data deleted...";
	}
	//18.ilLike
	public List<Patient> ilLike(String name) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Patient.class);
		cr.add(Restrictions.ilike("name", name));
		return cr.list();
	}
	//19.isEmpty
	public List<Patient> neOrIsNotNull(String name) {
		Session s = sf.openSession();
		Criteria c = s.createCriteria(Patient.class);
		c.add(Restrictions.neOrIsNotNull("name", name));
		return c.list();
	}
	//20.getNe
	public List<Patient> getNe(String village) {
		Session s = sf.openSession();
		Criteria c = s.createCriteria(Patient.class);
		c.add(Restrictions.ne("village", village));
		return c.list();
	}
	//21.toString
	public String toString(String name) {
		Session s = sf.openSession();
		Patient pp = new Patient();
		Transaction tr = s.beginTransaction();
		s.toString();
		tr.commit();
		return "Data returned...";
	}
	//22.between
	public List<Patient> between(int id1,int id2) {
		Session s = sf.openSession();
		Criteria c = s.createCriteria(Patient.class);
		c.add(Restrictions.between("id", id1, id2));
		return c.list();
	}
	//23.betweenName
	public List<Patient> betweenName(int age1,int age2){
		Session s = sf.openSession();
		Criteria c = s.createCriteria(Patient.class);
		c.add(Restrictions.between("age", age1, age2));
		return c.list();
	}
	//24.createQuery
	public List<Patient> createQuery() {
		Session s = sf.openSession();
		List<Patient> list=s.createQuery("from Patient").list();
		return list;
	}
	//25.createSQLQuery
	public String createSQLQuery() {
		Session s = sf.openSession();
//		Transaction tr=s.beginTransaction();
		List<Patient> li ;
		s.createSQLQuery("li");
		return "Query...";
	}
	//26.getLike
	public List<Patient> getLike(String village) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Patient.class);
		cr.add(Restrictions.ilike("village", village));
		return cr.list();
	}
	//27.getIn
	public List<Patient> getIn(String name) {
		Session s = sf.openSession();
		Criteria c = s.createCriteria(Patient.class);
		c.add(Restrictions.in("name", name));
		return c.list();
	}
	//28.getInData
	public List<Patient> getInData(String village) {
		Session s = sf.openSession();
		Criteria c = s.createCriteria(Patient.class);
		c.add(Restrictions.in("village", village));
		return c.list();
	}
	//29.isNull
	public List<Patient> isNull() {
		Session s = sf.openSession();
		Criteria c = s.createCriteria(Patient.class);
		c.add(Restrictions.isNull("name"));
		return c.list();
	}
	//30.getisNotNull
	public List<Patient> getisNotNull(String village){
		Session s = sf.openSession();
		Criteria c = s.createCriteria(Patient.class);
		c.add(Restrictions.isNotNull("village"));
		return c.list();
	}
	//31.getIsNull
	public List<Patient> getIsNull(String name) {
		Session s = sf.openSession();
		Criteria c = s.createCriteria(Patient.class);
		c.add(Restrictions.isNull(name));
		return c.list();
	}
	//32.DataisNull
	public List<Patient> DataisNull() {
		Session s = sf.openSession();
		Criteria c = s.createCriteria(Patient.class);
		c.add(Restrictions.isNull("village"));
		return c.list();
	}
	//33.getAllData
	public List<Patient> getAllData() {
		Session s=sf.openSession();
		Criteria c = s.createCriteria(Patient.class);
		List<Patient> list=c.list();
		return list;
	}

	
}
