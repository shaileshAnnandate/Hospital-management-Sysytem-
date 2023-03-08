package com.lss.patient.Hospital.hospitalService;

import java.util.List;

import org.hibernate.MultiIdentifierLoadAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.lss.patient.Hospital.hospitalDao.Dao;
import com.lss.patient.Hospital.hospitalEntity.Patient;
@org.springframework.stereotype.Service

public class Service {

	@Autowired
	Dao dao;
	
	public List<Patient> getData() {
		List<Patient> list = dao.getData();
		return list;
	}
	public String getDataInserted(List<Patient> pl) {
		String add = dao.getDataInserted(pl);
		return add;
	}
	public String getDataUpdate(List<Patient> pa) {
		System.out.println("In service: "+pa);
		String update=dao.getDataUpdate(pa);
		return update;
	}
	public List<Patient> getGreaterAge() {
		System.out.println("In Service: ");
		List<Patient>list=dao.getGreaterAge();
		return list;
	}
	public List<Patient> getLessAge() {
		List<Patient> list=dao.getLessAge();
		System.out.println("In Service: "+list);
		return list;
	}
	public List<Patient> getEqualAge() {
		List<Patient> list=dao.getEqualAge();
		return list;
	}
	public List<Patient> getBetween() {
		return dao.getBetween();
	}
	public List<Patient> load() {
		return dao.load();
	}
	public List<Patient> ById(int id) {
		List<Patient> list=dao.ById(id);
		return list;
	}
	public String getUpdate(int id,String name) {
		String gu=dao.getUpdate(id, name);
		return gu;
	}
	public List<Patient> like() {
		List<Patient>li=dao.like();
		return li;
	}
	public List<Patient> like2(){
		return dao.like2();
	}
	public String setProperty() {
		return dao.setProperty();
	}
	public List<Patient> eqOrNull() {
		return dao.eqOrNull();
	}
	public List<Patient> idEqual(){
		return dao.idEqual();
	}
	public List<Patient> getIdEqual(int id){
		return dao.getIdEqual(id);
	}
	public String deleteData(int id) {
		
		return dao.deleteData(id);
	}
	public List<Patient> ilLike(String name){
		return dao.ilLike(name);
	}
	public List<Patient> neOrIsNotNull(String name){
		return dao.neOrIsNotNull(name);
	}
	public List<Patient> getNe(String village) {
		return dao.getNe(village);
	}
	public String toString(String name) {
		dao.toString(name);
		return "In Service...";
	}
	public List<Patient> between(int id1,int id2){
		return dao.between(id1, id2);
	}
	public List<Patient> betweenName(int age1,int age2){
		return dao.betweenName(age1, age2);
	}
	public List<Patient> createQuery(){
		return dao.createQuery();
	}
	public String createSQLQuery() {
		return dao.createSQLQuery();
	}
	public List<Patient> getLike(String village){
		return dao.getLike(village);
	}
	public List<Patient> getIn(String name){
		return dao.getIn(name);
	}
	public List<Patient> getInData(String village){
		return dao.getInData(village);
	}
	public List<Patient> isNull(){
		return dao.isNull();
	}
	public List<Patient> getisNotNull(String village){
		return dao.getisNotNull(village);
	}
	public List<Patient> getIsNull(String name){
		return dao.getIsNull(name);
	}
	public List<Patient> DataisNull(){
		return dao.DataisNull();
	}
	public List<Patient> getAllData() {
		
		List<Patient> list = dao.getAllData();
		return list;
	}
	
}
