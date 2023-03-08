package com.lss.patient.Hospital.hospitalController;

import java.util.List;

import org.hibernate.MultiIdentifierLoadAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lss.patient.Hospital.hospitalEntity.Patient;
import com.lss.patient.Hospital.hospitalService.Service;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	Service service;
	
	@RequestMapping("/getAllData")
	public ModelAndView getAllData() {
		ModelAndView view = new ModelAndView();
		view.setViewName("login");
		
		List<Patient> list =service.getAllData();
		System.out.println("Data fetch...= "+list);

		view.addObject("pakfeok",list);
		return view;
	}
	
	//1.GetData
//	@GetMapping("/get") 
//	public List<Patient> getData() {
//		System.out.println("Data inserted...= ");
//		List<Patient> list = service.getData();
//		return list;
//	}
	//2.GetDataInserted
	@PostMapping("/add")
	public String getDataInserted(@RequestBody List<Patient> pl) {
		System.out.println("coming data: "+pl);
		String add=service.getDataInserted(pl);
		return  add;
	}
	//3.getDataUpdate
	@PutMapping("/update")
	public String getDataUpdate(@RequestBody List<Patient>pa) {
		System.out.println("update data: "+pa);
		String update = service.getDataUpdate(pa);
		return update;
	}
	//4.getGreaterAge
	@PostMapping("/greater")
	public List<Patient> getGreaterAge() {
		System.out.println("In Control: ");
		List<Patient>list=service.getGreaterAge();
		return list;
	}
	//5.getLessAge
	@PutMapping("/less")
	public List<Patient> getLessAge() {
		List<Patient>list=service.getLessAge();
		System.out.println("In Control: "+list);
		return list;
	}
	//6.getEqualAge
	@GetMapping("/equal")
	public List<Patient> getEqualAge() {
		List<Patient> list=service.getEqualAge();
		return list;
	}
	//7.getBetween
	@PostMapping("/between")
	public List<Patient> getBetween() {
		return service.getBetween();
	}
	//8.load
	@GetMapping("/load")
	public List<Patient> load() {
		return service.load();
	}
	//9.ById
	@GetMapping("/byid/{id}")
	public List<Patient> ById(@PathVariable int id) {
		List<Patient> list = service.ById(id);
		return list;
	}
	//10.getUpdate
	@PutMapping("/getUpdate/{id}/{name}")
	public String getUpdate(@PathVariable int id,@PathVariable String name) {
		String gu = service.getUpdate(id, name);
		return gu;
	}
	//11.Like
	@PostMapping("/like")
	public List<Patient> like() {
		return service.like();
	}
	//12.Like2
	@PutMapping("/Like2")
	public List<Patient> like2(){
		return service.like2();
	}
	//13.setProperty
	@GetMapping("/setProperty")
	public String setProperty() {
		return service.setProperty();
	}
	//14.eqOrNull
	@PostMapping("/eqOrNull")
	public List<Patient> eqOrNull(){
		return service.eqOrNull();
	}
	//15.idEqual
	@GetMapping("/idEqual")
	public List<Patient> idEqual(){
		return service.idEqual();
	}
	//16.idEqual
	@GetMapping("/getIdEqual/{id}")
	public List<Patient> getIdEqual(@PathVariable int id){
		return service.getIdEqual(id);
	}
	//17.deleteData
	@DeleteMapping("/deleteData/{id}")
	public String deleteData(@PathVariable int id) {
		
		 return service.deleteData(id);
	}
	//18.ilLike
	@PutMapping("/sname/{name}")
	public List<Patient> ilLike(@PathVariable String name){
		return service.ilLike(name);
	}
	//19.neOrIsNotNull
	@GetMapping("/neOrIsNotNull/{name}")
	public List<Patient> neOrIsNotNull(@PathVariable String name){
		return service.neOrIsNotNull(name);
	}
	//20.getNe
	@GetMapping("/getNe/{village}")
	public List<Patient> getNe(@PathVariable String village){
		return service.getNe(village);
	}
	//21.toString
	@GetMapping("/toString/{name}")
	public String toString(@PathVariable String name) {
		service.toString(name);
		return "In Controller...";
	}
	//22.between
	@GetMapping("/between/{id1}/{id2}")
	public List<Patient> between(@PathVariable int id1,@PathVariable int id2){
		return service.between(id1, id2);
	}
	//23.betweenAge
	@GetMapping("/betweenAge/{age1}/{age2}")
	public List<Patient> betweenName(@PathVariable int age1,@PathVariable int age2){
		return service.betweenName(age1, age2);
	}
	//24.createQuery
	@GetMapping("/createQuery")
	public List<Patient> createQuery(){
		return service.createQuery();
	}
	//25.createSQLQuery
	@PostMapping("/Query")
	public String createSQLQuery() {
		return service.createSQLQuery();
	}
	//26.getLike
	@GetMapping("/getLike/{village}")
	public List<Patient> getLike(@PathVariable String village){
		return service.getLike(village);
	}
	//27.getIn
	@PostMapping("/getIn/{name}")
	public List<Patient> getIn(@PathVariable String name){
		return service.getIn(name);
	}
	//28.getInData
	@PutMapping("/getInData/{village}")
	public List<Patient> getInData(@PathVariable String village){
		return service.getInData(village);
	}
	//29.isNull
	@GetMapping("/isNull")
	public List<Patient> isNull(){
		return service.isNull();
	}
	//30.getisNotNull
	@PutMapping("/getisNotNull/{village}")
	public List<Patient> getisNotNull(@PathVariable String village){
		return service.getisNotNull(village);
	}
	//31.getIsNull
	@PostMapping("/getIsNull/{name}")
	public List<Patient> getIsNull(@PathVariable String name){
		return service.getIsNull(name);
	}
	//32.DataisNull
	@PutMapping("/DataisNull")
	public List<Patient> DataisNull(){
		return service.DataisNull();
	}

	
	
	
	
	
	
	
	
	
}
